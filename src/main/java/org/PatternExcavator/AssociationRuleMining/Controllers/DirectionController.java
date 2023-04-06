package org.PatternExcavator.AssociationRuleMining.Controllers;

import org.PatternExcavator.AssociationRuleMining.Apriori.AprioriMiner;
import org.PatternExcavator.AssociationRuleMining.Apriori.AssociationRule;
import org.PatternExcavator.AssociationRuleMining.Apriori.FrequencyReFilling;
import org.PatternExcavator.AssociationRuleMining.Apriori.FrequentItemSet;
import org.PatternExcavator.AssociationRuleMining.DAO.DAOPatternExcavatorImpl;
import org.PatternExcavator.AssociationRuleMining.DAO.SpringSecurityDAO;
import org.PatternExcavator.AssociationRuleMining.HibernateEntities.Company;
import org.PatternExcavator.AssociationRuleMining.HibernateEntities.Product;
import org.PatternExcavator.AssociationRuleMining.HibernateEntities.Transaction;
import org.PatternExcavator.AssociationRuleMining.SpringSecurity.HibernateUserDetailsService;
import org.PatternExcavator.AssociationRuleMining.SpringSecurity.LightWeightCompany;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.hql.internal.ast.tree.TableReferenceNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Query;
import java.time.LocalDateTime;
import java.util.*;

@RestController
public class DirectionController {

    @Autowired
    SessionFactory sessionFactory;
    @Autowired
    DAOPatternExcavatorImpl daoPatternExcavator;

    @Autowired
    AprioriMiner miner;

    @Autowired
    SpringSecurityDAO springSecurityDAO;

    @Autowired
    HibernateUserDetailsService userDetailsService;

    @Autowired
    DAOPatternExcavatorImpl getDaoPatternExcavator;

    @Autowired
    FrequencyReFilling frequencyReFilling;

    @PostMapping("/hello")
    public ResponseEntity<List<Transaction>> hello(){

        //Session session=sessionFactory.openSession();

        //org.hibernate.Transaction tx=session.beginTransaction();

        /*Transaction transaction=new Transaction();
        Transaction transaction1=new Transaction();
        Transaction transaction2=new Transaction();

        transaction.setDateTime(LocalDateTime.of(2023,02,19,10,51,11,11));
        transaction1.setDateTime(LocalDateTime.of(1999,2,1,12,40,11,11));
        transaction2.setDateTime(LocalDateTime.of(1989,1,3,13,45,11,11));


        List<Transaction> list=new ArrayList<>();
        list.add(transaction);
        list.add(transaction1);
        list.add(transaction2);

        Company company=new Company("More Mega","abc","company");
        company.setTransactions(list);


        session.persist(company);*/


       /* org.hibernate.query.Query<Transaction> query=
                session.createQuery("from Transaction where company.companyName='Gangwals'", Transaction.class);

        List<Transaction> list= query.getResultList();

        for(Transaction transaction:list){
            System.out.println(transaction.getTransactionId()+" "+transaction.getDateTime()+" "+transaction.getCompany().getCompanyName()+" "+transaction.getProducts().get(0).getProductName());
        }


        tx.commit();
        session.close();
        sessionFactory.close();*/
        //String companyName="abhi";

        /*List<Transaction> list=daoPatternExcavator.getTransactionsForCompanyFromDB(companyName);
        for(Transaction transaction:list){
            System.out.println(transaction.getTransactionId());
        }*/

        //List<FrequentItemSet> list=miner.getAllFrequentItemSets(companyName,2);
        /*List<AssociationRule> rules=miner.getAllStrongAssociationRules(companyName,2,50);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        for(AssociationRule frequentItemSet:rules){
            System.out.println(frequentItemSet.toString());
        }*/

        /*List<AssociationRule> interestingRules=miner.getAllInterestingRules("abhi",2,70);

        System.out.println(interestingRules);*/
       // List<Transaction> list= getDaoPatternExcavator.getTransactionsForCompanyFromDB("abhi");

        //System.out.println(list);

        /*String a[] = new String[] { "A", "B"};
        int amount=100;
        int  val[] = {1, 30},
        wt[]  = {1, 50};

        List<String> allProductsName=new ArrayList<>();
        List<Integer> allProductsMargin=new ArrayList<>();
        List<Integer> allProductsCostPrice=new ArrayList<>();

        for(int i=0;i<a.length;i++){
            allProductsName.add(a[i]);
        }
        for(int i=0;i<a.length;i++){
            allProductsMargin.add(val[i]);
        }
        for(int i=0;i<a.length;i++){
            allProductsCostPrice.add(wt[i]);
        }

        frequencyReFilling.recursion(amount,new HashMap<>(),0,allProductsName,allProductsMargin,allProductsCostPrice,0);
        System.out.print(frequencyReFilling.finalRefillingProducts);
        System.out.print(frequencyReFilling.max);*/




        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.OK);

    }

}
