package org.codingkata.unit.api;

import org.codingkata.IKataCommonSolution;

/**
 * interface for the kata's task
 * @author stephanos
 */
public interface IKataSolution
        extends IKataCommonSolution {

    /**
     * Translate a slang text to a TV news-compatible text
     *
     * @param text          string full of slang (e.g. 'I am $kewl$')
     * @param dictionary    slang dictionary - in pairs, like {{slang, non-slang}, ...}
     *
     * @return              the 'cleaned' text
     */
    public abstract String translate(String text, String[][] dictionary);
}
