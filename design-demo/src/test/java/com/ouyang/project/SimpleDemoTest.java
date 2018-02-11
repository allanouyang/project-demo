package com.ouyang.project;

import org.junit.*;

/**
 * Created by ouyang on 2017/8/23.
 */
public class SimpleDemoTest {

    @BeforeClass
    public static void classBefore() {
        System.out.println("class before ...... ");
        System.out.println();
    }

    @AfterClass
    public static void classAfter() {
        System.out.println("class after ...... ");
    }

    @Before
    public void methodBefore() {
        System.out.println("method before ...... ");
    }

    @After
    public void methodAfter() {
        System.out.println("method after ...... ");
    }
    @Test
    public void testAdd() {
        SimpleDemo demo = new SimpleDemo();
        Assert.assertEquals(demo.add(1, 2), 3);
        System.out.println("execute ...... ");
    }
}
