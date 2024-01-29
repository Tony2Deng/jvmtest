package com.tony.test.objectdistribute;

/**
 * HandlePromotionFailure JDK6以后失效
 * 测试空间分配担保，进行Monitor GC之前需要检查老年代的最大连续空间是否大于新生代所有对象总空间，以确保安全
 * 小于则看是否大于历次晋升到老年代对象的平均大小，大于则尝试有风险的Monitor GC，否则Full GC
 * Monitor GC失败，则进行Full GC
 */
public class HandlePromotionFailure {
    private static final int _1MB = 1024 * 1024;

    /**
     * VM参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     */
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        byte[] allocation1, allocation2, allocation3, allocation4, allocation5, allocation6, allocation7;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation1 = null;
        allocation4 = new byte[2 * _1MB];
        allocation5 = new byte[2 * _1MB];
        allocation6 = new byte[2 * _1MB];
        allocation4 = null;
        allocation5 = null;
        allocation6 = null;
        allocation7 = new byte[2 * _1MB];
    }
}
