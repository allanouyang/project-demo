package com.ouyang.project.jooq;

import com.ouyang.project.config.JooqTestConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by ouyang on 2017/12/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {JooqTestConfig.class, JooqSqlBuilder.class})
public class JooqSqlBuilderTest {

    @Autowired
    private JooqSqlBuilder builder;

    @Test
    public void testGenerateSimpleSql() {
        System.out.println(builder.generateSimpleSql());
    }

    @Test
    public void testGenerateSimpleSql2() {
        System.out.println(builder.generateSimpleSql2());
    }

    @Test
    public void testGenerateRuntimeSql() {
        System.out.println(builder.generateRuntimeSql());
    }
}
