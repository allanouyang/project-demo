package com.ouyang.project.framework.scope;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

/**
 * Created by ouyang on 2018/1/27.
 */
public class SimpleThreadScope implements Scope {

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        Object instance = ThreadBeanHolder.getInstance(name);
        if(instance == null) {
            instance = objectFactory.getObject();
            ThreadBeanHolder.setInstance(name, instance);
        }
        return instance;
    }

    @Override
    public Object remove(String name) {
        Object instance = ThreadBeanHolder.getInstance(name);
        if(instance != null) {
            ThreadBeanHolder.remove(name);
            return instance;
        }
        return null;
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {

    }

    @Override
    public Object resolveContextualObject(String key) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }
}
