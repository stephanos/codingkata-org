package org.codingkata.unit.api;

import org.codingkata.IKataCommonSolution;

/**
 * interface for the kata's task
 * @author stephanos
 */
public interface IKataSolution
        extends IKataCommonSolution {

    /**
     * Adds a car to the siding
     *
     * @param car   a train car (represented by a number)
     */
    public abstract void push(Integer car);

    /**
     * Removes a car from the siding
     *
     * @return  a train car (number), -1 if stack is empty
     */
    public abstract Integer pop();

    /**
     * Return the current front car (number) without removing it
     *
     * @return  a train car (number), -1 if stack is empty
     */
    public abstract Integer peek();
}
