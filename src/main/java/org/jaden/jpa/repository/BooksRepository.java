package org.jaden.jpa.repository;

import org.jaden.jpa.entity.Books;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by JadenOliver on 2017/7/5.
 */
public interface BooksRepository extends BaseRepository<Books, Integer> {

    @Query("select b from Books b where b.author like ?1%")
    List<Books> findByAuthor(String author);

    int countByAuthor(String author);
}
