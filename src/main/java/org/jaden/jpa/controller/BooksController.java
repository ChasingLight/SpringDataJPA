package org.jaden.jpa.controller;

import org.apache.commons.lang3.StringUtils;
import org.jaden.jpa.entity.Books;
import org.jaden.jpa.repository.BooksRepository;
import org.jaden.jpa.service.BooksService;
import org.jaden.jpa.vo.BooksVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//图书控制器
@Controller
@RequestMapping("books")
public class BooksController {

    @Autowired
    private BooksService booksService;

    @Autowired BooksRepository booksRepository;

    //图书分页控制器
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView booksList(HttpServletRequest request, HttpServletResponse response){
        String pageStr = request.getParameter("page");
        String sizeStr = request.getParameter("size");

        //默认展示第1页，每一页2条数据
        pageStr = StringUtils.isNotEmpty(pageStr) ? pageStr : "1";
        sizeStr = StringUtils.isNotEmpty(sizeStr) ? sizeStr : "2";

        int page = Integer.parseInt(pageStr);   //第几页
        int size = Integer.parseInt(sizeStr);  //每页条数


        Page<Books> booksPage = this.booksService.getBooksList(page, size, null);

        //Method1:使用JSP的Form表单进行请求
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("booksList");
        modelAndView.addObject("booksList", booksPage.getContent());
        modelAndView.addObject("totalPages", booksPage.getTotalPages());  //总共多少页
        modelAndView.addObject("totalElements", booksPage.getTotalElements());  //总共多少元素
        return modelAndView;


        //Mehotd2:使用ajax请求响应
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("booksList", JSON.toJSONString(booksPage.getContent()));
//        jsonObject.put("totalPages",booksPage.getTotalPages());
//        jsonObject.put("totalElements",booksPage.getTotalElements());
//
//        try {
//            System.out.println(jsonObject.toString());
//            response.getWriter().write(jsonObject.toJSONString());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }//end method

    //图书分页控制器---bootStrap框架
    @RequestMapping(value = "/listBoot", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> booksListBootStrap(@RequestBody BooksVo booksVo) {  //HttpServletRequest request

        int limit = Integer.parseInt(booksVo.getLimit());   //每页多少条记录
        int offset = Integer.parseInt(booksVo.getOffset());   //开始记录下标(从0开始)

        //将bootStrap分页参数，转换为Spring-data-JPA的对应参数
        int page = offset / limit;  //第几页(从0开始)
        int size = limit;

        Page<Books> booksPage = this.booksService.getBooksList(page, size, booksVo);

        //配合前段bootStrap框架使用，返回结果必须包含total、rows两个参数
        Map<String, Object> map = new HashMap<>();
        map.put("rows", booksPage.getContent());
        map.put("total", booksPage.getTotalElements());

        return map;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addBook(Books books, HttpServletResponse response) {
        Map<String, Object> map = new HashMap<>();

        //添加记录创建时间
        books.setCreateTime(new Date());

        Books addBooks = booksService.addBook(books);

        if(addBooks != null){
            map.put("msg","ok");
        }else{
            map.put("msg","error");
        }
    }

    @RequestMapping(value = "/getOne", method = RequestMethod.POST)
    @ResponseBody
    public Books findBooksById(@RequestParam("id") String key){
        return booksRepository.findOne(Integer.parseInt(key));
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> editBook(Books updateBook){
        Map<String, Object> map = new HashMap<>();

        Books dbBook = booksService.editBook(updateBook);
        if (dbBook != null){
            map.put("msg","ok");
        }
        else{
            map.put("msg","error");
        }

        return map;
    }
}
