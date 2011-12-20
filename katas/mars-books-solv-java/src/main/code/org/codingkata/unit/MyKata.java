package org.codingkata.unit;

import org.codingkata.unit.api.BaseKataSolution;

public class MyKata extends BaseKataSolution {

    @Override
    public int calcCheckDigit(String isbn) {

        int sum = 0;
        boolean b = true;

        for (String s : isbn.split("")) {
            if (!s.isEmpty()) {
                sum += (b ? 1 : 3) * new Integer(s);
                b = !b;
            }
        }

        return 10 - (sum % 10);
    }
}
