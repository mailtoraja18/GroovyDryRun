/**
 * Created by rajaramkumar on 6/6/15.
 */
class GroovyDryRun {

    void executeRule() {
        rule "Name of the rule" , {
            set a:1
            set b:2
            set c:"BIG"
            when {
                ( a + b == 3 ) || (1 + 3 == 2)
            }
            then {
                println("1 + 1 == 2-->" + a + "," + b)
                table (
                    data = [[x: 2, y: 7], [x: 1, y: 2],[x: 2, y: 7],[x: 1, y: 2]],
                    condition = {
                        when {
                            a >= x && b <= y
                        }
                        then {
                            println("Table 1 + 1 == 2-->" + a + "," + b+ "," + x+ "," + y)
                            c = c+",HelloTable"
                        }
                    }
                )
            }
        }


    }

    void executeRuleFile() {
        ClassLoader parent = this.getClass().getClassLoader()
        GroovyClassLoader loader = new GroovyClassLoader(parent)
        Class groovyClass = loader.parseClass(new File("./src/rule.txt").text)
        def cv = groovyClass.newInstance()
        cv.closures.each {
            it()
        }

    }

    void executeRuleFile2() {
        def aStr = new File("./src/rule2.txt").text
        new GroovyShell().evaluate(aStr)
    }

    void testExpression() {

    }

    def namedParamsMethod(params, param2, param3) {
        assert params.a == 1
        assert params.b == 2
        assert params.c == 3
        assert param2 == "param1"
        assert param3 == "param2"
    }

    static void main(String... args) {
        println new File(".").getAbsolutePath()
        println 'Groovy world!'
        GroovyDryRun gdr = new GroovyDryRun()
        //gdr.executeRule();
        gdr.namedParamsMethod("param1",a:1, b:2,"param2", c:3)
    }
}
