package com.ouyang.project.collection;

import com.ouyang.project.base.TestData;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by ouyang on 2017/6/3.
 */
public class CollectionTest {
    @Test
    public void testIterateRemove() {
        List<TestData> testDataList = new ArrayList<>();
        TestData testData = new TestData();
        testData.setId("1");
        testData.setName("name1");
        testDataList.add(testData);
        testData = new TestData();
        testData.setId("2");
        testDataList.add(testData);
        testData = new TestData();
        testData.setId("3");
        testData.setName("name3");
        testDataList.add(testData);
        Iterator<TestData> it = testDataList.iterator();
        while(it.hasNext()) {
            TestData data = it.next();
            if(data.getName() == null || data.getName().isEmpty()) {
                it.remove();
            }
        }
        Assert.assertEquals(2, testDataList.size());
    }
}
