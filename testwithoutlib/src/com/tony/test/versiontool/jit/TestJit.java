package com.tony.test.versiontool.jit;

/**
 * 测试jit动态打印编译
 */
public class TestJit {
    int a = 1;
    static int b = 2;

    public int sum (int c) {
        return a + b + c;
    }

    /**
     * VM参数：-XX:+UnlockDiagnosticVMOptions -XX:+PrintAssembly -Xcomp -XX:CompileCommand=dontinline,*TestJit.sum -XX:CompileCommand=compileonly,*TestJit.sum
     */
    public static void main(String[] args) {
        new TestJit().sum(3);
    }
}
