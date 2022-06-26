package com.example.spring_boot_memo.validation;


import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;

@org.springframework.stereotype.Controller
public class MainController {

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String indexController(Model model,ModelStaff modelStaff)
    {
        System.out.println("aaa");

//        model.addAttribute("modelStaff",modelStaff);

        return "index";
    }

    @RequestMapping(value = "validation/main", method = RequestMethod.GET)
  //  public String indexController(Model model)
    public String validationController(Model model)
    {
        System.out.println("aaa");
        ModelStaff modelStaff = new ModelStaff();
        model.addAttribute("modelStaff",modelStaff);

        return "validation/main";
    }


    @RequestMapping(value = "validation/check",params ="OK", method = RequestMethod.POST)
//    public String validationCheckaaController( Model model) throws IOException
    public String validationCheckController(Model model, @Validated ModelStaff modelStaff, BindingResult bindingResult) throws IOException
    {


        System.out.println(modelStaff);
        if(bindingResult.hasErrors())
        {
            model.addAttribute("modelStaff",modelStaff);
            return "validation/main";
        }

        return "validation/check";
    }

}
