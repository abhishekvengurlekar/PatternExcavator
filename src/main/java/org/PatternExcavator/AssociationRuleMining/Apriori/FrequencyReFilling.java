package org.PatternExcavator.AssociationRuleMining.Apriori;

import org.PatternExcavator.AssociationRuleMining.DAO.DAOPatternExcavatorImpl;
import org.PatternExcavator.AssociationRuleMining.HibernateEntities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FrequencyReFilling {

    @Autowired
    AprioriMiner aprioriMiner;

    @Autowired
    DAOPatternExcavatorImpl daoPatternExcavator;

    public HashMap<String,Integer> getProductRefillFromAmount(int amount,String companyName,int supportFrequency){

        List<FrequentItemSet> frequentItemSetList=aprioriMiner.getAllFrequentItemSets(companyName,supportFrequency);

        HashSet<String> frequentItems=getFrequentItemSetHashSet(frequentItemSetList);

        List<String> allProductsName=new ArrayList<>();
        List<Integer> allProductsMargin=new ArrayList<>();
        List<Integer> allProductsCostPrice=new ArrayList<>();


        Iterator<String> frequentItemsIterator=frequentItems.iterator();

        while (frequentItemsIterator.hasNext()){
            //allProductsName.add(getRefillingProductsFromDB(frequentItemsIterator.next()));
            Object[] holder=getRefillingProductsFromDB(frequentItemsIterator.next());

            allProductsName.add((String) holder[0]);
            allProductsMargin.add((Integer) holder[1]);
            allProductsCostPrice.add((Integer) holder[2]);
        }
        this.finalRefillingProducts=new HashMap<>();
        this.max=Integer.MIN_VALUE;
        recursion(amount,new HashMap<String,Integer>(),0,allProductsName,allProductsMargin,allProductsCostPrice,0);

        return this.finalRefillingProducts;
    }

    private Integer max=Integer.MIN_VALUE;
    private HashMap<String,Integer> finalRefillingProducts=new HashMap<>();

    public void recursion(int amount,HashMap<String,Integer> reFillingPermutation,int profit,List<String> allProductsName,List<Integer> allProductsMargin, List<Integer> allProductsCostPrice,int index){

        if(index>=allProductsName.size()){
            if(profit>this.max){
                this.finalRefillingProducts=new HashMap<>(reFillingPermutation);
                this.max=profit;
            }
            return;
        }

        if(allProductsCostPrice.get(index)>amount){
            //not consider
            recursion(amount,reFillingPermutation,profit,allProductsName,allProductsMargin,allProductsCostPrice,index+1);

        }else{
            //consider

            if(reFillingPermutation.containsKey(allProductsName.get(index))){
                reFillingPermutation.put(allProductsName.get(index), reFillingPermutation.get(allProductsName.get(index))+1);
            }else{
                reFillingPermutation.put(allProductsName.get(index), 1);
            }
            recursion(amount-allProductsCostPrice.get(index),reFillingPermutation,profit+allProductsMargin.get(index),allProductsName,allProductsMargin,allProductsCostPrice,index);

            if(reFillingPermutation.get(allProductsName.get(index))>1){
                reFillingPermutation.put(allProductsName.get(index), reFillingPermutation.get(allProductsName.get(index))-1);

            }else{
                reFillingPermutation.remove(allProductsName.get(index));
            }

            //not consider
            recursion(amount,reFillingPermutation,profit,allProductsName,allProductsMargin,allProductsCostPrice,index+1);

        }

    }
    public Object[] getRefillingProductsFromDB(String productName){

        Product product=daoPatternExcavator.getProductRowFromDB(productName);

        return new Object[]{product.getProductName(),product.getSellingPrice()-product.getCostPrice(),product.getCostPrice()};

    }

    public HashSet<String> getFrequentItemSetHashSet(List<FrequentItemSet> frequentItemSetList){

        HashSet<String> frequentItems=new HashSet<>();

        for(FrequentItemSet frequentItemSet:frequentItemSetList){

            List<String> products=frequentItemSet.getProducts();

            for(String productName:products){
                frequentItems.add(productName);
            }
        }

        return frequentItems;
    }
}
