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

    class Fraction {

        int n1, n2;

        public Fraction(int _n1, int _n2) {
            n1 = _n1;
            n2 = _n2;
        }
    }

    public void start() {
        Fraction[] n = {new Fraction(123, 246),
            new Fraction(50, 125),
            new Fraction(0, 488),
            new Fraction(113, 311),
            new Fraction(12, 8),
            new Fraction(23, 230)};
        List<Fraction> lst = Arrays.asList(n);
        Collections.shuffle(lst);

        for (Fraction f : lst) {
            validate(GCD(f.n1, f.n2), m_solution.calcGCD(f.n1, f.n2),
                    f.n1 + "/" + f.n2);
        }
    }

    private int GCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return GCD(b, a % b);
    }

    @Override
    public void setSolution(IKataCommonSolution pSolution) {
        m_solution = (IKataSolution) pSolution;
    }
}
