package com.mycompany.engine
/**
 * Created by rajaramkumar on 6/14/15.
 */
class Flow {

    def flowContext = [:]
    def afterContext = [:]

    def step (props , Closure cl) {
        flowContext.put(props.name , cl);
    }

    def after (props) {
        afterContext.put(props.step,props)
    }

    def runFlow() {
        println(flowContext)
        print("----")
        println(afterContext)
    }
}
