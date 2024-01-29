package com.tony.test.jvmexec;

/**
 * 演示局部变量表影响GC的例子
 */
public class LocalValueToGC {
    /**
     * VM参数：-verbose:gc
     */
    public static void main(String[] args) {
        {
            byte[] placeholder = new byte[64 * 1024 * 1024];
        }
        // 不添加下面这一行，导致局部变量表没有更新，局部变量表中还有字节苏租的引用，无法回收
        int a = 0;
        System.gc();
    }
}
