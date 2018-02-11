package com.ouyang.project.proxy.p1;

/**
 * 游戏者
 * Created by ouyang on 2018/2/8.
 */
public interface IGamePlayer {
    //登录游戏
    public void login(String username, String password);
    //杀怪
    public void killBoss();
    //升级
    public void upgrade();
}
