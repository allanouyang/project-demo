package com.ouyang.project.proxy.p1;

/**
 * Created by ouyang on 2018/2/8.
 */
public class GamePlayer implements IGamePlayer {

    private String name = "";

    public GamePlayer(String name) {
        this.name = name;
    }

    public void login(String username, String password) {
        System.out.println("登录名为" + username + "的用户" + this.name + "登录成功!");
    }

    public void killBoss() {
        System.out.println(this.name + "在打怪!");
    }

    public void upgrade() {
        System.out.println(this.name + "又升了一级!");
    }
}
