package org.codingkata.unit.impl;

import java.util.EmptyStackException;
import java.util.Stack;

public class Tower {

    class Disc {

        public int size;

        Disc(int _size) {
            size = _size;
        }
    }

    class Pole extends Stack<Disc> {

        int num;

        Pole(int _num) {
            num = _num;
        }

        @Override
        public synchronized Disc pop() {

            try {
                peek();
            } catch (EmptyStackException e) {
                throw new RuntimeException("You tried to move a disc"
                        + " from the empty pole '" + num + "'!");
            }

            return super.pop();
        }

        @Override
        public Disc push(Disc item) {

            int cur_size = Integer.MAX_VALUE;
            try {
                cur_size = peek().size;
            } catch (EmptyStackException e) {
            }

            if (cur_size < item.size) {
                throw new RuntimeException("You can't put the disc with size " + item.size
                        + " on pole '" + num + "' because there is one with size " + cur_size + " already!");
            }

            return super.push(item);
        }
    }
    private Pole P1, P2, P3;

    public Tower() {
        this (3);
    }
    public Tower(int discs) {
        P1 = new Pole(1);
        P2 = new Pole(2);
        P3 = new Pole(3);
        for (int i = discs; i > 0; i--) {
            P1.push(new Disc(i));
        }
    }

    @Override
    public String toString() {
        return "[ " + P1.size() + " " + P2.size() + " " + P3.size() + " ]";
    }

    public void move(int fromPoleNum, int toPoleNum) {
        System.out.print("Moving disk from pole '" + fromPoleNum + "' to pole '" + toPoleNum + "'");
        Pole from = fetchPole(fromPoleNum);
        Pole to = fetchPole(toPoleNum);
        to.push(from.pop());
        System.out.println(" -> " + toString());
    }

    private Pole fetchPole(final int num) {
        switch (num) {
            case 1:
                return P1;
            case 2:
                return P2;
            case 3:
                return P3;
            default:
                throw new RuntimeException("There is no pole '" + num + "'!");
        }
    }
}
