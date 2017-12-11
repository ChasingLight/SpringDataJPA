package org.jaden.jpa.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by JadenOliver on 2017/7/5.
 */
@Entity
public class Course {
    private String cId;
    private String cName;
    private String cRemark;
    private Integer cGrade;
    private Date cTime;
    private Date uTime;

    //选修课程的同学信息---begin
    @Transient
    private List<Student> studentList = new ArrayList<Student>();

    @ManyToMany( mappedBy = "courseList")  //, fetch = FetchType.EAGER LAZY
    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
    //选修课程的同学信息---end

    @Id
    @Column(name = "C_ID")
    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    @Basic
    @Column(name = "C_NAME")
    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    @Basic
    @Column(name = "C_REMARK")
    public String getcRemark() {
        return cRemark;
    }

    public void setcRemark(String cRemark) {
        this.cRemark = cRemark;
    }

    @Basic
    @Column(name = "C_GRADE")
    public Integer getcGrade() {
        return cGrade;
    }

    public void setcGrade(Integer cGrade) {
        this.cGrade = cGrade;
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

        Course course = (Course) o;

        if (cId != null ? !cId.equals(course.cId) : course.cId != null) return false;
        if (cName != null ? !cName.equals(course.cName) : course.cName != null) return false;
        if (cRemark != null ? !cRemark.equals(course.cRemark) : course.cRemark != null) return false;
        if (cGrade != null ? !cGrade.equals(course.cGrade) : course.cGrade != null) return false;
        if (cTime != null ? !cTime.equals(course.cTime) : course.cTime != null) return false;
        if (uTime != null ? !uTime.equals(course.uTime) : course.uTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cId != null ? cId.hashCode() : 0;
        result = 31 * result + (cName != null ? cName.hashCode() : 0);
        result = 31 * result + (cRemark != null ? cRemark.hashCode() : 0);
        result = 31 * result + (cGrade != null ? cGrade.hashCode() : 0);
        result = 31 * result + (cTime != null ? cTime.hashCode() : 0);
        result = 31 * result + (uTime != null ? uTime.hashCode() : 0);
        return result;
    }


}
