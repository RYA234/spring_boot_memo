package com.example.spring_boot_memo.SpringSecurity;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@org.springframework.stereotype.Controller
public class Controller {

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String indexController()
    {
        return "index";
    }

    @GetMapping("/login")
    public String getLogin() {
        return "login/login";
    }

    @GetMapping("/check/OK")
    public String getCheckOk()
    {
        return "check/OK";
    }

    // SecurityConfigで/logout→/check/not_accessに遷移する
    @GetMapping("/check/not_access")
    public String getNotAccess()
    {
        return "check/not_access";
    }
    
    @GetMapping("/menu/menu")
    public String getmenu()
    {
        return "menu/menu";
    }
}
