package com.ouyang.project.jooq.cutom;

import org.jooq.ExecuteContext;
import org.jooq.Insert;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DefaultExecuteListener;

/**
 * Created by ouyang on 2018/1/17.
 */
public class NoInsertListener extends DefaultExecuteListener {
    @Override
    public void start(ExecuteContext ctx) {
        System.out.println(" execute NoInsertListener ...................");
        if(Boolean.TRUE.equals(ctx.configuration().data("com.example.my-namespace.no-inserts"))){
            if(ctx.query() instanceof Insert) {
                throw new DataAccessException("No INSERT statements allowed");
            }
        }
    }
}
