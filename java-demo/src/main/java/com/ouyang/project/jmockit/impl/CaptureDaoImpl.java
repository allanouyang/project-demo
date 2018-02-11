package com.ouyang.project.jmockit.impl;

import com.ouyang.project.jmockit.CaptureDao;

/**
 * Created by ouyang on 2017/7/13.
 */
public class CaptureDaoImpl implements CaptureDao {
    @Override
    public String test() {
        System.out.println("test capture .......... ");
        return "test";
    }
}
