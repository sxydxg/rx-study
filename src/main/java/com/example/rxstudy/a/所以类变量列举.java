package com.example.rxstudy.a;/**
 * @author dingxigui
 * @date 2020/8/19 23:17
 * @version 1.0
 */

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import org.reactivestreams.Processor;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/**
 @auther 丁溪贵
 @date 2020/8/19
        https://baijiahao.baidu.com/s?id=1639044219412817957&wfr=spider&for=pc
 */
public class 所以类变量列举 {
    /**
     * 观察者模式（又被称为发布-订阅（Publish/Subscribe）模式，
     * 属于行为型模式的一种，它定义了一种一对多的依赖关系，
     * 让多个观察者对象同时监听某一个主题对象。这个主题对象在状态变化时，
     * 会通知所有的观察者对象，使他们能够自动更新自己。
     * @param args
     */
    public static void main(String[] args) {
        //Iterator 是对于迭代器来说是被动
        //Observer 对于Observer来说是主动，相应推，Observer主动将时间告诉给订阅者

        Publisher publisher = null ;
        Subscriber subscriber = null ;
        Subscription subscription = null ;
        Processor processor = null ;
        
        //观察者源需要传入一个观察者
        ObservableSource observableSource = null ;
        Observer observer = null ;
    }

}
