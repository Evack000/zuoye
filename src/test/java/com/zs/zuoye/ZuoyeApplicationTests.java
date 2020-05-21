package com.zs.zuoye;

import com.zs.zuoye.dao.CourseDao;
import com.zs.zuoye.dao.CourseregistrationDao;
import com.zs.zuoye.dao.UserDao;
import com.zs.zuoye.entity.Course;
import com.zs.zuoye.entity.User;
import com.zs.zuoye.entityQuery.CoursePageEntityQuery;
import com.zs.zuoye.entityQuery.UserInfoPageEntityQuery;
import com.zs.zuoye.relations.courseregistration;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class ZuoyeApplicationTests {

    @Autowired
    private UserDao userDao;

    @Autowired
    private CourseDao courseDao;

    @Autowired
    private CourseregistrationDao dao;

    @Test
    public void contextLoads() {
        System.out.println(userDao.getUserCourse(4));
    }

    public void relationTest(){
        courseregistration c = new courseregistration(2,2);
        dao.addRelation(c);
    }

    public void courseTest(){
        CoursePageEntityQuery query = new CoursePageEntityQuery();
        query.setPerPage(1);
        query.setStartPer(0);
        List<Course> courses = courseDao.findAll(query);

        System.out.println(courses.size());
    }

    public void userPage(){
        UserInfoPageEntityQuery query = new UserInfoPageEntityQuery();
        query.setStartPer(0);
        query.setPerPage(10);
        List<User> users  = userDao.findAll(query);
        System.out.println(users.size());
    }

    public void userCourseTest(){
        User user = userDao.getUserCourse(1);
        System.out.println(user.getCourses().get(0).getCourseId());
        System.out.println(user.getCourses().get(0).getCourseName());
        System.out.println(user.getCourses().get(0).getCourseDetail());
        System.out.println(user.getCourses().get(1).getCourseId());
        System.out.println(user.getCourses().get(1).getCourseName());
        System.out.println(user.getCourses().get(1).getCourseDetail());
    }

    public void userTest(){
        User user = userDao.getUserByName("rx78");
        System.out.println(user.getUserId());
        System.out.println(user.getRoles().get(0).getName());
        System.out.println(user.getRoles().get(0).getPermissions().get(0).getDescription());
    }

    public void CourseTest(){
       /* List<Course> list = courseDao.findAll();
        System.out.println(list.size());
        System.out.println(list.get(0).getCourseId());
        System.out.println(list.get(0).getCourseName());
        System.out.println(list.get(0).getCourseDetail());*/
    }


}
