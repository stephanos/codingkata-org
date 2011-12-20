package org.codingkata.unit.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import org.codingkata.IKataCommonSolution;
import org.codingkata.KataCommonTask;
import org.codingkata.unit.api.IKataSolution;
import org.codingkata.unit.api.IKataTask;

/**
 * the kata task
 * @author stephanos
 */
public class KataTask
        extends KataCommonTask
        implements IKataTask {

    private IKataSolution m_solution;

    public void start() {

        int size = 41;
        int step = 2 + new Random ().nextInt(8);

        validate(
                lastOne(size, step),
                m_solution.calcSurvivalPosition(size, step),
                "size:" + size, "skip:" + step);
    }

    protected int lastOne(int size, int skip) {
        
        int currentMen = 0;
        ArrayList<Integer> men;

        men = new ArrayList<Integer>();
        for (int i = 1; i <= size; i++) {
            men.add(i);
        }

        while (1 < men.size()) {
            int menToDieIndex;

            menToDieIndex = (currentMen + skip - 1) % men.size();
            men.remove(menToDieIndex);
            currentMen = menToDieIndex;
        }

        return men.get(0);
    }

    @Override
    public void setSolution(IKataCommonSolution pSolution) {
        m_solution = (IKataSolution) pSolution;
    }
}
