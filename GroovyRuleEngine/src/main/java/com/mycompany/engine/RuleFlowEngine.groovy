package com.mycompany.engine

import com.mycompany.engine.Flow
import com.mycompany.engine.Rule

/**
 * Created by rajaramkumar on 6/14/15.
 */
class RuleFlowEngine {

    private static Map<Object,Class> parameters = new HashMap<Object, Class>();

    static def rule(name , @DelegatesTo(Rule) Closure cl) {
        println "executing RULE " + name
        Rule engine = new Rule(parameters)
        def code = cl.rehydrate(engine, this, this)
        code.resolveStrategy = Closure.DELEGATE_ONLY
        code()
        engine.printContext()
    }

    static def flow(name , @DelegatesTo(Flow)Closure cl) {
        println "executing FLOW " + name
        Flow engine = new Flow(parameters)
        def code = cl.rehydrate(engine, this, this)
        code.resolveStrategy = Closure.DELEGATE_ONLY
        code()
    }

    static def initialize(Object object,Class clazz) {
         parameters.put(object,clazz);
    }

}
