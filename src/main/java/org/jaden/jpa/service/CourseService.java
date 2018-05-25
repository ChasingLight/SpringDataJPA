package org.jaden.jpa.service;

import org.jaden.jpa.entity.Course;
import org.jaden.jpa.entity.Student;
import org.jaden.jpa.repository.CourseRepository;
import org.jaden.jpa.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by JadenOliver on 2017/7/5.
 */
@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentRepository studentRepository;

    public Course findByCId(String cId){
        Course dbCourse = courseRepository.findByCId(cId);

        //System.out.println("选修" + dbCourse.getcName() + " 课程的，一共有" + dbCourse.getStudentList().size() + "个人!");

        return dbCourse;
    }

    public Course findTestJPA(String cId){
        Course dbCourse = courseRepository.findByCId(cId);

        List<Student> studentList = dbCourse.getStudentList();

        if (studentList.size() == 0){  //此门课程没有关联学生
            Student myStudent = studentRepository.findByStuId("105");
            studentList.add(myStudent);
        }

        return dbCourse;
    }

}
