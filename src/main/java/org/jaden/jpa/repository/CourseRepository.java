package org.jaden.jpa.repository;

import org.jaden.jpa.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by JadenOliver on 2017/7/5.
 */
public interface CourseRepository extends JpaRepository<Course, String> {

    @Query("select c from Course c where c.cId = ?1")
    public Course findByCId(String cId);
}
