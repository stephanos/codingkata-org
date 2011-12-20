package org.codingkata.unit;

import java.util.ArrayList;
import org.codingkata.unit.api.BaseKataSolution;

public class MyKata extends BaseKataSolution {

    @Override
    public int calcSurvivalPosition(int size, int skip) {

         int currentMen = 0;
        ArrayList<Integer> men;

        men = new ArrayList<Integer>();
        for (int i = 1; i <= size; i++) {
            men.add(i);
        }

        while (1 < men.size()) {
            int menToDieIndex = (currentMen + skip - 1) % men.size();
            men.remove(menToDieIndex);
            currentMen = menToDieIndex;
        }

        return men.get(0);
    }
}