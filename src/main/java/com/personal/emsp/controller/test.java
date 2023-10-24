package com.personal.emsp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class test {

    @RequestMapping("/home")
    public String home(Model model){
        model.addAttribute("name","suhail");
        model.addAttribute("id",123);
        model.addAttribute("list",new int[]{1,3,3,4});
        return "addEmp";        //returning the view name i.e test.html
    }

    @RequestMapping("/usingModelView")
    public ModelAndView home(){
        ModelAndView modelandView=new ModelAndView();
        modelandView.addObject("name","suhail");
        modelandView.addObject("id",123);
        modelandView.addObject("list",new int[]{1,3,3,4});
        modelandView.setViewName("updateEmp");   //set the view name i.e updateEmp.jsp
        return modelandView;
    }


}
