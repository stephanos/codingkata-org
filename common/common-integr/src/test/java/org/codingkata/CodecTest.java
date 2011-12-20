package org.codingkata;

import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class CodecTest  {

    @Test
    public void testKata() throws Exception {
        syncTest (10.0);
        syncTest (1.0);
        syncTest (0.01);
        syncTest (121212);
        syncTest (0);
        syncTest (121212121.21);
        syncTest (1212.121212121);
    }

    private void syncTest (double d) {

        String sic = "hello-world-and-this-is-a-really-long-sic-isn't-it?DoYouAgree?IWould!";
        String enc = Codec.encode(d, sic);
        double dec = Codec.decode(enc, sic);
        System.out.println (dec + " should be " + d + " (was " + enc+ ")");
        Assert.assertEquals(dec, d);
    }

}
