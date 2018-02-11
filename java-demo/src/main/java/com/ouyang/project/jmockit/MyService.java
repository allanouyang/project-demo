package com.ouyang.project.jmockit;

import com.ouyang.project.base.TestData;

/**
 * Created by ouyang on 2017/5/26.
 */
public interface MyService {

    TestData getTestData(String id);

    int countTestData();

}
