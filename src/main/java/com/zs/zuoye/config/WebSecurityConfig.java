package com.zs.zuoye.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity  //启用Spring Security
@EnableGlobalMethodSecurity(prePostEnabled = true)  //会拦截注解了@preAuthrize的方法
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 通过重写configure方法，进行创建用户
     */
/*    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        *//**
         * 基于内存的方式，构建两个用户账号,密码需要加密，不加密会报错
         *//*
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password(pwdEncode().encode("123"))
                .roles("admin");
        auth.inMemoryAuthentication()
                .withUser("user")
                .password(pwdEncode().encode("123"))
                .roles("normal");
    }*/

    @Bean  //注入PasswordEncode  加密 解密
    public PasswordEncoder pwdEncode(){
        return new BCryptPasswordEncoder();
    }


    @Autowired
    private AuthenticationSuccessHandler ctwAuthenticationSuccessHandler;

    @Autowired
    private CtwAuthenticationFailureHandler ctwAuthenticationFailureHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 登录接口
        http.csrf().disable();
        http.
                formLogin().loginPage("/login") //重新定义 登录页面
                .successHandler(ctwAuthenticationSuccessHandler)
                .failureHandler(ctwAuthenticationFailureHandler)
                //.failureUrl("/loginError")
                .and()
                .authorizeRequests()
                .antMatchers("/login","/loginError").permitAll() //允许所有人可以访问登录页面
                .antMatchers("/css/**","/js/**","/images/**","/api/**",
                        "/fonts/**").permitAll()

                .anyRequest().access("@authService.canAccess(request,authentication)") //替代authenticated()

                //.anyRequest().authenticated()  //所有请求都要在登录之后才能进行
        ;

        //自定义filter  登录前，后，登录时
/*      http.addFilterBefore(new BeforeLoginFilter(), UsernamePasswordAuthenticationFilter.class);
        http.addFilterBefore(new AtLoginFilter(), UsernamePasswordAuthenticationFilter.class);
        http.addFilterBefore(new AfterLoginFilter(), UsernamePasswordAuthenticationFilter.class);*/
    }


}
