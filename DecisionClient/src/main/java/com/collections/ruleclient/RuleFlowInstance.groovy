package com.collections.ruleclient

import com.collections.model.Customer

/**
 * Created by rajaramkumar on 6/14/15.
 */

import static com.mycompany.engine.RuleFlowEngine.*

flow "flowname" , { Customer customer ->
  step name:"step1", {
      println("step1")
  }
  step name:"step2", {
      println("step2")
  }
  step name:"step3", {
      println("step3")
  }
  step name:"step4", {
      println("step4");
  }

  after step:"start",execute:"step1"
  after step:"step1","customer.balance > 200":"step2","customer.balance <= 200":"step3",else:"step4"
  after step:"step2",execute:"end"
  after step:"step3",execute:"end"

  runFlow()

 }