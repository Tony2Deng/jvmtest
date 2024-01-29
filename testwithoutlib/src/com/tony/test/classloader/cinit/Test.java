package com.tony.test.classloader.cinit;

public class Test {
    static {
        i = 1;
        /*
        编译报错非法前向引用
        System.out.println(i);
        */
    }

    static int i = 0;
}
