package com.tony.test.jvmexec.dispatch;

/**
 * 演示动态分派
 */
public class DynamicDispatch {
    static abstract class Human {
        abstract void sayHello();
    }

    static class Woman extends Human {
        @Override
        void sayHello() {
            System.out.println("hello woman");
        }
    }

    static class Man extends Human {
        @Override
        void sayHello() {
            System.out.println("hello man");
        }
    }

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        man.sayHello();
        woman.sayHello();
        man = new Woman();
        man.sayHello();
    }
/*
    $ javap -verbose out/production/testwithoutlib/com/tony/test/jvmexec/dispatch/DynamicDispatch.class

    Classfile /F:/data/MyIdeaProjects/test/out/production/testwithoutlib/com/tony/test/jvmexec/dispatch/DynamicDispatch.class
    Last modified 2024年1月24日; size 901 bytes
    MD5 checksum 0d73abdc858f3b5978d1190398087b77
    Compiled from "DynamicDispatch.java"
    public class com.tony.test.jvmexec.dispatch.DynamicDispatch
    minor version: 0
    major version: 55
    flags: (0x0021) ACC_PUBLIC, ACC_SUPER
    this_class: #7                          // com/tony/test/jvmexec/dispatch/DynamicDispatch
    super_class: #8                         // java/lang/Object
    interfaces: 0, fields: 0, methods: 2, attributes: 3
    Constant pool:
            #1 = Methodref          #8.#31         // java/lang/Object."<init>":()V
            #2 = Class              #32            // com/tony/test/jvmexec/dispatch/DynamicDispatch$Man
            #3 = Methodref          #2.#31         // com/tony/test/jvmexec/dispatch/DynamicDispatch$Man."<init>":()V
            #4 = Class              #33            // com/tony/test/jvmexec/dispatch/DynamicDispatch$Woman
            #5 = Methodref          #4.#31         // com/tony/test/jvmexec/dispatch/DynamicDispatch$Woman."<init>":()V
            #6 = Methodref          #12.#34        // com/tony/test/jvmexec/dispatch/DynamicDispatch$Human.sayHello:()V
            #7 = Class              #35            // com/tony/test/jvmexec/dispatch/DynamicDispatch
            #8 = Class              #36            // java/lang/Object
            #9 = Utf8               Man
  #10 = Utf8               InnerClasses
  #11 = Utf8               Woman
  #12 = Class              #37            // com/tony/test/jvmexec/dispatch/DynamicDispatch$Human
            #13 = Utf8               Human
  #14 = Utf8               <init>
  #15 = Utf8               ()V
  #16 = Utf8               Code
  #17 = Utf8               LineNumberTable
  #18 = Utf8               LocalVariableTable
  #19 = Utf8               this
            #20 = Utf8               Lcom/tony/test/jvmexec/dispatch/DynamicDispatch;
  #21 = Utf8               main
  #22 = Utf8               ([Ljava/lang/String;)V
  #23 = Utf8               args
  #24 = Utf8               [Ljava/lang/String;
  #25 = Utf8               man
  #26 = Utf8               Lcom/tony/test/jvmexec/dispatch/DynamicDispatch$Human;
  #27 = Utf8               woman
  #28 = Utf8               SourceFile
  #29 = Utf8               DynamicDispatch.java
  #30 = Utf8               NestMembers
  #31 = NameAndType        #14:#15        // "<init>":()V
            #32 = Utf8               com/tony/test/jvmexec/dispatch/DynamicDispatch$Man
  #33 = Utf8               com/tony/test/jvmexec/dispatch/DynamicDispatch$Woman
  #34 = NameAndType        #38:#15        // sayHello:()V
            #35 = Utf8               com/tony/test/jvmexec/dispatch/DynamicDispatch
  #36 = Utf8               java/lang/Object
  #37 = Utf8               com/tony/test/jvmexec/dispatch/DynamicDispatch$Human
  #38 = Utf8               sayHello
    {
  public com.tony.test.jvmexec.dispatch.DynamicDispatch();
        descriptor: ()V
        flags: (0x0001) ACC_PUBLIC
        Code:
        stack=1, locals=1, args_size=1
        0: aload_0
        1: invokespecial #1                  // Method java/lang/Object."<init>":()V
        4: return
            LineNumberTable:
        line 6: 0
        LocalVariableTable:
        Start  Length  Slot  Name   Signature
        0       5     0  this   Lcom/tony/test/jvmexec/dispatch/DynamicDispatch;

        public static void main(java.lang.String[]);
        descriptor: ([Ljava/lang/String;)V
        flags: (0x0009) ACC_PUBLIC, ACC_STATIC
        Code:
        stack=2, locals=3, args_size=1
        0: new           #2                  // class com/tony/test/jvmexec/dispatch/DynamicDispatch$Man
        3: dup
        4: invokespecial #3                  // Method com/tony/test/jvmexec/dispatch/DynamicDispatch$Man."<init>":()V
        7: astore_1
        8: new           #4                  // class com/tony/test/jvmexec/dispatch/DynamicDispatch$Woman
        11: dup
        12: invokespecial #5                  // Method com/tony/test/jvmexec/dispatch/DynamicDispatch$Woman."<init>":()V
        15: astore_2
        16: aload_1
        17: invokevirtual #6                  // Method com/tony/test/jvmexec/dispatch/DynamicDispatch$Human.sayHello:()V
        20: aload_2
        21: invokevirtual #6                  // Method com/tony/test/jvmexec/dispatch/DynamicDispatch$Human.sayHello:()V
        24: new           #4                  // class com/tony/test/jvmexec/dispatch/DynamicDispatch$Woman
        27: dup
        28: invokespecial #5                  // Method com/tony/test/jvmexec/dispatch/DynamicDispatch$Woman."<init>":()V
        31: astore_1
        32: aload_1
        33: invokevirtual #6                  // Method com/tony/test/jvmexec/dispatch/DynamicDispatch$Human.sayHello:()V
        36: return
            LineNumberTable:
        line 26: 0
        line 27: 8
        line 28: 16
        line 29: 20
        line 30: 24
        line 31: 32
        line 32: 36
        LocalVariableTable:
        Start  Length  Slot  Name   Signature
        0      37     0  args   [Ljava/lang/String;
        8      29     1   man   Lcom/tony/test/jvmexec/dispatch/DynamicDispatch$Human;
        16      21     2 woman   Lcom/tony/test/jvmexec/dispatch/DynamicDispatch$Human;
    }
    SourceFile: "DynamicDispatch.java"
    NestMembers:
    com/tony/test/jvmexec/dispatch/DynamicDispatch$Man
    com/tony/test/jvmexec/dispatch/DynamicDispatch$Woman
    com/tony/test/jvmexec/dispatch/DynamicDispatch$Human
    InnerClasses:
    static #9= #2 of #7;                    // Man=class com/tony/test/jvmexec/dispatch/DynamicDispatch$Man of class com/tony/test/jvmexec/dispatch/DynamicDispatch
    static #11= #4 of #7;                   // Woman=class com/tony/test/jvmexec/dispatch/DynamicDispatch$Woman of class com/tony/test/jvmexec/dispatch/DynamicDispatch
    static abstract #13= #12 of #7;         // Human=class com/tony/test/jvmexec/dispatch/DynamicDispatch$Human of class com/tony/test/jvmexec/dispatch/DynamicDispatch
*/
}
