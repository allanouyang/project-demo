package com.ouyang.project.jooq;

import com.ouyang.project.jooq.cutom.NoInsertListener;
import org.jooq.Configuration;
import org.jooq.DSLContext;
import org.jooq.ExecuteContext;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DSL;
import org.jooq.impl.DefaultExecuteListener;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import static com.ouyang.project.jooq.domain.Tables.AUTHOR;

/**
 * Created by ouyang on 2018/1/17.
 */
public class JooqExecuteListener {

    @Autowired
    private Configuration configuration;

    private void setOneListenerConfig() {
        configuration.data("com.example.my-namespace.no-inserts", true);
        configuration.set(() -> new DefaultExecuteListener(){
            @Override
            public void start(ExecuteContext ctx) {
                System.out.println(" execute FirstExecuteLister ..............");
            }
        }, () -> new DefaultExecuteListener(){
            @Override
            public void start(ExecuteContext ctx) {
                System.out.println(" execute SecondExecuteLister ..............");
            }
        }, () -> new NoInsertListener());
    }

    public void addOneListener() {
        setOneListenerConfig();
        try {
            DSLContext create = DSL.using(configuration);
            create.insertInto(AUTHOR, AUTHOR.ID, AUTHOR.LAST_NAME)
                    .values(Long.valueOf(1), "Orwell")
                    .execute();
            create.close();
            Assert.fail();
        } catch (DataAccessException expected) {
            Assert.assertEquals("No INSERT statements allowed", expected.getMessage());
        }
    }


}
