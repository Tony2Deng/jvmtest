package com.tony.test.oom;

/**
 * Vm args: -Xss128k
 */
public class StackDeepOut {
    private int stackDeep = 1;

    public void stackLeak() {
        stackDeep++;
        stackLeak();
    }

    public static void main(String[] args) {
        StackDeepOut stackOut = new StackDeepOut();
        try {
            stackOut.stackLeak();
        } catch (Throwable e) {
            System.out.println("deep:" + stackOut.stackDeep);
            throw e;
        }
    }

/*
    deep:18271
    Exception in thread "main" java.lang.StackOverflowError
    at com.tony.test.StackOut.stackLeak(StackDeepOut.java:10)
    at com.tony.test.StackOut.stackLeak(StackDeepOut.java:11)
    at com.tony.test.StackOut.stackLeak(StackDeepOut.java:11)
    at com.tony.test.StackOut.stackLeak(StackDeepOut.java:11)
    at com.tony.test.StackOut.stackLeak(StackDeepOut.java:11)
    at com.tony.test.StackOut.stackLeak(StackDeepOut.java:11)
    at com.tony.test.StackOut.stackLeak(StackDeepOut.java:11)
    at com.tony.test.StackOut.stackLeak(StackDeepOut.java:11)
    at com.tony.test.StackOut.stackLeak(StackDeepOut.java:11)
    at com.tony.test.StackOut.stackLeak(StackDeepOut.java:11)
    at com.tony.test.StackOut.stackLeak(StackDeepOut.java:11)
*/

}
