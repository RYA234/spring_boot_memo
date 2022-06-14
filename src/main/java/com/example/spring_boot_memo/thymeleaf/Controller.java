package com.example.spring_boot_memo.thymeleaf;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@org.springframework.stereotype.Controller
public class Controller {

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String indexController()
    {
        return "index";
    }

}
