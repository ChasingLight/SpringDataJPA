package org.jaden.jpa.repository;

import org.jaden.jpa.entity.Teacher;

/**
 * Created by JadenOliver on 2017/7/5.
 */
public interface TeacherRepository extends BaseRepository<Teacher, String> {

    public Teacher findByTId(String tId);
}
