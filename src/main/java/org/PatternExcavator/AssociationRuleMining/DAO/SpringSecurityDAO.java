package org.PatternExcavator.AssociationRuleMining.DAO;

import org.PatternExcavator.AssociationRuleMining.HibernateEntities.Company;
import org.PatternExcavator.AssociationRuleMining.SpringSecurity.LightWeightCompany;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

@Repository
public class SpringSecurityDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    DAOPatternExcavatorImpl daoPatternExcavator;





    public LightWeightCompany loadUserByUserName(String userName){

        Session session= sessionFactory.openSession();
        Transaction tx=session.beginTransaction();

        try{

            LightWeightCompany lightWeightCompany=new LightWeightCompany(session.load(Company.class,userName));

            tx.commit();
            session.close();

            return lightWeightCompany;

        }catch(Exception e){

            e.printStackTrace();

            return null;

        }
    }

    public boolean addCompanyRowInB(String companyName,String companyPassword){

        String cryptPassword=new BCryptPasswordEncoder().encode(companyPassword);

        String authority="company";

        boolean decision=daoPatternExcavator.createCompanyRowInDB(companyName,cryptPassword,authority);

        if(decision==false){

            return false;

        }else{

            return true;

        }


    }
}
