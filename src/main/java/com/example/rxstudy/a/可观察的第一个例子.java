package com.example.rxstudy.a;/**
 * @author dingxigui
 * @date 2020/8/21 0:15
 * @version 1.0
 */

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

import java.util.Random;

/**
 @auther 丁溪贵
 @date 2020/8/21

 */
public class 可观察的第一个例子 {

    public static void main(String[] args) {

        //创建可观察者
        Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                //首先没有关闭，
                // 大于7抛出错误，
                if (!emitter.isDisposed()){
                    for (int i=0;i<5;i++){
                        int temp = new Random().nextInt(10);
                        if (temp>7){
                            emitter.onError(new Throwable("value > 7"));
                            break;
                        }else {
                            emitter.onNext(i);
                        }
                        if (i==4){
                            emitter.onComplete();
                        }

                    }
                }

            }
        });

        //订阅传了一个消费者
        observable.subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                System.out.println(integer);
            }
        });
        System.out.println("----------");
        //订阅传了一个观察者
        observable.subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("onSubscribe");
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println(integer);
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError");
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        });

    }
}
