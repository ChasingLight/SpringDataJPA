package org.jaden.jpa.repository;

import org.jaden.jpa.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by JadenOliver on 2017/7/5.
 */
public interface TeacherRepository extends JpaRepository<Teacher, String> {

    public Teacher findByTId(String tId);
}
