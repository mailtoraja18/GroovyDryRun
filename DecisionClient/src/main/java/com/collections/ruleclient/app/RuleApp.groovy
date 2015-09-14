package com.collections.ruleclient.app

import com.collections.model.Account
import com.collections.model.Customer
import com.collections.ruleclient.rules.MainRuleFlow
import com.mycompany.engine.RuleFlowEngine

/**
 * Created by rajaramkumar on 9/12/15.
 */
class RuleApp {

    public static void main(String[] args) {
        Customer customer = new Customer(balance: 10)
        customer.accountList = new ArrayList<Account>()
        customer.accountList.add(new Account(balance: 5000))


        RuleFlowEngine.initializeParameters(customer.getClass(),customer)
        //RuleFlowEngine.addRule("Segmentation",SegmentationRule.class)
        //RuleFlowEngine.executeRule("Segmentation")

        RuleFlowEngine.addFlow("RuleFlow",MainRuleFlow.class)
        RuleFlowEngine.executeFlow("RuleFlow")

        println "Final Result " + customer.toString()
    }
}
