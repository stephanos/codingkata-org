package org.codingkata.unit.api;

import org.codingkata.IKataCommonSolution;

/**
 * interface for the kata's task
 * @author stephanos
 */
public interface IKataSolution
        extends IKataCommonSolution {

    /**
     * Calculate an element of the Fibonacci sequence
     *
     * @param n     element number
     * @return      n-th element of the Fibonacci sequence
     */
    public abstract int fibonacci(int n);
}
