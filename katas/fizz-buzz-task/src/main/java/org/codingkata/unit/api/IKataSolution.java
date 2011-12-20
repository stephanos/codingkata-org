package org.codingkata.unit.api;

import org.codingkata.IKataCommonSolution;

/**
 * interface for the kata's task
 * @author stephanos
 */
public interface IKataSolution
        extends IKataCommonSolution {

    /**
     * Give an answer to the current game's number
     *
     * @param number    current number in the game sequence
     * @return          appropriate answer to the current number
     */
    public abstract String answer(int number);
}
