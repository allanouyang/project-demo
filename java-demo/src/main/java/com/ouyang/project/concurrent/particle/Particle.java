package com.ouyang.project.concurrent.particle;

import java.awt.*;
import java.util.Random;

/**
 * Created by ouyang on 2017/8/17.
 */
public class Particle {
    protected int x;
    protected int y;
    protected final Random rng = new Random();  //引用不会被改变,不受加锁规则影响

    public Particle(int initialX, int initialY) {
        this.x = initialX;
        this.y = initialY;
    }

    public synchronized void move() {
        x += rng.nextInt(10) - 5;
        y += rng.nextInt(20) - 10;
    }

    public void draw (Graphics g) {
        int lx, ly;
        synchronized (this) {
            lx = x;
            ly = y;
        }
        g.drawRect(lx, ly, 10, 10);
    }
}
