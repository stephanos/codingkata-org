package org.codingkata.unit;

import org.codingkata.unit.api.BaseKataSolution;

public class MyKata extends BaseKataSolution {

    @Override
     public Integer[] countdown(int start) {
        Integer[] l = new Integer[start+1];
        for (int i = 0; i < start+1; i++) {
            l[i] = start-i;
        }
        return l;
    }
}