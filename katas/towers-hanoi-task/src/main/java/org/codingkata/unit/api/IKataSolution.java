package org.codingkata.unit.api;

import org.codingkata.IKataCommonSolution;
import org.codingkata.unit.impl.Tower;

/**
 * interface for the kata's task
 * @author stephanos
 */
public interface IKataSolution
        extends IKataCommonSolution {

    /**
     * Rearranges the tower by moving all discs from pole 1 to 3
     */
    public abstract void rearrange();

    public Tower getTower();
}
