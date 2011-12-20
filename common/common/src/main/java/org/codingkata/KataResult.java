package org.codingkata;

import java.util.ArrayList;
import java.util.List;

/**
 * Result data object for test of a kata solution
 * @author stephanos
 */
public class KataResult {

    /*======= FIELDS =======*/
    
    private boolean passed = true;
    private double points = -1;
    private long startedOn;
    private long finishedOn;
    private Exception exception;
    private String customSuccessMsg = "";
    private String customIntroMsg = "";
    private String customResult = "";

    private KataSettings settings;
    private List<KataValidate> validations = new ArrayList<KataValidate>(0);

    /*======= SETUP =======*/

    public KataResult () {
        this (new KataSettings ());
    }

    public KataResult (KataSettings pSettings) {
        settings = pSettings;
    }

    public KataResult (Exception e) {
        exception = e;
        passed = false;
    }

    /*======= METHODS =======*/

    public long neededTime() {
        return finishedOn - startedOn;
    }

    public void addValidation(KataValidate v) {
        validations.add(v);
        if (!v.isPassed()) {
            passed = false;
        }
    }

    public void print() {
        new ConsoleWriter ().print (this);
    }

    public boolean isSolved() {
        return passed && exception == null;
    }

    /*======= GET/SET =======*/

    public double getPoints() {
        return points;
    }

    public void setPoints(double points) {
        this.points = points;
    }

    public boolean isPassed() {
        return passed;
    }

    public void setPassed(boolean passed) {
        this.passed = passed;
    }

    public long getStartedOn() {
        return startedOn;
    }

    public void setStartedOn(long startedOn) {
        this.startedOn = startedOn;
    }

    public long getFinishedOn() {
        return finishedOn;
    }

    public void setFinishedOn(long finishedOn) {
        this.finishedOn = finishedOn;
    }

    public List<KataValidate> getValidations() {
        return validations;
    }

    public void setValidations(List<KataValidate> validations) {
        this.validations = validations;
    }

    public KataSettings getSettings() {
        return settings;
    }

    public void setSettings(KataSettings settings) {
        this.settings = settings;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    public String getCustomSuccessMsg() {
        return customSuccessMsg;
    }

    public void setCustomSuccessMsg(String customSuccessMsg) {
        this.customSuccessMsg = customSuccessMsg;
    }

    public String getCustomIntroMsg() {
        return customIntroMsg;
    }

    public void setCustomIntroMsg(String customIntroMsg) {
        this.customIntroMsg = customIntroMsg;
    }

    public String getCustomResult() {
        return customResult;
    }

    public void setCustomResult(String customResult) {
        this.customResult = customResult;
    }

}
