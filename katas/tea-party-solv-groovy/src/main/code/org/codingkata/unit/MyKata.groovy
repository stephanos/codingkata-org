package org.codingkata.unit;

import org.codingkata.unit.api.BaseKataSolution;

class MyKata extends BaseKataSolution {

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