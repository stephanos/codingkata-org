package org.codingkata.unit.impl;

import java.util.ArrayList;
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

    class Code {

        String c1, c2, c3;
        boolean hasPrime;

        Code(String _c1, String _c2, String _c3, boolean p) {
            c1 = _c1;
            c2 = _c2;
            c3 = _c3;
            hasPrime = p;
        }
    }

    public void start() {

        List<Code> codes = new ArrayList<Code>(6);
        codes.add(new Code("11442", "98164", "09542", false));
        codes.add(new Code("28733", "54812", "33099", true));   // 1st
        codes.add(new Code("69182", "47201", "20742", false));
        codes.add(new Code("87120", "55432", "10234", true));   // 2nd
        codes.add(new Code("27124", "88811", "12854", false));
        codes.add(new Code("34784", "25481", "02540", true));   // 3rd
        Collections.shuffle(codes);

        for (Code c : codes) {
            validate(c.hasPrime,
                    m_solution.containsPrimeNumber(c.c1, c.c2, c.c3),
                    c.c1, c.c2, c.c3);
        }
    }

    @Override
    public void setSolution(IKataCommonSolution pSolution) {
        m_solution = (IKataSolution) pSolution;
    }
}
