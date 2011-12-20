package org.codingkata.unit;

import org.codingkata.unit.api.BaseKataSolution;

public class MyKata extends BaseKataSolution {

    @Override
    public int fibonacci(int n) {
        if (n < 1) {
            return 0;
        }

        int fn0 = 0, fn1 = 1;

        for (int i = 1; i < n; i++) {

            fn1 = fn1 + fn0;
            fn0 = fn1 - fn0;

        }
        return fn1;
    }
}
