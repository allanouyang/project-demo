package com.ouyang.project.jooq;

import com.ouyang.project.config.JooqTestConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by ouyang on 2018/1/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {JooqTestConfig.class, JooqExecuteListener.class})
public class JooqExecuteListenerTest {

    @Autowired
    private JooqExecuteListener listener;

    @Test
    public void testAddOneListener() {
        listener.addOneListener();
    }
}
