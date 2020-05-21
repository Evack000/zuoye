package com.zs.zuoye.config;

import com.zs.zuoye.dao.UserDao;
import com.zs.zuoye.entity.LoginToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component("ctwAuthenticationSuccessHandler")
public class CtwAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserDao userDao;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        logger.info("登录成功！");
        if(request.getParameter("loginType").equals("mobile")){
            response.setContentType("application/json;charset=UTF-8");
            LoginToken loginToken=(LoginToken) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            response.getWriter().append("mobile");
        }else {
            // 会帮我们跳转到上一次请求的页面上
            super.onAuthenticationSuccess(request, response, authentication);
            //request.getRequestDispatcher("/loginError").forward(request, response);
        }
    }


}
