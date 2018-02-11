package com.ouyang.project.framework.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by ouyang on 2018/1/27.
 */
@Component
@Scope("thread")
public class ScopeSampleBean {

    private int count = 0;

    public void plus() {
        count ++;
    }

    public int getValue(){
        return count;
    }
}
