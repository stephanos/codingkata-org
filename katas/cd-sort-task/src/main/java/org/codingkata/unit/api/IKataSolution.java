package org.codingkata.unit.api;

import java.util.List;
import org.codingkata.IKataCommonSolution;

/**
 * interface for the kata's task
 * @author stephanos
 */
public interface IKataSolution
        extends IKataCommonSolution {

    /**
     * Sort a bunch of CDs alphabetically by their album title (A-Z)
     *
     * @param cds   unsorted list of album titles
     * @return      sorted list of titles
     */
    public abstract List<String> sort(List<String> cds);
}
