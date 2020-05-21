package com.syzx.demo.controller;

import com.syzx.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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



    @GetMapping("/loginError")
    public String loginError(){
        return "loginError";
    }

    @GetMapping("/api/count")
    public String count(){
        return "/count";
    }

    @GetMapping("/api/testhistory")
    public String ttt(){
        return "/testhistory";
    }

    @GetMapping("/api/pwdEdit")
    public String pwdEdit(){
        return "/pwdEdit";
    }

    @GetMapping("/login")
    public String login(){
        return "/login";
    }

    @GetMapping("/api/temperature")
    public String temperature(){
        return "/temperature";
    }

    @GetMapping("/api/location")
    public String location(){
        return "/location";
    }

    @GetMapping("/api/temperatureMap")
    public String temperatureMap(){
        return "/temperatureMap";
    }

    @GetMapping("/api/user")
    public String user(){
        return "/user";
    }

    @GetMapping("/api/role")
    public String role(){
        return "/role";
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
            model.addAttribute("name",user.getUsername());
        }
        return "/index";
    }
}
