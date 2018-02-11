package com.ouyang.project.framework.scope;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ouyang on 2018/1/27.
 */
public class ThreadBeanHolder {

    private static ThreadLocal<Map<String, Object>> threadLocal = new ThreadLocal<>();

    public static Object getInstance(String name) {
        Map<String, Object> map = threadLocal.get();
        if(map != null) {
            return map.get(name);
        }
        return null;
    }

    public static void setInstance(String name, Object obj) {
        Map<String, Object> map = threadLocal.get();
        if(map == null) {
            map = new HashMap<>();
        }
        map.put(name, obj);
        threadLocal.set(map);
    }

    public static void remove(String name) {
        Map<String, Object> map = threadLocal.get();
        if(map != null) {
            map.remove(name);
        }
    }
}
