package com.example.spring_boot_memo.thymeleaf;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

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
    public String thymeleaf_3_menuController(Model model,@ModelAttribute ModelForm modelForm)
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

    @RequestMapping(value = "thymeleaf/1_menu", params = "OK", method = RequestMethod.POST)
    public String thymeleaf_1_menuOkController(Model model)
    {
        int Count = 1234;
        model.addAttribute("CountName",Count);
        return "thymeleaf/1_menu_ok";
    }

    @RequestMapping(value = "thymeleaf/1_menu", params = "NG", method = RequestMethod.POST)
    public String thymeleaf_1_menuNgController(Model model)
    {
        int Count = 1234;
        model.addAttribute("CountName",Count);
        return "thymeleaf/1_menu_ng";
    }

    @RequestMapping(value = "thymeleaf/2_menu", params = "OK", method = RequestMethod.POST)
    public String thymeleaf_2_menuOkController(Model model)
    {
        ModelForm modelForm = new ModelForm();
        modelForm.setCount(123);
        modelForm.setName("NAMAE");
        model.addAttribute(modelForm);

        return "thymeleaf/2_menu_ok";
    }

    @RequestMapping(value = "thymeleaf/2_menu", params = "NG", method = RequestMethod.POST)
    public String thymeleaf_2_menuNgController(Model model)
    {
        ModelForm modelForm = new ModelForm();
        modelForm.setCount(123);
        modelForm.setName("NAMAE");

        model.addAttribute(modelForm);

        return "thymeleaf/2_menu_ng";
    }

    @RequestMapping(value = "thymeleaf/3_menu", params = "OK", method = RequestMethod.POST)
    public String thymeleaf_3_menuOkController(Model model,ModelForm modelForm)
    {
        System.out.print("3_okのmodelFormについて");
        System.out.print(modelForm);
        return "thymeleaf/3_menu_ok";
    }

    @RequestMapping(value = "thymeleaf/3_menu", params = "NG", method = RequestMethod.POST)
    public String thymeleaf_3_menuNgController(Model model,ModelForm modelForm)
    {
        System.out.print("3_ngのmodelFormについて");
        System.out.print(modelForm);
        return "thymeleaf/3_menu_ng";
    }

    @RequestMapping(value = "thymeleaf/4_menu", params = "OK", method = RequestMethod.POST)
    public String thymeleaf_4_menuOkController(Model model)
    {
        List<ModelForm> list = new ArrayList<ModelForm>();
        ModelForm  modelForm = new ModelForm();
        modelForm.setCount(1);
        modelForm.setName("aaaaa");
        list.add(modelForm);

        modelForm.setCount(2);
        modelForm.setName("ABABAAA");
        list.add(modelForm);

        modelForm.setCount(3);
        modelForm.setName("CACAAA");
        list.add(modelForm);

        model.addAttribute("list",list);
        System.out.print("4_okのlist_OKについて");
        System.out.print(list);
        return "thymeleaf/4_menu_ok";
    }

    @RequestMapping(value = "thymeleaf/4_menu", params = "NG", method = RequestMethod.POST)
    public String thymeleaf_4_menuNgController(Model model)
    {
        List<ModelForm> list = new ArrayList<>();
        ModelForm  modelForm = new ModelForm();
        modelForm.setCount(1);
        modelForm.setName("aaaaa");
        list.add(modelForm);

        modelForm.setCount(2);
        modelForm.setName("ABABAAA");
        list.add(modelForm);

        modelForm.setCount(3);
        modelForm.setName("CACAAA");
        list.add(modelForm);

        model.addAttribute(list);

        System.out.print("4_okのlist_NGについて");
        System.out.print(list);

        return "thymeleaf/4_menu_ng";
    }
}
