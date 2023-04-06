package org.PatternExcavator.AssociationRuleMining.Apriori;

import java.beans.FeatureDescriptor;
import java.util.ArrayList;
import java.util.List;

public class FrequentItemSet implements Comparable<FrequentItemSet>{

    private List<String> products =new ArrayList<>();

    public List<String> getProducts() {
        return products;
    }

    public void setProducts(List<String> products) {
        this.products = products;
    }

    public FrequentItemSet(List<String> frequentItemSet) {
        this.products = frequentItemSet;
    }

    public FrequentItemSet(){

    }

    @Override
    public int compareTo(FrequentItemSet o) {

        return this.getProducts().get(0).compareTo(o.getProducts().get(0));

    }
    @Override
    public String toString(){
        return this.products.toString();
    }
}
