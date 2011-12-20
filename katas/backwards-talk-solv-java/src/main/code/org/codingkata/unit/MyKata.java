package org.codingkata.unit;

import org.codingkata.unit.api.BaseKataSolution;

public class MyKata extends BaseKataSolution {

    @Override
    public String revert(String word) {

        int i, len = word.length();
        StringBuilder dest = new StringBuilder(len);

        for (i = (len - 1); i >= 0; i--) {
            dest.append(word.charAt(i));
        }
        return dest.toString();
    }
}
