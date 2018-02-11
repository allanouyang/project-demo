package com.ouyang.project.jmockit;

import com.ouyang.project.base.TestData;
import com.ouyang.project.jmockit.impl.MyServiceImpl;
import mockit.*;
import mockit.integration.junit4.JMockit;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

/**
 * Created by ouyang on 2017/5/26.
 */
@RunWith(JMockit.class)
public class MyServiceTest {

    @Tested
    MyServiceImpl myService;

    @Injectable MyDao myDao;

    @Mocked
    List<String> outList1;

    @Capturing CaptureDao captureDao;

    @Test
    public void testFindTestDataById() {
        TestData testData1 = new TestData();
        testData1.setName("test data1");
        new Expectations() {{
            myDao.findTestDataById("1"); result = testData1;
            captureDao.test(); result = "mytest";
            outList1.get(0); result = "mock string ... ";
            outList1.isEmpty(); result = false;
        }};
        Deencapsulation.setField(myService, "outList", outList1);
        TestData result1 = myService.getTestData("1");
        Assert.assertEquals(result1.getName(), "test data1");
        String result3 = captureDao.test();
        Assert.assertEquals(result3, "mytest");

        new Verifications() {{
//            myService.getTestData(anyString); times = 1;
        }};
    }
}
