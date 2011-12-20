package org.codingkata.unit.api;

import org.codingkata.IKataCommonSolution;

/**
 * interface for the kata's task
 * @author stephanos
 */
public interface IKataSolution
        extends IKataCommonSolution {

    /**
     * Check if a number is a 'happy number'
     *
     * @param number    number to be checked
     * @return          true if parameter is a happy number
     */
    public abstract boolean isHappy(long number);
}
