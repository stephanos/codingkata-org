package org.codingkata.unit.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
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
    private Stack s = new Stack();

    public void start() {

        // ==== prepare test objects ====
        Integer[] cars = {
            new Integer(5), new Integer(4), new Integer(3), new Integer(2), new Integer(1)
        };

        List<Integer> carList = Arrays.asList(cars);
        //Collections.shuffle(carList);

        // ==== start testing ====
        validate(-1, m_solution.peek(), "peek() on empty stack");
        validate(-1, m_solution.pop(), "pop() on empty stack");

        int first = carList.get(0);
        m_solution.push(first); s.push(first);
        validate(first, m_solution.peek(), "peek() after push() of " + first);

        int second = carList.get(1);
        m_solution.push(second); s.push(second);
        validate(second, m_solution.peek(), "peek() after push() of " + second);

        int third = carList.get(2);
        m_solution.push(third); s.push(third);
        validate(third, m_solution.peek(), "peek() after push() of " + third);

        int forth = carList.get(3);
        m_solution.push(forth); s.push(forth);
        validate(forth, m_solution.peek(), "peek() after push() of " + forth);

        int fifth = carList.get(4);
        m_solution.push(fifth); s.push(fifth);
        validate(fifth, m_solution.peek(), "peek() after push() of " + fifth);

        validate(fifth, m_solution.pop(), "pop() on " + printStack());
        s.pop();
        validate(forth, m_solution.peek(), "peek() on " + printStack());

        validate(forth, m_solution.pop(), "pop() on " + printStack());
        s.pop();
        validate(third, m_solution.peek(), "peek() on " + printStack());

        validate(third, m_solution.pop(), "pop() on " + printStack());
        s.pop();
        validate(second, m_solution.peek(), "peek() on " + printStack());

        validate(second, m_solution.pop(), "pop() on " + printStack());
        s.pop();
        validate(first, m_solution.peek(), "peek() on " + printStack());

        validate(first, m_solution.pop(), "pop() on " + printStack());
        s.pop();

        validate(-1, m_solution.pop(), "pop() on empty stack");
        validate(-1, m_solution.peek(), "peek() on empty stack");
    }

    private String printStack() {
        String r = "{";
        for (Object o : s.toArray()) {
            r += o + " ";
        }
        r = r.trim() + "}";
        return r;
    }

    @Override
    public void setSolution(IKataCommonSolution pSolution) {
        m_solution = (IKataSolution) pSolution;
    }
}
