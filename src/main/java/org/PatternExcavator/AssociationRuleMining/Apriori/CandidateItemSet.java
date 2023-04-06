package org.PatternExcavator.AssociationRuleMining.Apriori;

import java.util.ArrayList;
import java.util.List;

public class CandidateItemSet implements Comparable<CandidateItemSet>{

    public CandidateItemSet(List<String> candidateItemSet) {
        this.products = candidateItemSet;
    }
    public CandidateItemSet(){

    }

    private String candidateItemSetString;

    private List<String> products =new ArrayList<>();

    private int frequency;

    public String getCandidateItemSetString() {
        return candidateItemSetString;
    }

    public void setCandidateItemSetString(String candidateItemSetString) {
        this.candidateItemSetString = candidateItemSetString;
    }

    public List<String> getProducts() {
        return products;
    }

    public void setProducts(List<String> products) {
        this.products = products;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    @Override
    public int compareTo(CandidateItemSet o) {
        if(this.getFrequency()<=o.getFrequency()){

            return -1;

        }else{

            return 1;

        }

    }
}
