package com.mycompany.engine

import com.collections.model.Customer
import com.mycompany.engine.Flow
import com.mycompany.engine.Rule

/**
 * Created by rajaramkumar on 6/14/15.
 */
class RuleFlowEngine {

    private static Map<Class,Object> parameters = new HashMap<Class, Object>();

    private static Map<String,Class> rules = new HashMap<String, Class>();

    private static Map<String,Class> flow = new HashMap<String, Class>();

    static def rule(name , @DelegatesTo(Rule) Closure cl) {
        println "executing RULE " + name
        Rule engine = new Rule(parameters)
        def code = cl.rehydrate(engine, this, this)
        code.resolveStrategy = Closure.DELEGATE_ONLY
        code(parameters.get(Customer.class))
        engine.printContext()
    }

    static def flow(name , @DelegatesTo(Flow)Closure cl) {
        println "executing FLOW " + name
        Flow engine = new Flow(parameters)
        def code = cl.rehydrate(engine, this, this)
        code.resolveStrategy = Closure.DELEGATE_ONLY
        code(parameters.get(Customer.class))
    }

    static def initializeParameters(Class clazz,Object object) {
         parameters.put(clazz,object);
    }

    public static executeRule(name) {
        Class scriptClass = rules.get(name)
        Script scriptInstance = scriptClass.newInstance()
        scriptInstance.run()
    }

    public static executeRuleClazz(name) {
        Script scriptInstance = name.newInstance()
        scriptInstance.run()
    }

    public static executeFlow(name) {
        Class scriptClass = flow.get(name)
        Script scriptInstance = scriptClass.newInstance()
        scriptInstance.run()
    }

    static def addRule(name,scriptClass) {
        rules.put(name,scriptClass)
    }

    static def addFlow(name,scriptClass) {
        flow.put(name,scriptClass)
    }
}
