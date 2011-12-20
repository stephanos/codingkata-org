package org.codingkata.unit;

import org.codingkata.unit.api.BaseKataSolution;

public class MyKata extends BaseKataSolution {

    @Override
    public String translate(String text, String[][] dictionary) {

        System.out.println (dictionary[2]);

        String res = text;
        for (String[] pair : dictionary) {
            String slang = pair[0];
            res = res.replace("$" + slang + "$", pair[1]);
        }
        return res;
    }

}