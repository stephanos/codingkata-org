package org.codingkata.unit.api;

import junit.framework.TestCase;
import org.codingkata.unit.impl.Tower;

public class KataInterfaceTest extends TestCase {

    private Tower tower;

    @Override
    protected void setUp() throws Exception {
        tower = new Tower(3);
    }

    public void test1() {
        tower.move(1, 3);
        tower.move(3, 1);
    }

    public void test2() {
        tower.move(1, 3);
        tower.move(1, 2);
        tower.move(3, 2);
    }

    public void test3() throws Exception {
        try {
            tower.move(3, 2);
            fail("Expected runtime exception for this move!");
        } catch (RuntimeException expected) {
        }
    }

    public void test4() throws Exception {
        try {
            tower.move(1, 3);
            tower.move(1, 3);
            fail("Expected runtime exception for this move!");
        } catch (RuntimeException expected) {
        }
    }

    public void test5() throws Exception {
        try {
            tower.move(1, 5);
            fail("Expected runtime exception for this move!");
        } catch (RuntimeException expected) {
        }
    }

    public void test6() throws Exception {
        try {
            tower.move(0, 3);
            fail("Expected runtime exception for this move!");
        } catch (RuntimeException expected) {
        }
    }
}
