package org.codingkata.unit.api;

import org.codingkata.IKataCommonSolution;

/**
 * interface for the kata's task
 * @author stephanos
 */
public interface IKataSolution
        extends IKataCommonSolution {

    /**
     * Calculate the ISBN-13 check digit
     *
     * @param isbn  an incomplete ISBN code (12 characters, no hyphens)
     * @return      code's check digit
     */
    public abstract int calcCheckDigit(String isbn);
}
