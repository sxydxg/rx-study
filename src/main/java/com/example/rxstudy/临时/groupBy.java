package com.example.rxstudy.临时;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.observables.GroupedObservable;

/**
 * @author dingxigui
 * @version 1.0
 * @date 2020/9/2 20:06
 */
public class groupBy {

    public static void main(String[] args) {

        Observable.range(1,10)
                .groupBy(new Function<Integer, Object>() {
                    @Override
                    public Object apply(Integer integer) throws Exception {
                        //返回key
                        return integer%2==0?"偶数组":"奇数组";
                    }
                })
                .subscribe(new Consumer<GroupedObservable<Object, Integer>>() {
                    @Override
                    public void accept(GroupedObservable<Object, Integer> objectIntegerGroupedObservable) throws Exception {
                        // 组key
                        Object key = objectIntegerGroupedObservable.getKey();
                        objectIntegerGroupedObservable.subscribe(new Consumer<Integer>() {
                            @Override
                            public void accept(Integer integer) throws Exception {
                                System.out.println(key+":"+integer);
                            }
                        });


                    }
                });


    }
}