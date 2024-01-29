package com.tony.test.classloader.resolution;

public class TestFieldResolution {
    interface Interface0 {
        int A = 0;
    }

    interface Interface1 extends Interface0{
        int A = 1;
    }

    interface Interface2 {
        int A = 2;
    }

    static class Parent implements Interface1 {
        public static int A = 3;
    }

    static class Sub extends Parent implements Interface2 {
        // 如果将下行删除，父类与接口同时存在字段A，会编译失败：对A的引用不明确
        public static int A = 4;
    }

    public static void main(String[] args) {
        System.out.println(Sub.A);
    }
}
