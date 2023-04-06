package org.PatternExcavator.AssociationRuleMining.Apriori;

public class RefillingProduct {

    public RefillingProduct(){}

    public RefillingProduct(String productName,int margin,int costPrice){

        this.productName=productName;
        this.margin=margin;
        this.costPrice=costPrice;
    }

    String productName;
    //SP-CP
    int margin;
    //CP
    int costPrice;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getMargin() {
        return margin;
    }

    public void setMargin(int margin) {
        this.margin = margin;
    }

    public int getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(int costPrice) {
        this.costPrice = costPrice;
    }
}
