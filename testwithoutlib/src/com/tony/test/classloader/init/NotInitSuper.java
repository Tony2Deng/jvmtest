package com.tony.test.classloader.init;

public class NotInitSuper {
    public static void main(String[] args) {
        /*
        只会初始化定义静态字段的父类
        System.out.println(SubClass.num);
        */

        /*
        通过数组定义引用类，不会触发初始化
        SuperClass[] sca = new SuperClass[10];
        */

        /*
        常量在编译阶段进入类的常量池中，本质上不是直接引用定义引用常量的类，不会触发初始化
        System.out.println(Constants.HELLO_WORLD);
        */
    }
}
