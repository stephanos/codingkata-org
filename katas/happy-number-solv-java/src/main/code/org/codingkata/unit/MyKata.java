package org.codingkata.unit;

import java.util.HashSet;
import org.codingkata.unit.api.BaseKataSolution;

public class MyKata extends BaseKataSolution {

    @Override
    public boolean isHappy(long number) {

        long m = 0;
        int digit = 0;
        HashSet<Long> cycle = new HashSet<Long>();
        while (number != 1 && cycle.add(number)) {
            m = 0;
            while (number > 0) {
                digit = (int) (number % 10);
                m += digit * digit;
                number /= 10;
            }
            number = m;
        }
        return number == 1;
    }
}
