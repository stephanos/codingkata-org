package org.codingkata.unit.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

        List<Integer> list = new ArrayList<Integer>(6);
        while (list.size() < 6) {
            Integer n = 1 + new Random().nextInt(49);
            if (!list.contains(n)) {
                list.add(n);
            }
        }

        for (int i = 0; i < 6; i++) {
            int n = list.get(i);
            validate(roman(n), m_solution.convert(n), n);
        }
    }

    public String roman(long n) {

        if (n < 1) {
            return null;
        }

        String result = "";
        if (n >= 50) {
            result += "L";
            n %= 50;
        }
        if (n >= 40) {
            result += "XL";
            n %= 40;
        }
        if (n >= 10) {
            result += (copies("X", (n / 10)));
            n %= 10;
        }
        if (n == 9) {
            result += "IX";
            n = 0;
        }
        if (n >= 5) {
            result += "V";
            n %= 5;
        }
        if (n == 4) {
            result += "IV";
            n = 0;
        }

        result += (copies("I", n));
        
        return result;
    }

    public String copies(String a, long n) {

        String result = "";
        for (int i = 0; i < n; i++, result += a);
        return result;
    }

    @Override
    protected String customSuccessMsg() {
        return "Let's hope you win - if you don't, Caesar might get mad ;-)";
    }

    @Override
    public void setSolution(IKataCommonSolution pSolution) {
        m_solution = (IKataSolution) pSolution;
    }
}
