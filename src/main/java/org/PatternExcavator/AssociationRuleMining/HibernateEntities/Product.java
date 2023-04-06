package org.PatternExcavator.AssociationRuleMining.HibernateEntities;

import javax.persistence.*;
import java.util.Comparator;
import java.util.List;

@Entity
@Table(name="product")
public class Product implements Comparable<Product> {

    public Product(){

    }

    public Product(String productName, int costPrice, int sellingPrice) {
        this.productName = productName;
        this.costPrice = costPrice;
        this.sellingPrice = sellingPrice;
    }

    @Id
    @Column(name="product_name")
    String productName;

    @Column(name = "cost_price")
    int costPrice;

    @Column(name="selling_price")
    int sellingPrice;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(int costPrice) {
        this.costPrice = costPrice;
    }

    public int getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(int sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    @Override
    public int compareTo(Product o) {

        return this.getProductName().compareTo(o.getProductName());
    }

    @Override
    public String toString(){
        return this.productName;
    }
}
