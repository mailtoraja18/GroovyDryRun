package com.collections.model;

import java.math.BigDecimal;

/**
 * Created by rajaramkumar on 9/12/15.
 */
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
