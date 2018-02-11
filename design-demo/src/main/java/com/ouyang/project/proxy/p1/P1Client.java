package com.ouyang.project.proxy.p1;

import java.time.LocalDateTime;

/**
 * Created by ouyang on 2018/2/8.
 */
public class P1Client {

    public static void noProxy() {
        IGamePlayer player = new GamePlayer("张三");
        System.out.println("开始时间是: "+ LocalDateTime.now());
        player.login("zhangShan", "123456");
        player.killBoss();
        player.upgrade();
        System.out.println("结束时间是: "+ LocalDateTime.now());
    }

    public static void proxy() {
        IGamePlayer proxy = new GamePlayerProxy(new GamePlayer("张三"));
        System.out.println("开始时间是: "+ LocalDateTime.now());
        proxy.login("zhangShan", "123456");
        proxy.killBoss();
        proxy.upgrade();
        System.out.println("结束时间是: "+ LocalDateTime.now());
    }

    public static void main(String[] args) {
//        noProxy();
        proxy();
    }

}
