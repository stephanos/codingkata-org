package org.codingkata.unit.api;

import org.codingkata.IKataCommonSolution;

/**
 * interface for the kata's task
 * @author stephanos
 */
public interface IKataSolution
        extends IKataCommonSolution {

    /**
     * Rewrite an incoming URL
     *
     * @param url   requested URL
     * @return      rewritten URL
     */
    public abstract String rewrite(String url);
}
