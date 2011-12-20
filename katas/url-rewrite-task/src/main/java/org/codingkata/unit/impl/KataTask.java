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

        String in, out;

        /*
         * 1) /article/$1 into /article?id=$1 
         */
        in = "/article/15";
        out = "/article?id=15";
        validate(out, m_solution.rewrite(in), in);

        in = "/article/15099";
        out = "/article?id=15099";
        validate(out, m_solution.rewrite(in), in);

        in = "/article/random-non-id-text";
        out = "/article/random-non-id-text";
        validate(out, m_solution.rewrite(in), in);

        /*
         * 2) /guide/$1/2008/$2 into /guide/$1/2009/$2 
         */

        in = "/guide/audit/2008/index.html";
        out = "/guide/audit/2009/index.html";
        validate(out, m_solution.rewrite(in), in);

        in = "/guide/audit/2008/appendix/";
        out = "/guide/audit/2009/appendix/";
        validate(out, m_solution.rewrite(in), in);

        in = "/guide/2008/index.html";
        out = "/guide/2008/index.html";
        validate(out, m_solution.rewrite(in), in);

        in = "/guide/audit/2008/";
        out = "/guide/audit/2009/";
        validate(out, m_solution.rewrite(in), in);

        /*
         * 3) /company/$1/$2 into /company?country=$1&city=$2 
         */

        in = "/company/uk/london";
        out = "/company?country=uk&city=london";
        validate(out, m_solution.rewrite(in), in);

        in = "/company/germany/berlin";
        out = "/company?country=germany&city=berlin";
        validate(out, m_solution.rewrite(in), in);

        in = "/company/germany";
        out = "/company?country=germany";
        validate(out, m_solution.rewrite(in), in);

        in = "/company/germany/";
        out = "/company?country=germany";
        validate(out, m_solution.rewrite(in), in);
        
        /*
         * Other
         */
        in = "/contact";
        out = "/contact";
        validate(out, m_solution.rewrite(in), in);
    }

    @Override
    public void setSolution(IKataCommonSolution pSolution) {
        m_solution = (IKataSolution) pSolution;
    }
}
