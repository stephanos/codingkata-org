package org.codingkata.unit.impl;

import org.codingkata.IKataCommonSolution;
import org.codingkata.KataCommonTask;
import org.codingkata.unit.api.IKataSolution;
import org.codingkata.unit.api.IKataTask;

/**
 * the kata task
 * @author stephanos
 */
public class KataTask
        extends KataCommonTask
        implements IKataTask {

    private IKataSolution m_solution;

    public void start() {

        String[] words = {
            "yak", "I", "hate", "spinach"
        };

        for (String w : words) {
            String rev = reverseIt (w);
            validate(w, m_solution.revert(rev), rev);
        }
    }

    public String reverseIt(String source) {

        int i, len = source.length();
        StringBuffer dest = new StringBuffer(len);

        for (i = (len - 1); i >= 0; i--) {
            dest.append(source.charAt(i));
        }
        return dest.toString();
    }

    @Override
    protected String customSuccessMsg() {
        return "They said 'Yak, I hate spinach!' - maybe time for some Popeye...";
    }

    @Override
    public void setSolution(IKataCommonSolution pSolution) {
        m_solution = (IKataSolution) pSolution;
    }

}
