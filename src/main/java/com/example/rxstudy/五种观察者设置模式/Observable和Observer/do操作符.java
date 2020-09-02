package com.example.rxstudy.五种观察者设置模式.Observable和Observer;

import io.reactivex.Notification;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

/**
 * @ClassName do操作符
 * @Description          Observable   被观察者生命回调方法
 * @Author dingxigui
 * @Date 2020/9/1 17:27
 * @Version 1.0
 **/
public class do操作符 {

    public static void main(String[] args) {

        Observable.just("hello")
                .doOnNext(str-> System.out.println("doNonext "+str))
                .doAfterNext(str-> System.out.println("doAfterNext "+str))
                .doOnComplete(() -> System.out.println("doOnComplete"))
                // 订阅之后回调的方法
                .doOnSubscribe(str-> System.out.println("doOnSubscribe "+str))
                .doAfterTerminate(()->System.out.println("doAfterTerminate"))
                .doFinally(()->System.out.println("doFinally"))
                // Observable 每发射一个元素，就会调用一次，不仅包括onNext，还包括onError和onComplete
                .doOnEach(new Consumer<Notification<String>>() {
                    @Override
                    public void accept(Notification<String> stringNotification) throws Exception {
                        if (stringNotification.isOnNext()){
                            System.out.println("doOnEach-OnNext");
                        }else if (stringNotification.isOnComplete()){
                            System.out.println("doOnEach-OnComplete");
                        }else if (stringNotification.isOnError()){
                            System.out.println("doOnEach-OnError");
                        }

                    }
                })
                //订阅后可以取消订阅
                .doOnLifecycle(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        System.out.println("doOnLifecycle disposable.isDisposed()="+disposable.isDisposed());
                    }
                }, new Action() {
                    @Override
                    public void run() throws Exception {
                        System.out.println("doOnLifecycle is Run!");
                    }
                })
                .subscribe(ms-> System.out.println("cusumer 得到消息"+ms));





    }
}
