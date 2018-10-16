package org.jaden.jpa.controller;

import org.jaden.jpa.entity.Books;
import org.jaden.jpa.service.transactionNoRollback.TransNoRollbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Controller
@RequestMapping("trans")
public class TransNoRollbackController {

    @Autowired
    private TransNoRollbackService transNoRollbackService;

    @RequestMapping(value = "/noRollback", method = RequestMethod.GET)
    public void booksList(HttpServletRequest request, HttpServletResponse response){
        Books book = new Books();
        book.setName("Spring事务未回滚研究111");
        book.setDescription("好好学习，天天向上");
        book.setCreateTime(new Date());

        Books book2 = new Books();
        book2.setName("Spring事务未回滚研究222");
        book2.setDescription("好好学习，天天向上");
        book2.setCreateTime(new Date());

        transNoRollbackService.synBooks(book, book2);

        /*try{
            transNoRollbackService.addBookHaveException(book, book2);
        }catch (Exception e){
            e.printStackTrace();
        }*/


    }
}
