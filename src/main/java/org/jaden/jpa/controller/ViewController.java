package org.jaden.jpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by JadenOliver on 2017/7/17.
 *
 * 负责视图跳转
 */
@Controller
public class ViewController {

    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public String viewUpload(){
        return "upload";
    }

    @RequestMapping(value = "/uploadFiles", method = RequestMethod.GET)
    public String viewUploadFiles(){
        return "uploadFiles";
    }

    @RequestMapping(value = "/booksList", method = RequestMethod.GET)
    public String viewBooksList(){
        return "booksList";
    }

    @RequestMapping(value = "/app", method = RequestMethod.GET)
    public String viewApp(){
        return "app";
    }

    @RequestMapping(value = "/bookListBoot", method = RequestMethod.GET)
    public String viewBooksListBoot(){
        return "booksList_bootstrap";
    }


}
