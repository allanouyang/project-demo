package com.ouyang.project.rxjava;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by ouyang on 2017/11/30.
 */
public class SimpleDemo {

    public static Logger logger = LoggerFactory.getLogger(SimpleDemo.class);

    public static void simpleTest() {
        Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onComplete();
            }
        });

        //创建一个下游 Observer
        Observer<Integer> observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                logger.info("subscribe");
            }

            @Override
            public void onNext(Integer value) {
                logger.info("{}", value);
            }

            @Override
            public void onError(Throwable e) {
                logger.info("error");
            }

            @Override
            public void onComplete() {
                logger.info("complete");
            }
        };
        //建立连接
        observable.subscribe(observer);

    }

    public static void simpleTestDisposable() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
                logger.info("emit 1");
                e.onNext(1);
                logger.info("emit 2");
                e.onNext(2);
                logger.info("emit 3");
                e.onNext(3);
                logger.info("emit complete");
                e.onComplete();
                logger.info("emit 4");
            }
        }).subscribe(new Observer<Integer>() {
            private Disposable disposable;
            private int i;
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                logger.info("subscribe");
                this.disposable = d;
            }

            @Override
            public void onNext(@NonNull Integer integer) {
                
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    public static void main(String[] args) {
        simpleTest();
    }
}
