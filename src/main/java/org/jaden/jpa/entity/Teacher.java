package org.jaden.jpa.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JadenOliver on 2017/7/6.
 */
@Entity
public class Teacher {
    private String tId;
    private String tName;
    private Integer tGender;
    private Integer tAge;
    private String tSubject;  //课程名称

    //班主任管理的学生列表---begin
    //@Transient
    private List<Student> studentList = new ArrayList<Student>();

    //Way1--- oweing side
    /*@OneToMany(fetch = FetchType.LAZY)//, mappedBy = "teacher"
    @JoinColumn(name = "T_ID")*/

    //Way2---non-oweing side
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "teacher", cascade = CascadeType.ALL)
    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
    //班主任管理的学生列表---end

    @Id
    @Column(name = "T_ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public String gettId() {
        return tId;
    }

    public void settId(String tId) {
        this.tId = tId;
    }

    @Basic
    @Column(name = "T_NAME")
    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    @Basic
    @Column(name = "T_GENDER")
    public Integer gettGender() {
        return tGender;
    }

    public void settGender(Integer tGender) {
        this.tGender = tGender;
    }

    @Basic
    @Column(name = "T_AGE")
    public Integer gettAge() {
        return tAge;
    }

    public void settAge(Integer tAge) {
        this.tAge = tAge;
    }

    @Basic
    @Column(name = "T_SUBJECT")
    public String gettSubject() {
        return tSubject;
    }

    public void settSubject(String tSubject) {
        this.tSubject = tSubject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Teacher teacher = (Teacher) o;

        if (tId != null ? !tId.equals(teacher.tId) : teacher.tId != null) return false;
        if (tName != null ? !tName.equals(teacher.tName) : teacher.tName != null) return false;
        if (tGender != null ? !tGender.equals(teacher.tGender) : teacher.tGender != null) return false;
        if (tAge != null ? !tAge.equals(teacher.tAge) : teacher.tAge != null) return false;
        if (tSubject != null ? !tSubject.equals(teacher.tSubject) : teacher.tSubject != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tId != null ? tId.hashCode() : 0;
        result = 31 * result + (tName != null ? tName.hashCode() : 0);
        result = 31 * result + (tGender != null ? tGender.hashCode() : 0);
        result = 31 * result + (tAge != null ? tAge.hashCode() : 0);
        result = 31 * result + (tSubject != null ? tSubject.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "tId='" + tId + '\'' +
                ", tName='" + tName + '\'' +
                ", tGender=" + tGender +
                ", tAge=" + tAge +
                ", tSubject='" + tSubject + '\'' +
                '}';
    }
}
