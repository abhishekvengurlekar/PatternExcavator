package org.PatternExcavator.AssociationRuleMining.DAO;

import org.PatternExcavator.AssociationRuleMining.Exceptions.DAOExceptions.CompanyAlreadyFoundException;
import org.PatternExcavator.AssociationRuleMining.Exceptions.DAOExceptions.ProductAlreadyExistsException;
import org.PatternExcavator.AssociationRuleMining.HibernateEntities.Company;
import org.PatternExcavator.AssociationRuleMining.HibernateEntities.Product;
import org.PatternExcavator.AssociationRuleMining.HibernateEntities.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DAOPatternExcavatorImpl implements DAOSpecification{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public boolean createCompanyRowInDB(String companyName, String companyPassword,String authority) {

        Session session= sessionFactory.openSession();

        org.hibernate.Transaction tx= session.beginTransaction();

        try{

            Company company=new Company(companyName,companyPassword,authority);

            try{

                Company test=getCompanyRowFromDB(companyName);

                if(test!=null){

                    throw new CompanyAlreadyFoundException();

                }

            }catch(Exception e){

                e.printStackTrace();

                return false;

            }

            session.persist(company);

            tx.commit();
            session.close();

            return true;

        }catch (Exception e){

           e.printStackTrace();

            return false;
        }

    }

    @Override
    public Company getCompanyRowFromDB(String companyName) {

        Session session= sessionFactory.openSession();

        org.hibernate.Transaction tx= session.beginTransaction();

        try{

            Company company=new Company(session.load(Company.class,companyName));

            tx.commit();

            session.close();

            return company;

        }catch(Exception e){

            e.printStackTrace();

        }

        return  null;
    }

    @Override
    public boolean removeCompanyRowAndTransactionsFromDB(String CompanyName) {

        Session session=sessionFactory.openSession();

        org.hibernate.Transaction tx= session.beginTransaction();

        try{

            Company company =session.load(Company.class,CompanyName);

            session.delete(company);

            tx.commit();

            session.close();

            return true;

        }catch(Exception e){

            e.printStackTrace();

            return false;

        }
    }

    @Override
    public boolean updateCompanyRowPasswordInDB(String companyName, String newPassword) {

        Session session=sessionFactory.openSession();

        org.hibernate.Transaction tx=session.beginTransaction();

        //Change this when we will use PasswordEncoders
        try{

            Company company=session.load(Company.class,companyName);

            BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
            newPassword=bCryptPasswordEncoder.encode(newPassword);
            company.setCompanyPassword(newPassword);

            tx.commit();

            session.close();

            return true;

        }catch(Exception e){

            e.printStackTrace();
            return false;

        }

    }

    @Override
    public boolean addTransactionsForCompanyInDB(String companyName, List<Transaction> list) {

        Session session= sessionFactory.openSession();

        org.hibernate.Transaction tx=session.beginTransaction();

        try{

            Company company=session.get(Company.class,companyName);

           /* for(Transaction transaction:list){

                transaction.setCompany(company);

               // session.persist(transaction);
            }*/

            for(Transaction transaction:list){

                List<Product> newProductListForTransaction=new ArrayList<>();

                List<Product> productList=transaction.getProducts();
                transaction.setProducts(null);

                for(Product product:productList){
                    Product fromDB=session.get(Product.class,product.getProductName());
                    System.out.println(fromDB);
                    if(fromDB==null){
                        newProductListForTransaction.add(product);
                    }else{
                        newProductListForTransaction.add(fromDB);
                    }

                }
                transaction.setProducts(newProductListForTransaction);
                transaction.setCompany(company);

                session.persist(transaction);
            }




            tx.commit();
            session.close();
            return true;

        }catch(Exception e){

            e.printStackTrace();
            return false;
        }

    }

    @Override
    public List<Transaction> getTransactionsForCompanyFromDB(String companyName) {

        Session session= sessionFactory.openSession();
        org.hibernate.Transaction tx= session.beginTransaction();


        try{

            List<Transaction> transactions=session.load(Company.class,companyName).getTransactions();

            //don't close session before retrieving the lazy loaded data for Products.
            //make sure to load all the data here before closing session otherwise Exception will come!
            for(Transaction transaction:transactions){
               transaction.getProducts().get(0);
            }

            tx.commit();
            session.close();


            return transactions;

        }catch (Exception e){

            e.printStackTrace();
            return null;

        }
    }

    @Override
    public boolean createProductRowInDB(String productName, int costPrice, int sellingPrice) {

        Session session= sessionFactory.openSession();
        org.hibernate.Transaction tx= session.beginTransaction();

        try{

            Product product=new Product(productName,costPrice,sellingPrice);

            try{

                Product test=getProductRowFromDB(productName);

                if(test!=null){

                    throw new ProductAlreadyExistsException();
                }

            }catch(Exception e){

                e.printStackTrace();
                return false;
            }

            session.persist(product);
            tx.commit();
            session.close();
            return true;

        }catch(Exception e){

            e.printStackTrace();
            return false;

        }

    }

    @Override
    public Product getProductRowFromDB(String productName) {

        Session session= sessionFactory.openSession();
        org.hibernate.Transaction tx= session.beginTransaction();

        try{

            Product product=session.get(Product.class,productName);

            tx.commit();
            session.close();

            return product;


        }catch(Exception e){
            e.printStackTrace();
            return null;

        }

    }
}
