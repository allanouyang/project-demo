package com.ouyang.project.base;

/**
 * Created by ouyang on 2018/1/15.
 */
public class Main {

    public static void main(String[] args) {
        TestData data = new TestData();
        data.setTempInt(1);
        System.out.println(data.getTempInt() == Integer.valueOf(1));
    }
}
