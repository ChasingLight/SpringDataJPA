package org.jaden.jpa.service;

import org.jaden.jpa.entity.Student;
import org.jaden.jpa.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by JadenOliver on 2017/7/5.
 */
@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student findByStuId(String stuId){
        Student dbStudent = studentRepository.findByStuId(stuId);

        //在事务之中，获取懒加载标识的值
        System.out.println("student courseList's size:" + dbStudent.getCourseList().size());

        System.out.println("student's teacher info" + dbStudent.getTeacher().toString());

        //将POJO--->VO，避免级联关系
        /*StudentVo studentVo = new StudentVo();
        BeanUtils.copyProperties(dbStudent, studentVo);*/

        return dbStudent;
    }

}
