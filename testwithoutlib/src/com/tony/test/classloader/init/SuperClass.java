package com.tony.test.classloader.init;

public class SuperClass {
    public static int num = 123;

    static {
        System.out.println("SuperClass Init");
    }
}
