package org.jaden.jpa.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by JadenOliver on 2017/7/5.
 */
@Entity
public class Student {
    private String stuId;
    private String stuName;
    private Integer gender;

    private String className;
    private Date cTime;
    private Date uTime;


    //学生选课成绩---begin
    private List<Course> courseList = new ArrayList<Course>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "STU_COURSE",
            joinColumns = { @JoinColumn(name = "STU_ID") },
            inverseJoinColumns = { @JoinColumn(name = "C_ID") })
    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }
    //学生选课成绩---end


    //班主任信息---begin
    //将student表中的tId列，映射为Teacher实体；然后不能再次为tId添加对应的get、set方法，否则会报错 Repeated Column
    private Teacher teacher;

    //Oweing side
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "T_ID")
    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
    //班主任信息---end

    //学生额外信息---begin
    private StudentExtraInfo studentExtraInfo;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "student", cascade = CascadeType.ALL)
    public StudentExtraInfo getStudentExtraInfo() {
        return studentExtraInfo;
    }

    public void setStudentExtraInfo(StudentExtraInfo studentExtraInfo) {
        this.studentExtraInfo = studentExtraInfo;
    }
    //学生额外信息---end


    @Id
    @Column(name = "STU_ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    @Basic
    @Column(name = "STU_NAME")
    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    @Basic
    @Column(name = "GENDER")
    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "CLASS_NAME")
    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Basic
    @Column(name = "C_TIME")
    public Date getcTime() {
        return cTime;
    }

    public void setcTime(Date cTime) {
        this.cTime = cTime;
    }

    @Basic
    @Column(name = "U_TIME")
    public Date getuTime() {
        return uTime;
    }

    public void setuTime(Date uTime) {
        this.uTime = uTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (stuId != null ? !stuId.equals(student.stuId) : student.stuId != null) return false;
        if (stuName != null ? !stuName.equals(student.stuName) : student.stuName != null) return false;
        if (gender != null ? !gender.equals(student.gender) : student.gender != null) return false;
        if (className != null ? !className.equals(student.className) : student.className != null) return false;
        if (cTime != null ? !cTime.equals(student.cTime) : student.cTime != null) return false;
        if (uTime != null ? !uTime.equals(student.uTime) : student.uTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = stuId != null ? stuId.hashCode() : 0;
        result = 31 * result + (stuName != null ? stuName.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (className != null ? className.hashCode() : 0);
        result = 31 * result + (cTime != null ? cTime.hashCode() : 0);
        result = 31 * result + (uTime != null ? uTime.hashCode() : 0);
        return result;
    }


}
