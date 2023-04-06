package org.PatternExcavator.AssociationRuleMining.Apriori;

import org.PatternExcavator.AssociationRuleMining.DAO.DAOPatternExcavatorImpl;
import org.PatternExcavator.AssociationRuleMining.HibernateEntities.Company;
import org.PatternExcavator.AssociationRuleMining.HibernateEntities.Product;
import org.PatternExcavator.AssociationRuleMining.HibernateEntities.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AprioriMiner {

    @Autowired
    DAOPatternExcavatorImpl daoPatternExcavator;

    private HashMap<String,Integer> supportOfFrequentItemSets;

    private List<Transaction> getAllTransactions(String companyName){

        List<Transaction> transactions=daoPatternExcavator.getTransactionsForCompanyFromDB(companyName);

        return transactions;
    }

    private void sortProductsInTransactions(List<Transaction> transactions){

        for(Transaction transaction:transactions){
            Collections.sort(transaction.getProducts());
        }

    }

    private List<FrequentItemSet> getOneFrequentItemSetList(List<Transaction> transactions,int supportFreq){

        supportOfFrequentItemSets=new HashMap<>();

        HashMap<String,Integer> productFrequency=new HashMap<>();

        for(Transaction transaction:transactions){

            List<Product> products=transaction.getProducts();

            for(Product product:products){

                String productName=product.getProductName();

                if(productFrequency.containsKey(productName)){
                    productFrequency.put(productName,productFrequency.get(productName)+1);
                }else {
                    productFrequency.put(productName,1);
                }

            }

        }

        Set<Map.Entry<String,Integer>> entrySet=productFrequency.entrySet();
        Iterator<Map.Entry<String,Integer>> entryIterator=entrySet.iterator();

        List<FrequentItemSet> frequentItemSetList=new ArrayList<>();

        while(entryIterator.hasNext()){

            Map.Entry<String,Integer> local=entryIterator.next();

            String productName= local.getKey();
            int frequency= local.getValue();
            if(frequency<supportFreq){
                continue;
            }


            FrequentItemSet frequentItemSet=new FrequentItemSet();
            frequentItemSet.getProducts().add(productName);

            supportOfFrequentItemSets.put(frequentItemSet.getProducts().toString(),frequency);

            frequentItemSetList.add(frequentItemSet);
        }

        Collections.sort(frequentItemSetList);

        return frequentItemSetList;
    }

    private List<CandidateItemSet> makeNextCandidateItemSets(List<FrequentItemSet> frequentItemSetList){

        List<CandidateItemSet> nextCandidateItemSet=new ArrayList<>();

        LowerStringWillBeUnEqual:
        for(int i=0;i<frequentItemSetList.size()-1;i++){

            List<String> productsListFirst=frequentItemSetList.get(i).getProducts();

            for(int j=i+1;j< frequentItemSetList.size();j++){


                List<String> productListSecond=frequentItemSetList.get(j).getProducts();

                //product comparison

                CandidateItemSet nextItemSet=new CandidateItemSet();

                for(int k=0;k<productsListFirst.size()-1;k++){

                    if(productsListFirst.get(k).compareTo(productListSecond.get(k))!=0){
                        continue LowerStringWillBeUnEqual;
                    }
                    nextItemSet.getProducts().add(productsListFirst.get(k));

                }
                nextItemSet.getProducts().add(productsListFirst.get(productsListFirst.size()-1));
                nextItemSet.getProducts().add(productListSecond.get(productListSecond.size()-1));

                nextCandidateItemSet.add(nextItemSet);

            }

        }

        return nextCandidateItemSet;

    }

    private List<FrequentItemSet> getFrequentItemSetFromCandidateItemSet(List<CandidateItemSet> candidateItemSetList,List<Transaction> transactionList,int supportFreq){

        for(CandidateItemSet candidateItemSet:candidateItemSetList){
            candidateItemSet.setCandidateItemSetString(candidateItemSet.getProducts().toString());
        }

        for(Transaction transaction:transactionList){

            HashSet<String> allProductCombinationOfATransaction=new HashSet<>();

            List<String> temporaryProductCarrier=new ArrayList<>();

            getComparableStringOfATransaction(allProductCombinationOfATransaction,transaction.getProducts(),0,temporaryProductCarrier);

            for(CandidateItemSet candidateItemSet:candidateItemSetList){

                if(allProductCombinationOfATransaction.contains(candidateItemSet.getCandidateItemSetString())){
                    candidateItemSet.setFrequency(candidateItemSet.getFrequency()+1);
                }
            }
        }

        List<FrequentItemSet> frequentItemSetList=new ArrayList<>();

        for(CandidateItemSet candidateItemSet:candidateItemSetList){

            if(candidateItemSet.getFrequency()>=supportFreq){

                FrequentItemSet frequentItemSet=new FrequentItemSet();

                frequentItemSet.setProducts(new ArrayList<>(candidateItemSet.getProducts()));
                //add here
                supportOfFrequentItemSets.put(frequentItemSet.getProducts().toString(),candidateItemSet.getFrequency());

                frequentItemSetList.add(frequentItemSet);
            }
        }
        //Make sure this does not produce any unwanted results.
        candidateItemSetList=null;
        System.gc();

        return frequentItemSetList;

    }

    private void getComparableStringOfATransaction(HashSet<String> allProductCombinationOfATransaction,List<Product> productList,int index,List<String> temporaryProductCarrier){

        if(index>=productList.size()){
            if(temporaryProductCarrier.size()==0){
                return;
            }else{
                allProductCombinationOfATransaction.add(temporaryProductCarrier.toString());
                return;
            }
        }

        temporaryProductCarrier.add(productList.get(index).getProductName());
        getComparableStringOfATransaction(allProductCombinationOfATransaction,productList,index+1,temporaryProductCarrier);

        temporaryProductCarrier.remove(temporaryProductCarrier.size()-1);

        getComparableStringOfATransaction(allProductCombinationOfATransaction,productList,index+1,temporaryProductCarrier);


    }

    public List<FrequentItemSet> getAllFrequentItemSets(String companyName,int supportFreq){

        List<Transaction> transactions=getAllTransactions(companyName);
        sortProductsInTransactions(transactions);

        List<FrequentItemSet> nextFrequentItemSetList=getOneFrequentItemSetList(transactions,supportFreq);

        if(nextFrequentItemSetList.size()==0){
            return nextFrequentItemSetList;
            //no frequent itemSet found
        }

        while(true){

            List<CandidateItemSet> nextCandidateItemSet=makeNextCandidateItemSets(nextFrequentItemSetList);
            List<FrequentItemSet> newFrequentItemSetList=getFrequentItemSetFromCandidateItemSet(nextCandidateItemSet,transactions,supportFreq);

            if(newFrequentItemSetList.size()==0){
                return nextFrequentItemSetList;
            }
            else{
                nextFrequentItemSetList=newFrequentItemSetList;
            }
        }
    }

    public List<AssociationRule> getAllStrongAssociationRules(String companyName,int supportFrequency,int confidenceFrequency){

        List<FrequentItemSet> allFrequentItemSets=getAllFrequentItemSets(companyName,supportFrequency);

        List<AssociationRule> allAssociationRules=new ArrayList<>();

        for(FrequentItemSet frequentItemSet:allFrequentItemSets){

            //System.out.println(supportOfFrequentItemSets.get(frequentItemSet.getProducts().toString()));
            makeLeftRuleAndRightRule(frequentItemSet.getProducts(),allAssociationRules,0,new ArrayList<>(),new ArrayList<>(),confidenceFrequency,supportOfFrequentItemSets.get(frequentItemSet.getProducts().toString()));

        }

        //System.out.println(supportOfFrequentItemSets);

        return allAssociationRules;
    }

    public void makeLeftRuleAndRightRule(List<String> products,List<AssociationRule> allAssociationRules,int index,ArrayList<String> leftRule,ArrayList<String> rightRule,int confidenceFrequency,int supportAllProducts){

        if(index >= products.size()){

            if(leftRule.size()==0 || rightRule.size()==0){
                return;
            }

            double leftFrequency=(double)supportOfFrequentItemSets.get(leftRule.toString());
            double confidence=(double)supportAllProducts/leftFrequency;

            confidence=confidence*100;


            if(confidence>=confidenceFrequency){

                AssociationRule associationRule=new AssociationRule();
                associationRule.setLeftRule(new ArrayList<>(leftRule));
                associationRule.setRightRule(new ArrayList<>(rightRule));

                allAssociationRules.add(associationRule);

            }

            return;

        }

        //consider ith index as left
        leftRule.add(products.get(index));
        makeLeftRuleAndRightRule(products,allAssociationRules,index+1,leftRule,rightRule,confidenceFrequency,supportAllProducts);
        leftRule.remove(leftRule.size()-1);


        //consider ith index as right
        rightRule.add(products.get(index));
        makeLeftRuleAndRightRule(products,allAssociationRules,index+1,leftRule,rightRule,confidenceFrequency,supportAllProducts);
        rightRule.remove(rightRule.size()-1);


    }

    public List<AssociationRule> getAllInterestingRules(String companyName,int support,int confidence){

        //support is frequency
        //confidence is percentage

        List<AssociationRule> allInterestingRules=new ArrayList<>();


        List<AssociationRule> associationRuleList=getAllStrongAssociationRules(companyName,support,confidence);


        for(AssociationRule associationRule:associationRuleList){

            ArrayList<String> leftRule=associationRule.getLeftRule();
            ArrayList<String> rightRule=associationRule.getRightRule();

            ArrayList<String> leftRuleAndRightRule=new ArrayList<>();
            leftRuleAndRightRule.addAll(leftRule);
            leftRuleAndRightRule.addAll(rightRule);
            Collections.sort(leftRuleAndRightRule);

            //System.out.println(leftRuleAndRightRule);

            double PaUb=supportOfFrequentItemSets.get(leftRuleAndRightRule.toString());
            double Pa=supportOfFrequentItemSets.get(leftRule.toString());
            double Pb=supportOfFrequentItemSets.get(rightRule.toString());

            double lift=PaUb/(Pa*Pb);

            if(lift>1.00){
                //add into a new List.
                allInterestingRules.add(associationRule);
            }

        }
        //System.out.println(this.supportOfFrequentItemSets);
        //System.out.println(associationRuleList);

        return allInterestingRules;

    }






















}
