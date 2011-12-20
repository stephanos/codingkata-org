package org.codingkata.unit;

import org.codingkata.unit.api.BaseKataSolution;

public class MyKata extends BaseKataSolution {

    @Override
    public String answer(int number) {

        final int div3 = number % 3;
        final int div5 = number % 5;

        if (div3 == 0 && div5 == 0) {
            return "fizzbuzz";
        } else if (div3 == 0) {
            return "fizz";
        } else if (div5 == 0) {
            return "buzz";
        } else {
            return new Integer (number).toString();
        }
    }
}