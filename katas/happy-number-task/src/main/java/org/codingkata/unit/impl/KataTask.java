package org.codingkata.unit.impl;

import java.util.Arrays;
import java.util.List;
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

    private Integer[] happy = {
         1 ,  7 ,  10 ,  13 ,  19 ,  23 ,  28 ,  31 ,  32 ,  44 ,  49 ,  68 ,
         70 ,  79 ,  82 ,  86 ,  91 ,  94 ,  97 ,  100 ,  103 ,  109 ,  129 ,
         130 ,  133 ,  139 ,  167 ,  176 ,  188 ,  190 ,  192 ,  193 ,  203 ,
         208 ,  219 ,  226 ,  230 ,  236 ,  239 ,  262 ,  263 ,  280 ,  291 ,
         293 ,  301 ,  302 ,  310 ,  313 ,  319 ,  320 ,  326 ,  329 ,  331 ,
         338 ,  356 ,  362 ,  365 ,  367 ,  368 ,  376 ,  379 ,  383 ,  386 ,
         391 ,  392 ,  397 ,  404 ,  409 ,  440 ,  446 ,  464 ,  469 ,  478 ,
         487 ,  490 ,  496
    };

    public void start() {

        List<Integer> hList = Arrays.asList(happy);

        for (int i=0; i < 15; i++) {
            boolean isHappy = true;
            Random rand = new Random();
            int n = happy[Math.max(0, rand.nextInt(happy.length-1))];
            if (rand.nextBoolean()) {
                do {
                    n += rand.nextInt(5) * (rand.nextBoolean() ? -1 : 1);
                } while (hList.contains(n));
                isHappy = false;
            }
            validate(isHappy, m_solution.isHappy(n), n);
        }
    }

    @Override
    public void setSolution(IKataCommonSolution pSolution) {
        m_solution = (IKataSolution) pSolution;
    }
}
