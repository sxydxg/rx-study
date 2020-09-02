package com.example.rxstudy.临时;


import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

/**
 * @author dingxigui
 * @version 1.0
 * @date 2020/9/2 21:16
 */
public class first {

    //只发射第 项（或者满足某个条件的第一项）数据
    public static void main(String[] args) {

        Observable.just(1,2,3)
                //需要给一个默认值
                .first(100)
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        System.out.println(integer);
                    }
                });
    }

}