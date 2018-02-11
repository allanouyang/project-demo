package com.ouyang.project.builder;

/**
 * 导演类
 * Created by ouyang on 2018/2/8.
 */
public class Direct {

    private Builder builder = new ConcreteProductBuilder();

    public Product getAProduct() {
        builder.setPart();
        return builder.buildProduct();
    }
}
