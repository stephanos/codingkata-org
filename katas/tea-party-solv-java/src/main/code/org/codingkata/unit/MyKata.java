package org.codingkata.unit;

import org.codingkata.unit.api.BaseKataSolution;

public class MyKata extends BaseKataSolution {

    @Override
    public String welcome(String name, boolean isWoman, boolean isSir) {

        String ret = new String("Hello ");
        if (isWoman) {
            ret += "Ms. ";
        } else if (isSir) {
            ret += "Sir ";
        } else {
            ret += "Mr. ";
        }
        ret += name;
        return ret;
    }
}