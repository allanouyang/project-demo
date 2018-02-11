package com.ouyang.project;

import org.junit.Assert;
import org.junit.Test;

import java.text.MessageFormat;

/**
 * Created by ouyang on 2017/4/26.
 */
public class StringTest {
    @Test
    public void testFormatter1(){
        String str = "你好,这是%d个格式化%s";
        Assert.assertEquals("你好,这是1个格式化例子", String.format(str, 1, "例子"));
    }

    @Test
    public void testFormatter2(){
        String str = "你好,这是{0}个格式化{1}";
        Assert.assertEquals("你好,这是1个格式化例子", MessageFormat.format(str, 1, "例子"));
    }
}
