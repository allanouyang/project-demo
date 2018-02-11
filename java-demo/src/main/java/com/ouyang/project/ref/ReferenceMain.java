package com.ouyang.project.ref;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * Created by ouyang on 2017/12/6.
 */
public class ReferenceMain {

    public static void main(String[] args) {
        String weakObj, phantomObj;
        Reference<Object> ref;
        WeakReference<Object> weakRef;
        PhantomReference<Object> phantomRef;
        ReferenceQueue<Object> weakQueue, phantomQueue;

        weakObj = new String("Weak Reference");
        phantomObj = new String("Phantom Reference");
        weakQueue = new ReferenceQueue<>();
        phantomQueue = new ReferenceQueue<>();
        weakRef = new WeakReference<>(weakObj, weakQueue);
        phantomRef = new PhantomReference<>(phantomObj, phantomQueue);

        System.out.println("Weak Reference: " + weakRef.get());
        System.out.println("Phantom Reference: " + phantomRef.get());

        weakObj = null; phantomObj = null;
        System.gc();
        System.out.println("Weak Queued: " + weakRef.isEnqueued());
        if(!phantomRef.isEnqueued()) {
            System.out.println("Requestion finalization.");
            System.runFinalization();
        }
        System.out.println("Phantom Queued: " + phantomRef.isEnqueued());

        try {
            ref = (Reference<Object>) weakQueue.remove();
            System.out.println("Weak Reference: " + ref.get());
            ref = (Reference<Object>) phantomQueue.remove();
            System.out.println("Phantom Reference: " + ref.get());
            ref.clear();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end.....");

    }
}
