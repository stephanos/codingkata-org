package org.codingkata.unit.impl;

import java.util.Random;
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

        int start = 10 + new Random ().nextInt(5);
        Integer[] c = m_solution.countdown(start);
        check (c, start);
    }

    public void check (Integer[] c, int start) {

        System.out.print ("Your answer: [ ");
        for (int i = 0; i < c.length; i++) {
            System.out.print (c[i] + " ");
        }
        System.out.println ("]");

        if (c == null)
            throw new NullPointerException ("the countdown array is null!");
        else {
            int n = start;
            for (int i = 0; i < start+1; i++) {
                boolean result = false;
                if (c.length > i)
                    result = validate (n, c[i]);
                else
                    result = validate (n, "");
                n--;
                if (!result) return;
            }
        }
    }

    @Override
    protected String customSuccessMsg () {
        return "LIFTOFF :-)";
    }

    @Override
    public void setSolution(IKataCommonSolution pSolution) {
        m_solution = (IKataSolution) pSolution;
    }
}
