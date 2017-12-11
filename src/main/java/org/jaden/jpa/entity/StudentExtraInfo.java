package org.jaden.jpa.entity;

import javax.persistence.*;

/**
 * Created by JadenOliver on 2017/7/12.
 */
@Entity
@Table(name = "student_extra_info")
public class StudentExtraInfo {
    private Integer id;

    private String extraInfo;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    @Basic
    @Column(name = "EXTRA_INFO")
    public String getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }

    //一对一关系---begin
    private Student student;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "STU_ID")
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    //一对一关系---end


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentExtraInfo that = (StudentExtraInfo) o;

        if (!id.equals(that.id)) return false;
        if (!extraInfo.equals(that.extraInfo)) return false;
        return student.equals(that.student);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + extraInfo.hashCode();
        result = 31 * result + student.hashCode();
        return result;
    }
}
