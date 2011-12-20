package org.codingkata.unit.api;

import org.codingkata.IKataCommonSolution;

/**
 * interface for the kata's task
 * @author stephanos
 */
public interface IKataSolution
        extends IKataCommonSolution {

     /**
     * Revert a word in 'backward talk' to understand it
     *
     * @param word  the backwards word
     * @return      the regular word
     */
    public abstract String revert (String word);
}

