package com.mycompany.engine
/**
 * Created by rajaramkumar on 6/14/15.
 */
class Flow {

    def flowContext = [:]
    def afterContext = [:]
    def Map<Class,Object>  parameters ;
    def execute = true;

    public Flow(Map<Class,Object> parameters) {
        this.parameters = parameters
    }

    def step (props , Closure cl) {
        flowContext.put(props.name , cl);
    }

    def after (props) {
        afterContext.put(props.step,props)
    }

    def when (bool) {
       execute = bool
       this
    }

    def execute (clazz) {
        if(execute) {
            println "Executing::" + clazz
            RuleFlowEngine.executeRuleClazz(clazz)
        }


        execute = true;
    }

    def executeExpr (Closure cl) {
        if(execute) {
            println "Executing::" + cl
            cl()
        }

        execute = true;
    }


    def runFlow() {
        println(flowContext)
        print("----")
        println(afterContext)
    }
}
