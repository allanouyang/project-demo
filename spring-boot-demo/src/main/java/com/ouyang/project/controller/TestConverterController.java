package com.ouyang.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by ouyang on 2017/10/19.
 */
@Controller
public class TestConverterController {

    @Autowired
    private ConversionService conversionService;

    @RequestMapping("test-converter")
    @ResponseBody
    public String testConverter(@RequestParam("str") String str){
        System.out.println(conversionService);
        return str;
    }
}
