package com.ouyang.project.jmockit;

import com.ouyang.project.base.TestData;

import java.util.List;

/**
 * Created by ouyang on 2017/5/26.
 */
public interface MyDao {

    void insertData(TestData testData);

    void updateData(TestData testData);

    void deleteData(String id);

    TestData findTestDataById(String id);

    List<TestData> findAll();
}
