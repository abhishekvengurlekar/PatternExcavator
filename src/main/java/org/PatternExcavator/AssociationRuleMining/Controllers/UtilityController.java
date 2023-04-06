package org.PatternExcavator.AssociationRuleMining.Controllers;

import org.PatternExcavator.AssociationRuleMining.Apriori.AprioriMiner;
import org.PatternExcavator.AssociationRuleMining.Apriori.AssociationRule;
import org.PatternExcavator.AssociationRuleMining.Apriori.FrequencyReFilling;
import org.PatternExcavator.AssociationRuleMining.Apriori.FrequentItemSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;

@Controller
public class UtilityController {

    @Autowired
    AprioriMiner aprioriMiner;

    @Autowired
    FrequencyReFilling frequencyReFilling;


    @PostMapping(path = "/strongAssociationRules")
    public String getStrongAssociationRules(@RequestParam(name = "support") int support,@RequestParam(name = "confidence") int confidence ,Model model){

        Authentication authentication=SecurityContextHolder.getContext().getAuthentication();

       // System.out.println(authentication.getName());
        String companyName=authentication.getName();

        //support-----> frequency and not percentage.
        //confidence------>percentage.

        List<AssociationRule> associationRuleList=aprioriMiner.getAllStrongAssociationRules(companyName,support,confidence);
        model.addAttribute("associations",associationRuleList);

        return "UserPage";
    }

    @PostMapping(path = "/frequentItemSets")
    public String getFrequentItemSets(@RequestParam(name ="support") int support,Model model){

        Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
        String companyName=authentication.getName();

        //support is in frequency and not in percentage
        List<FrequentItemSet> frequentItemSetList=aprioriMiner.getAllFrequentItemSets(companyName,support);

        model.addAttribute("frequentItemSets",frequentItemSetList);
        return "UserPage";

    }

    @PostMapping(path = "/interestingRules")
    public String getAllInterestingRules(@RequestParam(name = "support") int support,@RequestParam(name = "confidence") int confidence,Model model){

        Authentication authentication=SecurityContextHolder.getContext().getAuthentication();

        String companyName=authentication.getName();

        //support is in frequency and not in percentage
        //Confidence is in percentage
        List<AssociationRule> allInterestingRules=aprioriMiner.getAllInterestingRules(companyName,support,confidence);

        model.addAttribute("interestingRules",allInterestingRules);

        return "UserPage";

    }

    //have to write code for refilling.
    @PostMapping(path = "/repurchasing")
    public String repurchaseItems(Model model,@RequestParam(name = "amount") int amount,@RequestParam(name = "support") int support){
        String companyName=SecurityContextHolder.getContext().getAuthentication().getName();


        HashMap<String,Integer> hash=frequencyReFilling.getProductRefillFromAmount(amount,companyName,support);

        model.addAttribute("hash",hash);


        return "UserPage";
    }



}

