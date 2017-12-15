package org.jaden.jpa.service;

import org.jaden.jpa.entity.Books;
import org.jaden.jpa.repository.BooksRepository;
import org.jaden.jpa.repository.specifications.BookSpecs;
import org.jaden.jpa.vo.BooksVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    //分页查询
    public Page<Books> getBooksList(int page, int size, BooksVo booksVo){

        Page<Books> booksList = booksRepository.findAll(BookSpecs.findBooksByConditions(booksVo), new PageRequest(page, size));
        return booksList;
    }


    public Books addBook(Books book){
        return booksRepository.save(book);
    }

    public Books editBook(Books book){
        book.setUpdateTime(new Date());
        return booksRepository.save(book);
    }

}
