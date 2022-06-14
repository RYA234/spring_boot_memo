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
    @RequestMapping(value = "thymeleaf/list", method = RequestMethod.GET)
    public String thymeleafListController()
    {
        return "thymeleaf/list";
    }

    @RequestMapping(value = "thymeleaf/1_menu", method = RequestMethod.GET)
    public String thymeleaf_1_menuController()
    {
        return "thymeleaf/1_menu";
    }

    @RequestMapping(value = "thymeleaf/2_menu", method = RequestMethod.GET)
    public String thymeleaf_2_menuController()
    {
        return "thymeleaf/2_menu";
    }

    @RequestMapping(value = "thymeleaf/3_menu", method = RequestMethod.GET)
    public String thymeleaf_3_menuController()
    {
        return "thymeleaf/3_menu";
    }

    @RequestMapping(value = "thymeleaf/4_menu", method = RequestMethod.GET)
    public String thymeleaf_4_menuController()
    {
        return "thymeleaf/4_menu";
    }

    @RequestMapping(value = "thymeleaf/5_menu", method = RequestMethod.GET)
    public String thymeleaf_5_menuController()
    {
        return "thymeleaf/5_menu";
    }
}
