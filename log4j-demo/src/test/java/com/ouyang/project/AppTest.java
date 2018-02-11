package com.ouyang.project;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    @Test(timeout = 10)
    public void testALog() {
        Log4jA log4jA = new Log4jA();
        log4jA.testLog();
    }
}
