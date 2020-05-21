package com.zs.zuoye.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

  /*  @PostMapping("/login")
    public void login(HttpServletRequest request){
        System.out.println("----------------------------");
        System.out.println(request.getParameter("username"));
        System.out.println("----------------------------");
    }
*/

    @GetMapping("/hello")
    public String hello(){
        return "Hello Spring Security";
    }

    @GetMapping("/hello/helloAdmin")
    //@PreAuthorize("hasAnyRole('admin')")
    public String helloAdmin(){
        return "hello.admin";
    }

    @GetMapping("/hello/helloUser")
    //@PreAuthorize("hasAnyRole('admin','normal')")
    public String helloUser(){
        return "hello.user";
    }


    @PostMapping("/crsf")
    public String txt(){
        System.out.println("crsf-test");
        return "hello.user";
    }


}
