package org.PatternExcavator.AssociationRuleMining.DAO;

import org.PatternExcavator.AssociationRuleMining.HibernateEntities.Company;
import org.PatternExcavator.AssociationRuleMining.HibernateEntities.Product;
import org.PatternExcavator.AssociationRuleMining.HibernateEntities.Transaction;

import java.util.List;

public interface DAOSpecification {

    public boolean createCompanyRowInDB(String companyName,String companyPassword,String authority);

    public Company getCompanyRowFromDB(String companyName);

    public boolean removeCompanyRowAndTransactionsFromDB(String CompanyName);

    public boolean updateCompanyRowPasswordInDB(String companyName,String newPassword);

    public boolean addTransactionsForCompanyInDB(String companyName, List<Transaction> list);

    public List<Transaction> getTransactionsForCompanyFromDB(String companyName);

    public boolean createProductRowInDB(String productName,int costPrice,int sellingPrice);

    public Product getProductRowFromDB(String productName);

}
