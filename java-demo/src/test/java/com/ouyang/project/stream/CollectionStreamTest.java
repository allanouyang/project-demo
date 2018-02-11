package com.ouyang.project.stream;

import com.ouyang.project.base.TestData;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by ouyang on 2017/5/17.
 */
public class CollectionStreamTest {

    public List<TestData> initListForTestData(int[] num) {
        List<TestData> testDataList = new ArrayList<>();
        for(int i = 0; i < num[0]; i++) {
            for(int j = 0; j < num[1]; j++) {
                TestData testData = new TestData();
                int seq = ((i*num[1]) + j + 1);
                testData.setId("id:"+ seq);
                testData.setName("name:"+ seq);
                testData.setParentId("parentId:"+ i);
                testDataList.add(testData);
            }
        }
        return testDataList;
    }

    public int[] initNum() {
        Random random = new Random();
        int imax = random.nextInt(15);
        imax = imax < 2 ? 2 : imax;
        int jmax = random.nextInt(10);
        jmax = jmax < 2 ? 2 : jmax;
        return new int[] {imax, jmax};
    }

    @Test
    public void testListToMap() {
        int[] num = initNum();
        List<TestData> list = initListForTestData(num);
        Map<String, TestData> mapTestData = list.stream().collect(Collectors.toMap(TestData::getId, Function.identity()));
        Assert.assertEquals(mapTestData.size(), num[0] * num[1]);
    }

    @Test
    public void testListToMapGroup() {
        int[] num = initNum();
        List<TestData> list = initListForTestData(num);
        Map<String, List<TestData>> mapTestData = list.stream().collect(Collectors.groupingBy(TestData::getParentId));
        Assert.assertEquals(mapTestData.size(), num[0]);
    }

    @Test
    public void testTestToMapNull() {
        List<TestData> list = new ArrayList<>();
        Map<String, TestData> mapTestData = list.stream().collect(Collectors.toMap(TestData::getId, Function.identity()));
        System.out.println(mapTestData);
//        Assert.assertNull(mapTestData);
    }
}
