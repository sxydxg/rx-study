package com.example.rxstudy.临时;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

import java.util.Arrays;
import java.util.List;

/**
 * @author dingxigui
 * @version 1.0
 * @date 2020/9/2 20:15
 */
public class buffer {

    //buffer 会定期收集 Observable 数据并放进 个数据包裹，然后发射这些数据包裹，而不是
    //一次发射一个值
    public static void main(String[] args) {
        Observable.range(1,10)
                .buffer(4)
                .subscribe(new Consumer<List<Integer>>() {
                    @Override
                    public void accept(List<Integer> integers) throws Exception {
                        System.out.println(Arrays.toString(integers.toArray()));
                    }
                });

        System.out.println("------华丽的分割线------------");
        Observable.range(1,10)
                .buffer(4,1)
                .subscribe(new Consumer<List<Integer>>() {
                    @Override
                    public void accept(List<Integer> integers) throws Exception {
                        System.out.println(Arrays.toString(integers.toArray()));
                    }
                });
        System.out.println("------华丽的分割线------------");
        Observable.range(1,10)
                .buffer(4,2)
                .subscribe(new Consumer<List<Integer>>() {
                    @Override
                    public void accept(List<Integer> integers) throws Exception {
                        System.out.println(Arrays.toString(integers.toArray()));
                    }
                });

    }
}