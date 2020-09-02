package com.example.rxstudy.临时;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

/**
 * @author dingxigui
 * @version 1.0
 * @date 2020/9/2 21:12
 */
public class window {

    //window 操作符与 buffer 似， 但它在发 之前是把收 到的数据放进单独的 Observable
    //而不是放进 个数据结构。
    public static void main(String[] args) {

        Observable.range(1,10)
                .window(3)
                .subscribe(new Consumer<Observable<Integer>>() {
                    @Override
                    public void accept(Observable<Integer> integerObservable) throws Exception {
                        integerObservable.subscribe(
                                new Consumer<Integer>() {
                                    @Override
                                    public void accept(Integer integer) throws Exception {
                                        System.out.println(integerObservable+":"+integer);
                                    }
                                }
                        );
                    }
                });

    }
}