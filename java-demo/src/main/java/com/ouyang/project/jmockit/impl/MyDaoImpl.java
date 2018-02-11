package com.ouyang.project.jmockit.impl;

import com.ouyang.project.base.TestData;
import com.ouyang.project.jmockit.MyDao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ouyang on 2017/5/26.
 */
public class MyDaoImpl implements MyDao {

    List<TestData> testDataList = new ArrayList<>();

    @Override
    public void insertData(TestData testData) {
        testDataList.add(testData);
    }

    @Override
    public void updateData(TestData testData) {
        for(TestData old : testDataList) {
            if(old.getId().equals(testData.getId())) {
                old.setParentId(testData.getParentId());
                old.setAge(testData.getAge());
                old.setBirthday(testData.getBirthday());
                old.setName(testData.getName());
            }
        }
    }

    @Override
    public void deleteData(String id) {
        for(TestData old : testDataList) {
            if(id.equals(old.getId())) {
                testDataList.remove(old);
                return ;
            }
        }
    }

    @Override
    public TestData findTestDataById(String id) {
        for(TestData old : testDataList) {
            if(id.equals(old.getId())) {
                return old;
            }
        }
        return null;
    }

    @Override
    public List<TestData> findAll() {
        return testDataList;
    }
}
