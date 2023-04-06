package org.PatternExcavator.AssociationRuleMining.HibernateEntities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "company")
public class Company {

    public Company(){

    }

    public Company(Company company){
        this.companyName=company.getCompanyName();
        this.companyPassword=company.getCompanyPassword();
        this.authority=company.getAuthority();
        this.transactions=company.getTransactions();
    }

    public Company(String companyName,String companyPassword,String authority){
        this.companyName=companyName;
        this.companyPassword=companyPassword;
        this.authority=authority;
    }

    @Id
    @Column(name = "company_name")
    String companyName;

    @Column(name = "company_password")
    String companyPassword;

    @Column(name = "authority")
    String authority;

    @OneToMany(fetch = FetchType.LAZY,cascade = {CascadeType.REMOVE,CascadeType.PERSIST},mappedBy = "company")
    List<Transaction> transactions;

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {

        this.transactions = transactions;

        biDirectionalLinkage(this.transactions);
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyPassword() {
        return companyPassword;
    }

    public void setCompanyPassword(String companyPassword) {
        this.companyPassword = companyPassword;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public void biDirectionalLinkage(List<Transaction> transactionList){

        for(Transaction transaction:transactionList){

            transaction.setCompany(this);

        }

    }



}
