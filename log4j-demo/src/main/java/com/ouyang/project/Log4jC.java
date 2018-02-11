package com.ouyang.project;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by ouyang on 2017/4/12.
 */
public class Log4jC {
    private static final Logger logger = LogManager.getLogger(Log4jC.class.getName());

    public void testLog(){
        logger.trace("trace log ... ");
        logger.debug("debug log ... ");
        logger.info("info log ... ");
        logger.warn("warn log ... ");
        logger.error("error log ... ");
        logger.fatal("fatal log ... ");
    }
}
