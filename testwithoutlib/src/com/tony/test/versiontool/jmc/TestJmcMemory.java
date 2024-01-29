package com.tony.test.versiontool.jmc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TestJmcMemory {
    /**
     * 不断新增 BigDecimal 信息到 list
     */
    private static void allocate() {
        new Thread(()->{
            Thread.currentThread().setName("memory_allocate_thread");
            List<BigDecimal> list = new ArrayList<>();
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                list.add(new BigDecimal(i));
            }
        }).start();
    }

    public static void main(String[] args) {
        allocate();
    }
}
