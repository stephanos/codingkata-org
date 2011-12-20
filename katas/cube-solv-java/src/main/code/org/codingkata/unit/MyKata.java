package org.codingkata.unit;

import org.codingkata.unit.api.BaseKataSolution;

public class MyKata extends BaseKataSolution {

    public boolean containsPrimeNumber(String code1, String code2, String code3) {

        return isPrime (checksum (code1))
                || isPrime (checksum (code2))
                || isPrime (checksum (code3));
    }

    protected Integer checksum (String s) {

        int sum = 0;
        for (int i=0; i<s.length(); i++) {
            sum += Integer.valueOf(String.valueOf(s.charAt(i)));
        }
        return sum;
    }

    protected boolean isPrime(int number) {

        System.out.println("####");
        System.out.println("testing " + number);
        if (number == 1 || number == 2) {
            return true;
        }

        for (int i = 2; i < (int) (number / 2); i++) {
            if ((number % i) == 0) {
                System.out.println("Divisible by " + i);
                return false;
            }
        }
        System.out.println("Prime is " + number);
        return true;
    }
}