package com.ouyang.project;

import org.junit.Test;

/**
 * Created by ouyang on 2017/9/5.
 */
public class MyTest {

    @Test
    public void testBitMove() {
        System.out.println(4 << 16);
        System.out.println(Math.pow(2, 18));
        System.out.println(0 << 8);
        System.out.println(4 << 16 | 0 << 8 | 0);
        System.out.println(5 << 16);
        System.out.println(Math.pow(2, 18) + Math.pow(2, 16));
        System.out.println(5 << 16 | 0 << 8 | 0);
        System.out.println(3 << 16 | 45);
        System.out.println(Math.pow(2, 17) + Math.pow(2, 16) + 45);
        System.out.println(0 << 16 | 46);
        System.out.println(0 << 16 | 47);
        System.out.println(0 << 16 | 48);
        System.out.println(0 << 16 | 49);
        System.out.println(0 << 16 | 50);
        System.out.println(0 << 16 | 51);
        System.out.println(0 << 16 | 52);
    }
}
