package org.codingkata.unit.impl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
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

        Integer[] ns = {2, 6, 4, 20, 15, 11, 9, 8};
        List<Integer> l = Arrays.asList(ns);
        Collections.shuffle(l);

        for (int n : l) {
            validate(fibN(n), m_solution.fibonacci(n), n);
        }
    }

    public int fibN(int n) {

        if (n < 2) {
            return n;
        }
        int ans = 0;
        int n1 = 0;
        int n2 = 1;
        for (n--; n > 0; n--) {
            ans = n1 + n2;
            n1 = n2;
            n2 = ans;
        }
        return ans;
    }

    @Override
    public void setSolution(IKataCommonSolution pSolution) {
        m_solution = (IKataSolution) pSolution;
    }
}
