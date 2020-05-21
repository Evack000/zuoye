package com.zs.zuoye.config;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component("ctwAuthenticationFailureHandler")
public class CtwAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());


    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException, IOException, ServletException {
        if(request.getParameter("loginType").equals("mobile")){
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().append(JSON.toJSONString("用户名密码错误"));
        }else {
            // 会帮我们跳转到上一次请求的页面上
            //super.onAuthenticationFailure(request, response, exception);
            response.sendRedirect("loginError");
        }
    }
}