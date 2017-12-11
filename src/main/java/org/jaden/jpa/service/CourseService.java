package org.jaden.jpa.service;

import org.jaden.jpa.entity.Course;
import org.jaden.jpa.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by JadenOliver on 2017/7/5.
 */
@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public Course findByCId(String cId){
        Course dbCourse = courseRepository.findByCId(cId);

        System.out.println("选修" + dbCourse.getcName() + " 课程的，一共有" + dbCourse.getStudentList().size() + "个人!");

        return dbCourse;
    }

}
