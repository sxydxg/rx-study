package com.example.rxstudy.mytest;

/**
 * @author dingxigui
 * @version 1.0
 * @date 2020/8/22 21:58
 */
public class Test {

    public static void main(String[] args) {
        A a = new AReferener()::s;
        a.say("123");
    }
}