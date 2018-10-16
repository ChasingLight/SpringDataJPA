package org.jaden.jpa.repository;

import org.jaden.jpa.entity.Teacher;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by JadenOliver on 2017/7/5.
 */
public interface TeacherRepository extends BaseRepository<Teacher, String> {

    Teacher findByTId(String tId);

    @Modifying
    @Query("update Teacher t set t.tName = ?1 where t.tId = ?2")
    int updateTeacherNameById(String newTname, String tId);  //测试单元测试，默认事务回滚
}
