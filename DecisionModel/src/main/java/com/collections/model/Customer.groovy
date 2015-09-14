package com.collections.model

import groovy.transform.ToString
/**
 * Created by rajaramkumar on 6/28/15.
 */
@ToString(includeNames=true, includeFields=true)
class Customer {

    public String type;
    public BigDecimal balance
    public String segmentation
    public String channel
    List<Account> accountList;


}

