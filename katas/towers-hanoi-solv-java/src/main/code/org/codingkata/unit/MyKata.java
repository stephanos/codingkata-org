package org.codingkata.unit;

import org.codingkata.unit.api.BaseKataSolution;

public class MyKata extends BaseKataSolution {

    @Override
    public void rearrange() {
        move (3, 1, 3, 2);
    }

    public void move(int n, int from, int to, int via) {
        if (n == 1) {
            move(from, to);
        } else {
            move(n - 1, from, via, to);
            move(1, from, to, via);
            move(n - 1, via, to, from);
        }
    }
}
