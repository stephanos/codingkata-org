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
        m_solution.rearrange();
        validate(m_solution.getTower().toString(), "[ 0 0 3 ]");
    }

    @Override
    public void setSolution(IKataCommonSolution pSolution) {
        m_solution = (IKataSolution) pSolution;
    }
}
