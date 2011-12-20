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

    private IKataSolution m_solution = null;

    public void start() {
        
        validateReponse(m_solution.reply());
    }

    protected boolean validateReponse(String pResponse) {

        if (pResponse == null) pResponse = "";
        String modResponse = pResponse.toLowerCase();
        modResponse = modResponse.trim();
        return validate("hello world", modResponse);
    }

    @Override
    public void setSolution(IKataCommonSolution pSolution) {
        m_solution = (IKataSolution) pSolution;
    }
}
