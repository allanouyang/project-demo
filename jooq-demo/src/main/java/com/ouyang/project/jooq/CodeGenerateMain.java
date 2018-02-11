package com.ouyang.project.jooq;

import org.jooq.util.GenerationTool;

/**
 * Created by ouyang on 2017/12/17.
 */
public class CodeGenerateMain {
    public static void main(String[] args) throws Exception {
        GenerationTool.main(new String[]{"code-generate.xml"});
    }
}
