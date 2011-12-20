package org.codingkata.test;

import org.codingkata.IKataCommonTask;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class CommonIntegrationTest
        extends CommonKataExecution {

    @Test
    public final void testKata() throws Exception {

        IKataCommonTask kataTask = executeKata();

        if (kataTask != null) {
            Assert.assertTrue(kataTask.getResult().isSolved());
        } else {
            Assert.fail("There was an unexpected internal error: " +
                        " No kata task was found.");
        }
    }

}
