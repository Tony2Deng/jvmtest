package com.tony.test.classloader.cinit;

public class ExeSort {
    static class Parent {
        static int A = 1;
        static {
            A = 2;
        }
    }

    /**
     * 父类中定义的静态语句优于子类执行
     */
    static class Sub extends Parent {
        static int B = A;
    }

    public static void main(String[] args) {
        System.out.println(Sub.B);
    }
}
