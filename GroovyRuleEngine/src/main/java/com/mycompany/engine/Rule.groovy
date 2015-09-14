package com.mycompany.engine

import com.collections.model.Customer
import groovy.transform.stc.ClosureParams
import groovy.transform.stc.FirstParam
import groovy.transform.stc.SimpleType


/**
 * Created by rajaramkumar on 6/8/15.
 */
class Rule {

    def result = false
    def context = [:]
    def Map<Class,Object>  parameters ;

    public Rule(Map<Class,Object> parameters) {
        this.parameters = parameters
    }

    def when(Closure expression) {
        Binding binding = getBinding()
        expression.delegate = binding
        if (expression()) {
            result = true;
        } else {
            result = false
        }
        this
    }



    def then(Closure expression) {
        if (result) {
            def binding = getBinding()
            expression.delegate = binding
            expression()
            context.each {
                key, value -> context.put(key, binding.getVariable(key))
            }
        }
    }

    def set(tup) {
        context.putAll(tup)
    }

    def table(data, Closure expression) {
        data.find {
            def binding = new Binding()
            it.each { key, value ->
                binding.setVariable(key, value)
            }
            expression.delegate = binding
            expression()
            result
        }
    }

    private Binding getBinding() {
        def binding = new Binding()
        context.each {
            key, value -> binding.setVariable(key, value)
        }
        binding
    }

    def printContext() {
        println context
    }

}
