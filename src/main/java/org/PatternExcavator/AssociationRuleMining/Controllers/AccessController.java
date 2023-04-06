package org.PatternExcavator.AssociationRuleMining.Controllers;

import org.PatternExcavator.AssociationRuleMining.DAO.SpringSecurityDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AccessController {

    @Autowired
    SpringSecurityDAO securityDAO;

    @RequestMapping(path = "/")
    public String homePage() {

        return "HomePage";

    }

   @GetMapping(path="/register")
    public String getRegisterPage(){

        return "Register";
    }

    @PostMapping(path = "/processRegisterAndShowUserPage")
    public String resolveRegisterDataAndReturnHomePage(@RequestParam(name = "username") String username,@RequestParam(name = "password") String password){

       boolean result=securityDAO.addCompanyRowInB(username,password);

       if(!result){
           return "Error";
       }

        return "HomePage";
    }

    @RequestMapping(path="/showUserPage")
    public String showUserPage(){

        return "UserPage";
    }

    @ExceptionHandler
    public String exceptionHandler(Exception e){
        e.printStackTrace();
        return "Error";
    }






}
