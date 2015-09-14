package com.collections.ruleclient.rules

import com.collections.model.Account

/**
 * Created by rajaramkumar on 6/14/15.
 */

import com.collections.model.Customer

import static com.mycompany.engine.RuleFlowEngine.*


rule "ChannelRule", { Customer customer ->
    when {
        true
    }
    then {

        if(customer.segmentation == 'HYHB') {
            customer.channel = 'IRU'
        } else if (customer.segmentation=='HYMB') {
            customer.channel = 'Agency'
        } else if (customer.segmentation== 'HYLB') {
            customer.channel = 'DebtSales'
        }
    }
}
