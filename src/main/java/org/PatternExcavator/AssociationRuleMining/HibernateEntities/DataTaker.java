package org.PatternExcavator.AssociationRuleMining.HibernateEntities;

import java.util.List;

public class DataTaker {

    public DataTaker(){

    }

    List<Transaction> transactionList;

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }

    @Override
    public String toString() {
        return "DataTaker{" +
                "transactionList=" + transactionList +
                '}';
    }
}
