package org.jaden.jpa.service;

import org.jaden.jpa.entity.Books;
import org.jaden.jpa.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by JadenOliver on 2017/7/5.
 */
@Service
public class BooksService {
    @Autowired
    private BooksRepository booksRepository;

    public List<Books> findByAuthor(String authorName){
        return booksRepository.findByAuthor(authorName);
    }

    public int countByAuthor(String author){
        return booksRepository.countByAuthor(author);
    }
}
