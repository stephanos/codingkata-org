package org.codingkata.unit.api;

import org.codingkata.IKataCommonSolution;

/**
 * interface for the kata's task
 * @author stephanos
 */
public interface IKataSolution
        extends IKataCommonSolution {

    /**
     * @param name      the last name of the guest
     * @param isWoman   true if the guest is female
     * @param isSir     true if the guest was knighted by the queen ("sir")
     *
     * @return          issues welcome text to the guest
     */
    public abstract String welcome(String name, boolean isWoman, boolean isSir);
}
