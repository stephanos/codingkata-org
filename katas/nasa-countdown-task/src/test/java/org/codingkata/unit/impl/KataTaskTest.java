package org.codingkata.unit.impl;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Tests the kata task
 * @author stephanos
 */
@Test
public class KataTaskTest {

    private KataTask task;

    @BeforeTest
    protected void setUp() throws Exception {
        task = new KataTask ();
    }

    @Test(expectedExceptions= {NullPointerException.class})
    public void test1 () {
       task.check(null, 1);
    }

    public void test2 () {
       task.check(new Integer[] {4, 3, 2, 1, 0}, 4);
       Assert.assertEquals(task.getResult().isPassed(), true);
    }
    
    public void test3 () {
       task.check(new Integer[] {4, 3, 2, 1}, 4);
       Assert.assertEquals(task.getResult().isPassed(), false);
    }

    public void test4 () {
       task.check(new Integer[] {3, 2, 1, 0}, 4);
       Assert.assertEquals(task.getResult().isPassed(), false);
    }

    public void test5 () {
       task.check(new Integer[] {5, 4, 3, 2, 1, 0}, 4);
       Assert.assertEquals(task.getResult().isPassed(), false);
    }

    public void test6 () {
       task.check(new Integer[] {3, 4, 2, 1, 0}, 4);
       Assert.assertEquals(task.getResult().isPassed(), false);
    }
}
