package org.jaden.jpa.vo;

import java.util.Date;

/**
 * Created by JadenOliver on 2017/7/5.
 */
public class StudentVo {
    private String stuId;
    private String stuName;
    private Integer gender;

    private String className;
    private Date cTime;
    private Date uTime;

    private TeacherVo teacherVo;

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Date getcTime() {
        return cTime;
    }

    public void setcTime(Date cTime) {
        this.cTime = cTime;
    }

    public Date getuTime() {
        return uTime;
    }

    public void setuTime(Date uTime) {
        this.uTime = uTime;
    }

    public TeacherVo getTeacherVo() {
        return teacherVo;
    }

    public void setTeacherVo(TeacherVo teacherVo) {
        this.teacherVo = teacherVo;
    }
}
