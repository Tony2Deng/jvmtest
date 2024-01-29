package com.tony.test.objectdistribute;

/**
 * 测试大对象直接进入老年代
 */
public class BigObjectToOld {
    private static final int _1MB = 1024 * 1024;

    /**
     * VM参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3145728
     */
    public static void main(String[] args) {
        byte[] allocation;
        // -XX:PretenureSizeThreshold=3145728 失效
        allocation = new byte[7 * _1MB];
    }
}
