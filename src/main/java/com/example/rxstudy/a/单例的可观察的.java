package com.example.rxstudy.a;/**
 * @author dingxigui
 * @date 2020/8/21 0:39
 * @version 1.0
 */

import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleObserver;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.disposables.Disposable;

import java.util.Random;

/**
 @auther 丁溪贵
 @date 2020/8/21

 */
public class 单例的可观察的 {

    public static void main(String[] args) {

        //只有一个对象
        // 会发现没有 onNext方法和onComplete，只有onError和onSuccess
        //因为你只发送一个，同时你能发送了一个也就说明了你已经完成了
        //Single关注是否有一个元素，而不关心是否完成
        Single<Integer> single = Single.create(new SingleOnSubscribe<Integer>() {
            @Override
            public void subscribe(SingleEmitter<Integer> emitter) throws Exception {
                int temp = new Random().nextInt(10);
                if (temp%2==1){
                    emitter.onError(new Throwable("value 不是双数！"));
                }else{
                    emitter.onSuccess(100);
                }

            }
        });

        single.subscribe(new SingleObserver<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                //? 这个d是谁?
                if (!d.isDisposed()){
                    System.out.println(d);
                }
            }

            @Override
            public void onSuccess(Integer integer) {
                System.out.println(integer);
            }

            @Override
            public void onError(Throwable e) {
                System.out.println(e);
            }
        });


    }
}
