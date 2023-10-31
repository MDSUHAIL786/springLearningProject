package com.personal.emsp.controller;

import com.personal.emsp.das.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
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
        SessionFactory factory = new Configuration().configure("context/hibernate.cfg.xml").buildSessionFactory();
        Session session=factory.openSession();

        Transaction txn=session.beginTransaction();
        Employee emp=new Employee("sahil","khan","sahilkhan@gmail.com","12345678");
        session.save(emp);
        txn.commit();

//        see difference between get and load in README.txt
        Employee em= session.get(Employee.class,1);
        System.out.println(em.getEmail()+":"+em.getPassword());

        Employee em2= session.load(Employee.class,3);
        System.out.println(em2.getFirstName()+":"+em.getLastName());

        session.close();
        factory.close();
        System.out.println(factory.isClosed());

    }


}
