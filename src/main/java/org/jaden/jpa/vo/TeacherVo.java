package org.jaden.jpa.vo;

import javax.persistence.Entity;

/**
 * Created by JadenOliver on 2017/7/6.
 */
@Entity
public class TeacherVo {
    private String tId;
    private String tName;
    private Integer tGender;
    private Integer tAge;
    private String tSubject;  //课程名称

    public String gettId() {
        return tId;
    }

    public void settId(String tId) {
        this.tId = tId;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public Integer gettGender() {
        return tGender;
    }

    public void settGender(Integer tGender) {
        this.tGender = tGender;
    }

    public Integer gettAge() {
        return tAge;
    }

    public void settAge(Integer tAge) {
        this.tAge = tAge;
    }

    public String gettSubject() {
        return tSubject;
    }

    public void settSubject(String tSubject) {
        this.tSubject = tSubject;
    }
}
