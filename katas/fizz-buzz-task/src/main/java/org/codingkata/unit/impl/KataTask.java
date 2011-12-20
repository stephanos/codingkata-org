package org.codingkata.unit.impl;

import java.util.List;
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

        Random rn = new Random();
        Integer start = rn.nextInt(80);
        Integer end = start + 20;

        // validate response
        while (start != end) {
            String expect = calcExpectation(start);
            String actual = m_solution.answer(start);
            validate(expect, actual, start);
            start += 2;
        }
    }

    protected String calcExpectation(Integer pNumber) {

        final int div3 = pNumber % 3;
        final int div5 = pNumber % 5;

        if (div3 == 0 && div5 == 0) {
            return "fizzbuzz";
        } else if (div3 == 0) {
            return "fizz";
        } else if (div5 == 0) {
            return "buzz";
        } else {
            return pNumber.toString();
        }
    }

    @Override
    public void setSolution(IKataCommonSolution pSolution) {
        m_solution = (IKataSolution) pSolution;
    }
}
