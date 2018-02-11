package com.ouyang.project;

import com.ouyang.project.custom.impl.CustomServiceImpl;
import com.zxy.common.mapping.annotation.LogicMapping;
import org.junit.Test;
import org.springframework.core.annotation.AnnotationUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ouyang on 2017/9/8.
 */
public class SimpleTest {

    @Test
    public void testTemp() {
        Class clazz = AnnotationUtils.findAnnotationDeclaringClass(LogicMapping.class, CustomServiceImpl.class);
        List<Annotation> annotationList = new ArrayList<>();
        Annotation aa = AnnotationUtils.findAnnotation(CustomServiceImpl.class, LogicMapping.class);
        annotationList.add(aa);
        Method[] methods = clazz.getDeclaredMethods();
        for(Method method: methods) {
            Annotation temp = AnnotationUtils.findAnnotation(method, LogicMapping.class);
            annotationList.add(temp);
        }
    }
}
