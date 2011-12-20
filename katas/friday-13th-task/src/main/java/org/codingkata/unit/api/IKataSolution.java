package org.codingkata.unit.api;

import java.util.Date;
import org.codingkata.IKataCommonSolution;

/**
 * interface for the kata's task
 * @author stephanos
 */
public interface IKataSolution
        extends IKataCommonSolution {

    /**
     * Calculate the first Friday the 13th before targeted date
     *
     * @param target    desired time travel date
     * @return          Date of the closest Friday the 13th before target
     */
    public abstract Date adjacentFriday13th(Date target);
}
