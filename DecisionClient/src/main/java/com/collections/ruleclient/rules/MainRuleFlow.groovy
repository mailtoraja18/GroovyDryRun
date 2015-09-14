package com.collections.ruleclient.rules

import com.collections.model.Customer

/**
 * Created by rajaramkumar on 6/14/15.
 */

import static com.mycompany.engine.RuleFlowEngine.*

flow "PrimaryFlow" , { Customer customer ->

    execute SegmentationRule
    when customer.balance > 200 execute ChannelRule
    when customer.balance <=200 executeExpr { customer.channel = 'ABC' }
 }