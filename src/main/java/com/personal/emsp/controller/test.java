package com.personal.emsp.controller;


import com.personal.emsp.das.EmployeeDataAccessService;
import com.personal.emsp.das.entity.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
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

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("context/em_sp_web.xml");

        Employee emp=new Employee();
        emp.setEmail("suhail.saifi@gmail.com");
        emp.setFirstName("Suhail");
        emp.setPassword("dsai");
        emp.setLastName("Ali");
        EmployeeDataAccessService dataAccessService= (EmployeeDataAccessService) context.getBean("dataAccessService");
        dataAccessService.insertEmployee(emp);
    }


}
