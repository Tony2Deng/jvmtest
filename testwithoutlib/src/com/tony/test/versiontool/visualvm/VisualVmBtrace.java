package com.tony.test.versiontool.visualvm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * visualVm 调试Btrace
 */
public class VisualVmBtrace {
    public int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) throws IOException {
        VisualVmBtrace visualVmBtrace = new VisualVmBtrace();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            bufferedReader.readLine();
            int a = (int) Math.round(Math.random() * 1000);
            int b = (int) Math.round(Math.random() * 1000);
            System.out.println(visualVmBtrace.add(a, b));
        }
    }



/*  BTrace 增强脚本
@BTrace
public class TracingScript {
    @OnMethod(clazz = "com.tony.test.versiontool.visualvm.VisualVmBtrace",
            method="add",
            location=@Location(Kind.RETURN))
    public static void func(@self com.tony.test.versiontool.visualvm.VisualVmBtrace instance, int a, int b, @Return int result) {
        println("调用方法：");
        jstack();
        println("方法参数a:", str(a));
        println("方法参数b:", str(b));
        println("方法resuilt:", str(result));
    }
}
*/
}
