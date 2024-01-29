package com.tony.test.oom;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * VM args: -Xmx=20M -XX:MaxDirectMemorySize=10M
 */
public class DirectMemoryOut {
    private static final int _1MB = 1024*1024;

    public static void main(String[] args) throws IllegalAccessException {
        Field declaredField = Unsafe.class.getDeclaredFields()[0];
        declaredField.setAccessible(true);
        Unsafe unsafe = (Unsafe) declaredField.get(null);
        while (true) {
            unsafe.allocateMemory(_1MB);
        }
    }
}
