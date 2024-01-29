package com.tony.test.classloader.init;

public class Constants {
    public static final String HELLO_WORLD = "hello world!";

    static {
        System.out.println("Constants Init");
    }
}
