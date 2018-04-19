package org.jaden.jpa.controller;

import org.jaden.jpa.entity.Student;
import org.jaden.jpa.entity.Teacher;
import org.jaden.jpa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//图书控制器
@Controller
@RequestMapping("student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    //测试事务管理器，回滚
    @RequestMapping(value = "/testTrans", method = RequestMethod.GET)
    @ResponseBody
    public Student saveStudnet(HttpServletRequest request, HttpServletResponse response){

        Student stu = new Student();
        stu.setStuName("靳浩东");
        stu.setGender(1);
        stu.setClassName("计科1201##########################################################################################################################################");
        stu.setcTime(new Date());

        Teacher teacher = new Teacher();
        teacher.settName("张玉宏");
        teacher.settAge(20);

        //级联设置---begin
        stu.setTeacher(teacher);

        List<Student> studentList = new ArrayList<>();
        studentList.add(stu);
        teacher.setStudentList(studentList);
        //级联设置---end

        Student dbStudent = studentService.saveStuAndTeacherAsTrans(stu, teacher);
        dbStudent.setTeacher(null);
        return dbStudent;

    }//end method


}
