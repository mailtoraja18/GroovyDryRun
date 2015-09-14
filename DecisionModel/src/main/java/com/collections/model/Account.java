package com.collections.model;

import groovy.transform.ToString;

import java.math.BigDecimal;

/**
 * Created by rajaramkumar on 9/12/15.
 */
@ToString(includeNames=true, includeFields=true)
public class Account {

    BigDecimal balance;
    boolean bankrupt;
    boolean disceased;
    boolean chargedoff;
    String pastDueLevelCode;
    // outputs
    String channel;
    String segmentation;
    BigDecimal settlementFloorRate;
    BigDecimal settlementTargetRate;

}
