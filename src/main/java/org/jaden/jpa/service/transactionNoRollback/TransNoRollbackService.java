package org.jaden.jpa.service.transactionNoRollback;

import net.sf.ehcache.transaction.xa.EhcacheXAException;
import org.jaden.jpa.entity.Books;
import org.jaden.jpa.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.HashMap;
import java.util.Map;

//AOP声明式事务，未正常回滚---问题探究
@Service
public class TransNoRollbackService {
    @Autowired
    private BooksRepository booksRepository;

    //inner method
    public Books addBook(Books book){  //将会被加上事务，则事务可以回滚---但是这个事务是在Repository的save方法上有一个@Transactional标签。
        return booksRepository.save(book);
    }

    //1.Service方法内部调用
    public void synBooks(Books book1, Books book2){  //外部事务未开启且readOnly=true，则方法内部出现异常时事务无法回滚
        addBook(book1);    //service内部方法，此方法会被加上事务。

        Map map = new HashMap();
        map.put("a","JadenOliver");
        int a = (int)map.get("a");  //手动抛出ClassCastException

        addBook(book2);

    }//end method


    //2.try-catch异常
    public void addBookHaveException(Books book1, Books book2) throws MyCheckedException {
        try {

            booksRepository.save(book1);

            Map map = new HashMap();
            map.put("a","JadenOliver");
            int a = (int)map.get("a");  //手动抛出ClassCastException

            booksRepository.save(book2);

        }catch (Exception e){
            //throw new MyRuntimeException();  //捕获异常，抛出自定义RuntimeException，事务可正常回滚
            throw new MyCheckedException();  //捕获异常，抛出自定义CheckedException，事务不能正常回滚

        }
    }//end method

}
