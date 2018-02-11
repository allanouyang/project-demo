package com.ouyang.project.flume;

/**
 * Created by ouyang on 2018/2/2.
 */
public class MyApp {

    public static void main(String[] args) {
        MyRpcClientFacade facade = new MyRpcClientFacade();
        facade.init("localhost", 44444);

        String data = "Hello Flume!";
        for (int i = 0; i < 10; i++) {
            facade.sendDataToFlume(data);
        }
        facade.cleanUp();
    }
}
