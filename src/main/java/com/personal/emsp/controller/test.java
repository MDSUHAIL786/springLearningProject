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


        //for create the employee
        Employee emp=new Employee();
        emp.setEmail("Sahil09.saifi@gmail.com");
        emp.setFirstName("Sahil");
        emp.setPassword("lsfdjoasjxci088");
        emp.setLastName("Saifi");


        //for update the employee
        Employee emp2=new Employee();
        emp2.setId(3);                      // should be exist in DB for update and delete
        emp2.setEmail("Sahil09.saifi@gmail.com");
        emp2.setFirstName("Sahil");
        emp2.setPassword("sdfse232");
        emp2.setLastName("Qadri");

        EmployeeDataAccessService dataAccessService= (EmployeeDataAccessService) context.getBean("dataAccessService");
        dataAccessService.insertEmployee(emp);
        dataAccessService.updateEmployee(emp2);
        dataAccessService.deleteEmployee(3);         //give the id of the employee to be deleted
    }


}
