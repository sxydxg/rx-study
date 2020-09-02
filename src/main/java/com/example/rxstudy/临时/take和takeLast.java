package com.example.rxstudy.临时;

import io.reactivex.Observable;

/**
 * @author dingxigui
 * @version 1.0
 * @date 2020/9/2 21:21
 */
public class take和takeLast {

    //使用 take 操作符可以只修改 Observable 的行为，返回前面的 项数据，发射完成通知，忽
    //略剩余的数据
    public static void main(String[] args) {

        Observable.just(1,2,3,4,5)
                .take(3)
                .subscribe(System.out::println);

        //如果对 Observable 使用 take 操作符，而那个 Observable 发射的数据少于项，那么
        //take 操作符生成的 Observable 就不会抛出异常或者发射 Error 通知，而是仍然会发射那些数据
        System.out.println("---------------");
        Observable.just(1,2,3,4,5)
                .take(6)
                .subscribe(System.out::println);

        System.out.println("---------------");
        //takeLast 和last相似 只不过从后面开始
        Observable.just(1,2,3,4,5)
                .takeLast(2)
                .subscribe(System.out::println);



    }
}