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

    public void testDontAcceptPartialAnswers () {
        assertEquals(false, task.validateReponse("hello"));
        assertEquals(false, task.validateReponse("world"));
        assertEquals(false, task.validateReponse("!"));
        assertEquals(false, task.validateReponse("helloz world!"));
        assertEquals(false, task.validateReponse("hallo welt"));
    }

    public void testAcceptCorrectAnswers () {
        assertEquals(true, task.validateReponse("hello world"));
        assertEquals(true, task.validateReponse("HELLO WORLD"));
    }
}
