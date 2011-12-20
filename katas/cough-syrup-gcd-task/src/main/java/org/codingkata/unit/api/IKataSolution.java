package org.codingkata.unit.api;

import org.codingkata.IKataCommonSolution;

/**
 * interface for the kata's task
 * @author stephanos
 */
public interface IKataSolution
        extends IKataCommonSolution {

    /**
     * Calculate the 'greatest common divisor'
     *
     * @param number1   the first number ('numerator')
     * @param number2   the second number ('denominator')
     *
     * @return GCD of number1 and number2
     */
    public abstract int calcGCD(int number1, int number2);
}
