package com.tony.test.classloader.init;

public class SubClass extends SuperClass {
    static {
        System.out.println("SubClass init");
    }
}