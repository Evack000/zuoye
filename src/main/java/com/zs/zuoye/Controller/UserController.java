package com.zs.zuoye.Controller;

import com.zs.zuoye.config.ApiResult;
import com.zs.zuoye.config.ApiResultFactory;
import com.zs.zuoye.entity.LoginToken;
import com.zs.zuoye.entity.PwdInfo;
import com.zs.zuoye.entity.User;
import com.zs.zuoye.entityQuery.QueryResult;
import com.zs.zuoye.entityQuery.UserInfoPageEntityQuery;
import com.zs.zuoye.service.RoleService;
import com.zs.zuoye.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.ParseException;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @PostMapping("/users")
    public ApiResult<QueryResult<User>> users(
            @RequestBody UserInfoPageEntityQuery query) throws IOException {
        LoginToken loginToken=(LoginToken)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        try {
            return ApiResultFactory.getSuccessResult(userService.result(query));
        }catch (Exception e)
        {
            return ApiResultFactory.getFailResult(e.toString());
        }
    }

    @PutMapping("/editPassword")
    public ApiResult editPwd(@RequestBody PwdInfo pwd) throws ParseException {
        Authentication author = SecurityContextHolder.getContext().getAuthentication();
        LoginToken loginToken=(LoginToken)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User loginUser = userService.getUserInfo(loginToken.getUsername());

        if(!loginUser.getUserPwd().equals(pwd.oldpwd)){
            return new ApiResult(false,"您输入的密码有误","");
        }else {
            loginUser.setUserPwd(pwd.newpwd);
            userService.updateUser(loginUser);
            return new ApiResult(true,"修改成功","");
        }
    }

}
