package org.codingkata.unit.api;

import org.codingkata.IKataCommonSolution;

/**
 * interface for the kata's task
 * @author stephanos
 */
public interface IKataSolution
        extends IKataCommonSolution {

     /**
     * @param number    An Arabic numeral
     * @return          the Roman numeral equivalent to the Arabic numeral
     */
    public abstract String convert (int number);
}

