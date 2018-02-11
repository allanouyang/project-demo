package com.ouyang.project.jmockit.impl;

import com.ouyang.project.base.TestData;
import com.ouyang.project.jmockit.MyDao;
import com.ouyang.project.jmockit.MyService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ouyang on 2017/5/26.
 */
public class MyServiceImpl implements MyService {

    private MyDao myDao;

    private List<String> outList;

    @Override
    public TestData getTestData(String id) {
        TestData testData = myDao.findTestDataById(id);
        System.out.println("test data ........ ");
        List<String> list = new ArrayList<>();
        list.add("list string ...... ");
        System.out.println(list.get(0));
        if(outList != null && !outList.isEmpty()) {
            System.out.println(outList.get(0));
        }
        return testData;
    }

    @Override
    public int countTestData() {
        List<TestData> testDataList = myDao.findAll();
        return testDataList.size();
    }

}
