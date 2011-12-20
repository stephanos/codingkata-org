package org.codingkata.unit.api;

import org.codingkata.IKataCommonSolution;

/**
 * interface for the kata's task
 * @author stephanos
 */
public interface IKataSolution
        extends IKataCommonSolution {

    /**
     * Test if a cube door is trapped
     *
     * @param code1     first code
     * @param code2     second code
     * @param code3     third code
     *
     * @return true if any of the codes' checksum is a prime number
     */
    public abstract boolean containsPrimeNumber(String code1, String code2, String code3);
}
