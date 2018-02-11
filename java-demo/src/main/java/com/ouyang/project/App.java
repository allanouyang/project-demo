package com.ouyang.project;

import com.ouyang.project.base.TestData;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        TestData data = new TestData();
        validateHourMin("00:00");
        System.out.println("success");
    }

    private static void validateHourMin(String time) {
        if(time.length() != 5) {
            throw new RuntimeException("时间格式设置不正确");
        }
        validateHourMinChar(time.charAt(0), 48, 50);
        validateHourMinChar(time.charAt(1), 48, 51);
        validateHourMinChar(time.charAt(2), 58, 58);
        validateHourMinChar(time.charAt(3), 48, 53);
        validateHourMinChar(time.charAt(4), 48, 57);
    }

    private static void validateHourMinChar(char c, int start, int end) {
        if(c < start || c > end) {
            throw new RuntimeException("时间格式设置不正确");
        }
    }
}
