package com.collections.model

import groovy.transform.ToString
/**
 * Created by rajaramkumar on 6/28/15.
 */
@ToString
class Customer {

    public String type;
    public BigDecimal balance
    public String segmentation
    List<Account> accountList;


}

