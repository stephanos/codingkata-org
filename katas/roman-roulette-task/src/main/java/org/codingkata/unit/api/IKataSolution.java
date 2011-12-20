package org.codingkata.unit.api;

import org.codingkata.IKataCommonSolution;

/**
 * interface for the kata's task
 * @author stephanos
 */
public interface IKataSolution
        extends IKataCommonSolution {

    /**
     * Calculate the position to stand in order to survive
     *
     * @param size      size of the circle
     * @param skip      persons to skip each round
     */
    public abstract int calcSurvivalPosition(int size, int skip);
}
