package org.codingkata;

/**
 * @author stephanos
 */
public class KataValidate {

    /*======= FIELDS =======*/
    private boolean passed;
    private String expect;
    private String actual;
    private String input = "";

    /*======= SETUP =======*/

    KataValidate(boolean pPassed, String pExpect, String pActual, Object ... pInputs) {
        this (pPassed, pExpect, pActual);

        if (pInputs.length > 0) {
            input = "[ ";
            for (Object o : pInputs) {
                 input += o.toString() + " ";
            }
            input += "]";
        }
    }

    KataValidate(boolean pPassed, String pExpect, String pActual) {
        this (pPassed);
        expect = pExpect;
        actual = pActual;
    }

    KataValidate(boolean pPassed) {
        passed = pPassed;
    }

    /*======= GET/SET =======*/

    public boolean isPassed() {
        return passed;
    }

    public void setPassed(boolean passed) {
        this.passed = passed;
    }

    public String getActual() {
        return actual;
    }

    public void setActual(String actual) {
        this.actual = actual;
    }

    public String getExpect() {
        return expect;
    }

    public void setExpect(String expect) {
        this.expect = expect;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    
}
