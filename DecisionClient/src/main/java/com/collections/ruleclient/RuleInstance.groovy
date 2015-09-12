package com.collections.ruleclient

import com.collections.model.Account

/**
 * Created by rajaramkumar on 6/14/15.
 */

import com.collections.model.Customer

import static com.mycompany.engine.RuleFlowEngine.*


rule "Name of the rule" , { Customer customer ->
    set a:1
    set b:2
    set c:"BIG"
    when {
        Account account = customer.accountList.get(0)
        ( a + b == 3 ) || (1 + 3 == 2) || account.balance > 1000
    }
    then {
        println("1 + 1 == 2-->" + a + "," + b)
        table (
                data = [[x: 2, y: 7], [x: 1, y: 2],[x: 2, y: 7],[x: 1, y: 2]],
                condition = {
                    when {
                        a >= x && b <= y
                    }
                    then {
                        println("Table 1 + 1 == 2-->" + a + "," + b+ "," + x+ "," + y)
                    }
                }
        )
    }
}
