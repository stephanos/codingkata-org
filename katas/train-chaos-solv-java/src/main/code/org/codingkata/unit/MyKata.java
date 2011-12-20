package org.codingkata.unit;

import java.util.ArrayList;
import org.codingkata.unit.api.BaseKataSolution;

public class MyKata extends BaseKataSolution {

    ArrayList<Integer> stack = new ArrayList<Integer> ();

    @Override
    public void push(Integer car) {
        stack.add(car);
    }

    @Override
    public Integer pop() {
        if (stack.isEmpty())
            return -1;
        else {
            return stack.remove(stack.size() - 1);
        }
    }

    @Override
    public Integer peek() {
        if (stack.isEmpty())
            return -1;
        else {
            return stack.get(stack.size() - 1);
        }
    }
}