package org.codingkata.unit;

import org.codingkata.unit.api.BaseKataSolution;

public class MyKata extends BaseKataSolution {

    @Override
    public int calcGCD(int a, int b) {

        if (b == 0) {
            return a;
        }
        return calcGCD(b, a % b);
    }

}