package org.jaden.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;

/**
 * 基本仓库接口
 *
 * 说明：添加了@NoRepositoryBean标注，这样Spring Data Jpa在启动时就不会去实例化BaseRepository这个接口
 * @param <M>
 * @param <ID>
 */
@NoRepositoryBean
public interface BaseRepository<M, ID extends Serializable> extends JpaRepository<M, ID>,JpaSpecificationExecutor<M>,PagingAndSortingRepository<M, ID> {

}
