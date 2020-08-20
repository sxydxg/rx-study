package com.example.rxstudy.a;/**
 * @author dingxigui
 * @date 2020/8/21 0:49
 * @version 1.0
 */

import io.reactivex.Completable;
import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableOnSubscribe;
import io.reactivex.disposables.Disposable;

import java.util.Random;

/**
 @auther 丁溪贵
 @date 2020/8/21

 */
public class 完成的可观察的 {

    public static void main(String[] args) {

        // 只有完成， 关注是否完成
        // 而 Single 是否有那一个元素
        Completable completable = Completable.create(new CompletableOnSubscribe() {
            @Override
            public void subscribe(CompletableEmitter emitter) throws Exception {
                int temp = new Random().nextInt(10);
                if (temp % 2 == 1) {
                    emitter.onError(new Throwable("value 不是双数！"));
                } else {
                    emitter.onComplete();
                }
            }
        });

        completable.subscribe(new CompletableObserver() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println(d);
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError");
            }
        });
    }
}
