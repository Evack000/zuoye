package com.zs.zuoye.Controller;

import com.zs.zuoye.config.ApiResult;
import com.zs.zuoye.config.ApiResultFactory;
import com.zs.zuoye.dao.CourseregistrationDao;
import com.zs.zuoye.dao.UserDao;
import com.zs.zuoye.entity.Course;
import com.zs.zuoye.entity.LoginToken;
import com.zs.zuoye.entity.User;
import com.zs.zuoye.entityQuery.CoursePageEntityQuery;
import com.zs.zuoye.entityQuery.QueryResult;
import com.zs.zuoye.relations.courseregistration;
import com.zs.zuoye.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CourserController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private UserDao userDao;

    @Autowired
    private CourseregistrationDao dao;

    @PostMapping("/courses")
    public ApiResult<QueryResult<Course>> users(
            @RequestBody CoursePageEntityQuery query) throws IOException {
        LoginToken loginToken=(LoginToken) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        try {
            return ApiResultFactory.getSuccessResult(courseService.result(query));
        }catch (Exception e)
        {
            return ApiResultFactory.getFailResult(e.toString());
        }
    }

    @RequestMapping("/choose")
    public ApiResult<QueryResult<Course>> choose(
            @PathParam("cid")  String cid) throws IOException {

        LoginToken loginToken=(LoginToken) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User xuser = userDao.getUserByName(loginToken.getUsername());
        User user = userDao.getUserCourse(loginToken.getId());
        CoursePageEntityQuery query = new CoursePageEntityQuery();
        query.setStartPer(0);
        query.setPerPage(10);
        boolean flag = true;
        List<Course> list = new ArrayList<Course>();
        if(user==null){
            user = xuser;
        }else {
            list = user.getCourses();
        }
        try {
            if(user.getUserPromission().equals("p2")&&cid.equals("1")){
                return ApiResultFactory.getFailResult("您的权限为p2，不能选此课程");
            }else {
                    for(int i=0;i<list.size();i++){
                        if(String.valueOf(list.get(i).getCourseId()).equals(cid)){
                            flag=false;
                        }
                    }

                if(!flag){
                    return ApiResultFactory.getFailResult("您已选择了这个课程，不能重复选择");
                }else {
                    courseregistration c = new courseregistration(user.getUserId(),Integer.valueOf(cid));
                    dao.addRelation(c);
                    return ApiResultFactory.getSuccessResult(courseService.result(query));
                }
            }
        }catch (Exception e)
        {
            return ApiResultFactory.getFailResult(e.toString());
        }
    }


    @PostMapping("/course/search")
    public ApiResult<QueryResult<Course>> search(
            @RequestBody CoursePageEntityQuery query) throws IOException {
        LoginToken loginToken=(LoginToken)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        try {
            return ApiResultFactory.getSuccessResult(courseService.result(query));
        }catch (Exception e)
        {
            return ApiResultFactory.getFailResult(e.toString());
        }
    }

}
