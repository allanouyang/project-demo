package com.ouyang.project.proxy.p1;

/**
 * Created by ouyang on 2018/2/8.
 */
public class GamePlayerProxy implements IGamePlayer {

    private IGamePlayer player = null;

    public GamePlayerProxy(IGamePlayer player) {
        this.player = player;
    }

    public void login(String username, String password) {
        this.player.login(username, password);
    }

    public void killBoss() {
        this.player.killBoss();
    }

    public void upgrade() {
        this.player.upgrade();
    }
}
