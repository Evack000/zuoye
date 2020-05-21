package com.zs.zuoye.Controller;

import com.zs.zuoye.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    //@Cacheable(value = "user", key = "#username")
    public String loginError(){
        return "login";
    }

    @GetMapping("/api/user")
    public String user(){
        return "/user";
    }

    @GetMapping("/api/course")
    public String course(){
        return "/course";
    }

    @GetMapping("/api/pwdEdit")
    public String pwdEdit(){
        return "/pwdEdit";
    }

    @RequestMapping({"","/","/index"})
    public String index(Model model){
        Object pricipal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        //未登录的情况下，返回的是一个字符串 ： anonymousUser
        //登录的情况下，返回的是在CustomUserService的LoadUserByUsernam中Load的User对象
        if("anonymousUser".equals(pricipal)){
            model.addAttribute("name","没有用户登录");
        }else {
            User user = (User)pricipal;
            model.addAttribute("name", user.getUsername());
        }
        return "/index";
    }
}
