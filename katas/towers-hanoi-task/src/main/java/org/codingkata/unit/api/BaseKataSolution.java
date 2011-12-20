package org.codingkata.unit.api;

import org.codingkata.unit.impl.Tower;

/**
 * interface for the kata's solution
 * @author stephanos
 */
public abstract class BaseKataSolution
        implements IKataSolution {

    private Tower t = new Tower(3);

    /**
     * Call this to move one disk from 'fromPoleNum' to 'toPoleNum'
     * (e.g. move (1,3) moves a disc from pole 1 to 3)
     *
     * @param fromPoleNum   the pole to take the disc from
     * @param toPoleNum     the pole to put the disk on
     */
    protected void move(int fromPoleNum, int toPoleNum) {
        t.move(fromPoleNum, toPoleNum);
    }

    @Override
    public Tower getTower() {
        return t;
    }
}
