package com.collections.ruleclient.rules

import com.collections.model.Account

/**
 * Created by rajaramkumar on 6/14/15.
 */

import com.collections.model.Customer

import static com.mycompany.engine.RuleFlowEngine.*


rule "Segmentation", { Customer customer ->
    set a:10
    when {
        customer.balance > 0
    }
    then {
        println a
        if (customer.balance > 0 && customer.balance < 4000) {
            customer.segmentation = 'HYLB'
        } else if (customer.balance > 4000 && customer.balance < 6000) {
            customer.segmentation = 'HYMB'
        } else {
            customer.segmentation = 'HYHB'
        }
    }
}
