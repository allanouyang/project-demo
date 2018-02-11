package com.ouyang.project.concurrent.particle;

import java.applet.Applet;

/**
 * Created by ouyang on 2017/9/3.
 */
public class ParticleApplet extends Applet {

    protected Thread[] threads = null;
    protected final ParticleCanvas canvas = new ParticleCanvas(100);

    @Override
    public void init() {
        add(canvas);
    }

    public Thread makeThread(final Particle particle) {
        return new Thread(() -> {
            try {
                for (;;) {
                    particle.move();
                    canvas.repaint();
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public synchronized void start() {
        int n = 10;
        if(threads == null) {
            Particle[] particles = new Particle[n];
            for (int i = 0; i < n; i++) {
                particles[i] = new Particle(50, 50);
            }
            canvas.setParticles(particles);
            threads = new Thread[10];
            for (int i = 0; i < n; i++ ) {
                threads[i] = makeThread(particles[i]);
                System.out.println("thread"+i+".priority is "+threads[i].getPriority());
                threads[i].start();
            }
        }
    }

    @Override
    public synchronized void stop() {
        if(threads != null) {
            for (int i = 0; i < threads.length; i++ ) {
                threads[i].interrupt();
            }
            threads = null;
        }
    }
}
