package org.jaden.jpa.repository;

import org.jaden.jpa.entity.Student;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by JadenOliver on 2017/7/5.
 */
public interface StudentRepository extends BaseRepository<Student, String> {

    @Query("select s from Student s where s.stuId = ?1")
    public Student findByStuId(String stuId);
}
