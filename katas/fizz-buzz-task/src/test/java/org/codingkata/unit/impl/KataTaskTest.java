package org.codingkata.unit.impl;

import junit.framework.TestCase;

/**
 * Tests the kata task
 * @author stephanos
 */
public class KataTaskTest extends TestCase {

    private KataTask task;

    @Override
    protected void setUp() throws Exception {
        task = new KataTask ();
    }

    public void testCalcFizzForMultiplesOf3 () {
        assertEquals("fizz", task.calcExpectation (3).toLowerCase());
        assertEquals("fizz", task.calcExpectation (6).toLowerCase());
        assertEquals("fizz", task.calcExpectation (33).toLowerCase());
    }

    public void testCalcBuzzForMultiplesOf5 () {
        assertEquals("buzz", task.calcExpectation (5).toLowerCase());
        assertEquals("buzz", task.calcExpectation (20).toLowerCase());
        assertEquals("buzz", task.calcExpectation (100).toLowerCase());
    }

    public void testCalcFizzBuzzForMultiplesOf3And5 () {
        assertEquals("fizzbuzz", task.calcExpectation (15).toLowerCase());
        assertEquals("fizzbuzz", task.calcExpectation (90).toLowerCase());
    }

    public void testOutputNumberForNonMultiplesOf3Or5 () {
        assertEquals("1", task.calcExpectation (1));
        assertEquals("2", task.calcExpectation (2));
        assertEquals("4", task.calcExpectation (4));
        assertEquals("52", task.calcExpectation (52).toLowerCase());
    }
}
