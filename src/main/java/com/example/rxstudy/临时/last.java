package com.example.rxstudy.临时;

import io.reactivex.Observable;

/**
 * @author dingxigui
 * @version 1.0
 * @date 2020/9/2 21:20
 */
public class last {

    //last 操作符跟first 操作符类似，需要一个默认的 Item ，也是返回 Single 类型

    public static void main(String[] args) {
        Observable.just(1,2,3)
                .last(100)
                .subscribe(System.out::println);
    }


}