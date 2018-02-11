package com.ouyang.project.jmockit;

import com.ouyang.project.base.TestData;
import com.ouyang.project.jmockit.impl.MyServiceImpl;
import mockit.Mock;
import mockit.MockUp;
import mockit.Tested;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by ouyang on 2017/7/15.
 */
public class MyMockUpTest {

    public static final class ExampleMockUp extends MockUp<MyServiceImpl>
    {
        @Mock // fake implementation for a method of the same signature
        public TestData getTestData(String args)
        {
            // Return (or throw) a "fake" result for invocations to the method in the faked class:
            TestData testData = new TestData();
            testData.setName("test mockup name .... ");
            System.out.println("mock up success ...... ");
            return testData;
        }

        @Mock
        public int countTestData() {
            return 10;
        }

        // Other @Mock methods for other methods or constructors in ExternalService, if needed.
    }

    @Tested
    MyServiceImpl myService;
    @BeforeClass
    public static void applyMockUps()
    {
        // Applies the mock-up by instantiating it:
//        myService = new ExampleMockUp().getMockInstance();
        new ExampleMockUp();
    }



    @Test
    public void testFindTestDataById() {
        TestData testData = myService.getTestData("");
        System.out.println(myService.countTestData());
//        System.out.println(testData.getName());
    }
}
