package org.PatternExcavator.AssociationRuleMining.SpringSecurity;

import org.PatternExcavator.AssociationRuleMining.HibernateEntities.Company;

public class LightWeightCompany {

    public LightWeightCompany(){

    }
    public LightWeightCompany(Company company){

        this.companyName=company.getCompanyName();
        this.companyPassword=company.getCompanyPassword();
        this.authority=company.getAuthority();
    }

    @Override
    public String toString(){
        return this.companyName+" "+this.companyPassword+" "+this.authority;
    }

    private String companyName;
    private String companyPassword;
    private String authority;

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
}
