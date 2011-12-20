#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package org.codingkata.unit.impl;

import org.codingkata.IKataCommonSolution;
import org.codingkata.KataCommonTask;
import org.codingkata.unit.api.BaseKataSolution;
import org.codingkata.unit.api.IKataTask;

/**
 * the kata task
 * @author stephanos
 */
public class KataTask
        extends KataCommonTask
        implements IKataTask {

    private BaseKataSolution m_solution;

    public void start() {

        // TODO
    }

    @Override
    public void setSolution(IKataCommonSolution pSolution) {
        m_solution = (BaseKataSolution) pSolution;
    }
}
