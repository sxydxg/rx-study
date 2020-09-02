package com.example.rxstudy.操作符;/**
 * @author dingxigui
 * @date 2020/8/21 0:58
 * @version 1.0
 */

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 @auther 丁溪贵
 @date 2020/8/21

 */
public class range {

    public static void main(String[] args) {
        //range 操作符，将产生n---n+m-1 的数字
        Observable<Integer> range = Observable.range(1, 10);
        range.subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {

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
