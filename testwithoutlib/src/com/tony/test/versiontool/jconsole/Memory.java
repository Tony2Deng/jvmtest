package com.tony.test.versiontool.jconsole;

import java.util.ArrayList;

/**
 * 测试j console监控内存
 */
public class Memory {
    /**
     * 内存占位符对象，64KB
     */
    static class OOMObject {
        public byte[] placeholder = new byte[64 * 1024];
    }

    public static void fillHeap(int num) throws InterruptedException {
        ArrayList<OOMObject> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Thread.sleep(100);
            list.add(new OOMObject());
        }
        System.gc();
    }

    /**
     * VM参数：-Xms100M -Xmx100M -XX:+UseSerialGC
     */
    public static void main(String[] args) throws InterruptedException {
        fillHeap(1000);
    }
}
