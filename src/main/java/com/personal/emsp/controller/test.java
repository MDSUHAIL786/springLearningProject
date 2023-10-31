package com.personal.emsp.controller;

import com.personal.emsp.das.entity.Answer;
import com.personal.emsp.das.entity.Employee;
import com.personal.emsp.das.entity.Question;
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
        Answer a1=new Answer("Airtel");

        Employee emp=new Employee("sahil","khan","sahilkhan@gmail.com","12345678");
        Question q1=new Question();
        q1.setQuestion("Which is your sim?");
        q1.setAnswer(a1);

        Question q2=new Question();
        q2.setQuestion("what is java?");


        session.save(emp);
        session.save(a1);
        session.save(q1);
        session.save(q2);
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
