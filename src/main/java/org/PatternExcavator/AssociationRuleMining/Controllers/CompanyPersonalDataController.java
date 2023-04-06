package org.PatternExcavator.AssociationRuleMining.Controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.PatternExcavator.AssociationRuleMining.DAO.DAOPatternExcavatorImpl;
import org.PatternExcavator.AssociationRuleMining.HibernateEntities.DataTaker;
import org.PatternExcavator.AssociationRuleMining.HibernateEntities.Product;
import org.PatternExcavator.AssociationRuleMining.HibernateEntities.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CompanyPersonalDataController {

    @Autowired
    DAOPatternExcavatorImpl daoPatternExcavator;


    @GetMapping(path="/goToCompanyPersonalPage")
    public String ToCompanyPersonalPage1(){

        return "CompanyPersonalPage";

    }

    @PostMapping(path = "/addCompanyData")
    public String addCompanyDataAsJson(@RequestParam(name = "data") String data, Model model) throws Exception{

        Authentication authentication=SecurityContextHolder.getContext().getAuthentication();

        //System.out.println(data);
        ObjectMapper objectMapper=new ObjectMapper();
        DataTaker dataTaker=objectMapper.readValue(data, DataTaker.class);

        List<Transaction> inputData=dataTaker.getTransactionList();

        /*for(Transaction transaction:inputData){
            for(Product product:transaction.getProducts()){
                System.out.println(product.getProductName());
            }
        }*/

        boolean flag=daoPatternExcavator.addTransactionsForCompanyInDB(authentication.getName(),inputData);

        System.out.println(flag);
        if(flag){
            model.addAttribute("flag","Success");
        }else{
            model.addAttribute("flag","could not add the data");
        }

        return "CompanyPersonalPage";

    }

    @PostMapping(path = "/delete")
    public String deleteCompanyDataAndCompany(Model model){

        Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
        String companyName=authentication.getName();

        boolean flag=daoPatternExcavator.removeCompanyRowAndTransactionsFromDB(companyName);

        if(flag){
            model.addAttribute("remove","Company Removed please logout from the system!");

        }else{
            model.addAttribute("remove","could not remove");
        }

        return "CompanyPersonalPage";

    }

    @PostMapping(path = "/update")
    public String updateCompanyPassword(@RequestParam(name = "password") String password,Model model){

        Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
        String companyName=authentication.getName();

        boolean flag=daoPatternExcavator.updateCompanyRowPasswordInDB(companyName,password);

        if(flag){
            model.addAttribute("update","Success");

        }else{

            model.addAttribute("update","Could not update");

        }

        return "CompanyPersonalPage";

    }





}
