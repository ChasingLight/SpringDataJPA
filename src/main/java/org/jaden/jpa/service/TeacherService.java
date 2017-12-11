package org.jaden.jpa.service;

import org.jaden.jpa.entity.Student;
import org.jaden.jpa.entity.Teacher;
import org.jaden.jpa.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by JadenOliver on 2017/7/5.
 */
@Service
public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    public Teacher findByTeacherId(String tId){
        Teacher dbTeacher = teacherRepository.findByTId(tId);

        List<Student> studentList = dbTeacher.getStudentList();
        System.out.println(dbTeacher.gettName() + "老师，管理" + studentList.size() + "个人!");

        for (Student temp:
             studentList) {
            System.out.println("学生:" + temp.getStuId() + ":" + temp.getStuName());
        }

        return dbTeacher;
    }//end method

}
