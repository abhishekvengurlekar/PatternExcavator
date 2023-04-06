package org.PatternExcavator.AssociationRuleMining.Apriori;

import java.util.*;

public class AssociationRule {


    public AssociationRule(){

    }

    private ArrayList<String> leftRule=new ArrayList<>();
    private ArrayList<String> rightRule=new ArrayList<>();

    public ArrayList<String> getLeftRule() {
        return leftRule;
    }

    public void setLeftRule(ArrayList<String> leftRule) {
        this.leftRule = leftRule;
    }

    public ArrayList<String> getRightRule() {
        return rightRule;
    }

    public void setRightRule(ArrayList<String> rightRule) {
        this.rightRule = rightRule;
    }

    @Override
    public String toString(){

        return leftRule.toString()+" --> "+rightRule.toString();

    }
}
