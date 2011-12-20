package org.codingkata.unit.api;

import org.codingkata.IKataCommonSolution;

/**
 * interface for the kata's task
 * @author stephanos
 */
public interface IKataSolution
        extends IKataCommonSolution {

    /**
     * Returns the NASA countdown
     *
     * @param start number to start with
     * @return      array with numbers from 10 to 0
     */
    public abstract Integer[] countdown(int start);
}
