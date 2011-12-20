package org.codingkata;

/**
 * Base interface for every kata task
 * @author stephanos
 */
public interface IKataCommonTask {

    /**
     * Begin the task
     */
    void start();

    /**
     * Print the results
     */
    void printResult();

    /**
     * Finish the task
     */
    void finish ();

    /**
     * Return the results
     */
    KataResult getResult();

    /**
     * Set the task solution
     */
    void setSolution(IKataCommonSolution solution);
}

