package org.codingkata.unit;

import org.codingkata.unit.api.BaseKataSolution;

public class MyKata extends BaseKataSolution {

    @Override
    public String convert(int n) {

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
}
