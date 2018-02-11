package com.ouyang.project.jooq;

import org.jooq.DSLContext;

/**
 * Created by ouyang on 2018/1/17.
 */
public interface JooqExecutorCallback {

    void execute(DSLContext ctx);

}
