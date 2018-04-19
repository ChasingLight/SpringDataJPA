package org.jaden.jpa.service;

import org.jaden.jpa.entity.Student;
import org.jaden.jpa.entity.Teacher;
import org.jaden.jpa.repository.StudentRepository;
import org.jaden.jpa.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by JadenOliver on 2017/7/5.
 */
@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TeacherRepository teacherRepository;

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



    /**
     * 测试xml文件事务管理器，异常回滚sql，rollback-for，read-only属性学习
     * @param stu
     * @param teacher
     * @return
     */
    public Student saveStuAndTeacherAsTrans(Student stu, Teacher teacher) {
        Student dbStudent = null;

        Teacher dbTeacher = teacherRepository.save(teacher);

        try{
            dbStudent = studentRepository.save(stu);   //错误代码，SQL语句错误。用来测试事务，看是否回滚
        }catch (Exception e){
            System.out.println("捕获到事务异常，不处理，不抛出");
        }

        return dbStudent;
    }

}
