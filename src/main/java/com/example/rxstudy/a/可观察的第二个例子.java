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
public class 可观察的第二个例子 {

    public static void main(String[] args) {

        //创建可观察者
        //ObservableOnSubscribe  在订阅时可观察的----> 我的理解它这时是一个生产者
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {

            }
        });


    }
}
