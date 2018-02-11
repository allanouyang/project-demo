package com.ouyang.project.concurrent.particle;

import java.awt.*;

/**
 * Created by ouyang on 2017/8/17.
 */
public class ParticleCanvas extends Canvas {
    private Particle[] particles = new Particle[0];

    public ParticleCanvas(int size) {
        setSize(new Dimension(size, size));
    }

    protected synchronized void setParticles(Particle[] ps) {
        if(ps == null) {
            throw new IllegalArgumentException("cannot set null");
        }
        this.particles = ps;
    }

    protected synchronized Particle[] getParticles() {
        return this.particles;
    }

    public void paint(Graphics g) {
        Particle[] ps = getParticles();
        for(int i=0; i<ps.length; i++) {
            ps[i].draw(g);
        }
    }
}
