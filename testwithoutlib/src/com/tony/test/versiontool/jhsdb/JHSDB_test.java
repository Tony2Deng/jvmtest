package com.tony.test.versiontool.jhsdb;

/**
 * staticObject，instanceObject，localObject存放位置
 */
public class JHSDB_test {

    static class Test {
        static ObjectHolder staticObj = new ObjectHolder();

        ObjectHolder instanceObj = new ObjectHolder();

        void foo() {
            ObjectHolder localObj = new ObjectHolder();
            System.out.println("done"); // 此处设置一个断点
        }
    }

    private static class ObjectHolder {
    }

    /**
     * VM参数：-Xmx10m -XX:+UseSerialGC -XX:-UseCompressedOops
     */
    public static void main(String[] args) {
        Test test = new Test();
        test.foo();
    }
}
