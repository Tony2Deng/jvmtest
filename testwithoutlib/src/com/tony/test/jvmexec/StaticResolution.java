package com.tony.test.jvmexec;

/**
 * 解析调用演示：方法调用在编译时可以确定调用的是那个方法版本，在类加载解析时替换为直接引用
 */
public class StaticResolution {
    private void sayBy() {
        System.out.println("by");
    }

    public static void sayHello() {
        System.out.println("hello!");
    }

    public static void main(String[] args) {
        StaticResolution.sayHello();
        new StaticResolution().sayBy();
    }
    /*
    $ javap -verbose out/production/testwithoutlib/com/tony/test/jvmexec/StaticResolution.class

    Classfile /F:/data/MyIdeaProjects/test/out/production/testwithoutlib/com/tony/test/jvmexec/StaticResolution.class
    Last modified 2024年1月24日; size 771 bytes
    MD5 checksum 3716016070e1a5a1cc7a07ec9aa4fa52
    Compiled from "StaticResolution.java"
    public class com.tony.test.jvmexec.StaticResolution
    minor version: 0
    major version: 55
    flags: (0x0021) ACC_PUBLIC, ACC_SUPER
    this_class: #7                          // com/tony/test/jvmexec/StaticResolution
    super_class: #10                        // java/lang/Object
    interfaces: 0, fields: 0, methods: 4, attributes: 1
    Constant pool:
            #1 = Methodref          #10.#26        // java/lang/Object."<init>":()V
            #2 = Fieldref           #27.#28        // java/lang/System.out:Ljava/io/PrintStream;
            #3 = String             #29            // by
            #4 = Methodref          #30.#31        // java/io/PrintStream.println:(Ljava/lang/String;)V
            #5 = String             #32            // hello!
            #6 = Methodref          #7.#33         // com/tony/test/jvmexec/StaticResolution.sayHello:()V
            #7 = Class              #34            // com/tony/test/jvmexec/StaticResolution
            #8 = Methodref          #7.#26         // com/tony/test/jvmexec/StaticResolution."<init>":()V
            #9 = Methodref          #7.#35         // com/tony/test/jvmexec/StaticResolution.sayBy:()V
            #10 = Class              #36            // java/lang/Object
            #11 = Utf8               <init>
  #12 = Utf8               ()V
  #13 = Utf8               Code
  #14 = Utf8               LineNumberTable
  #15 = Utf8               LocalVariableTable
  #16 = Utf8               this
            #17 = Utf8               Lcom/tony/test/jvmexec/StaticResolution;
  #18 = Utf8               sayBy
  #19 = Utf8               sayHello
  #20 = Utf8               main
  #21 = Utf8               ([Ljava/lang/String;)V
  #22 = Utf8               args
  #23 = Utf8               [Ljava/lang/String;
  #24 = Utf8               SourceFile
  #25 = Utf8               StaticResolution.java
  #26 = NameAndType        #11:#12        // "<init>":()V
            #27 = Class              #37            // java/lang/System
            #28 = NameAndType        #38:#39        // out:Ljava/io/PrintStream;
            #29 = Utf8               by
  #30 = Class              #40            // java/io/PrintStream
            #31 = NameAndType        #41:#42        // println:(Ljava/lang/String;)V
            #32 = Utf8               hello!
            #33 = NameAndType        #19:#12        // sayHello:()V
            #34 = Utf8               com/tony/test/jvmexec/StaticResolution
  #35 = NameAndType        #18:#12        // sayBy:()V
            #36 = Utf8               java/lang/Object
  #37 = Utf8               java/lang/System
  #38 = Utf8               out
  #39 = Utf8               Ljava/io/PrintStream;
  #40 = Utf8               java/io/PrintStream
  #41 = Utf8               println
  #42 = Utf8               (Ljava/lang/String;)V
    {
  public com.tony.test.jvmexec.StaticResolution();
        descriptor: ()V
        flags: (0x0001) ACC_PUBLIC
        Code:
        stack=1, locals=1, args_size=1
        0: aload_0
        1: invokespecial #1                  // Method java/lang/Object."<init>":()V
        4: return
            LineNumberTable:
        line 3: 0
        LocalVariableTable:
        Start  Length  Slot  Name   Signature
        0       5     0  this   Lcom/tony/test/jvmexec/StaticResolution;

        public static void sayHello();
        descriptor: ()V
        flags: (0x0009) ACC_PUBLIC, ACC_STATIC
        Code:
        stack=2, locals=0, args_size=0
        0: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
        3: ldc           #5                  // String hello!
        5: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
        8: return
            LineNumberTable:
        line 9: 0
        line 10: 8

        public static void main(java.lang.String[]);
        descriptor: ([Ljava/lang/String;)V
        flags: (0x0009) ACC_PUBLIC, ACC_STATIC
        Code:
        stack=2, locals=1, args_size=1
        0: invokestatic  #6                  // Method sayHello:()V
        3: new           #7                  // class com/tony/test/jvmexec/StaticResolution
        6: dup
        7: invokespecial #8                  // Method "<init>":()V
        10: invokevirtual #9                  // Method sayBy:()V
        13: return
            LineNumberTable:
        line 13: 0
        line 14: 3
        line 15: 13
        LocalVariableTable:
        Start  Length  Slot  Name   Signature
        0      14     0  args   [Ljava/lang/String;
    }
    SourceFile: "StaticResolution.java"
    */

}
