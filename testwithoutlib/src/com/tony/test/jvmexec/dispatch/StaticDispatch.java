package com.tony.test.jvmexec.dispatch;

import java.util.Random;

/**
 * 静态分派演示
 */
public class StaticDispatch {
    static class Human {
    }

    static class Man extends Human {
    }

    static class Woman extends Human {
    }

    public void sayHello(Human human) {
        System.out.println("hi! human");
    }

    public void sayHello(Man man) {
        System.out.println("hi! man");
    }

    public void sayHello(Woman woman) {
        System.out.println("hi! woman");
    }

    public static void main(String[] args) {
        Human women = new Woman();
        Human man = new Man();
        StaticDispatch staticDispatch = new StaticDispatch();
        staticDispatch.sayHello(women);
        staticDispatch.sayHello(man);
        // 实际类型改变
        Human human = new Random().nextBoolean() ? new Man() : new Woman();
        // 静态类型改变
        staticDispatch.sayHello((Man) human);
        staticDispatch.sayHello((Woman) human);
    }
/*
    $ javap -verbose out/production/testwithoutlib/com/tony/test/jvmexec/dispatch/StaticDispatch.class

    Classfile /F:/data/MyIdeaProjects/test/out/production/testwithoutlib/com/tony/test/jvmexec/dispatch/StaticDispatch.class
    Last modified 2024年1月24日; size 1821 bytes
    MD5 checksum b01b3689a84a5d63c4b28ed57ef9ed1b
    Compiled from "StaticDispatch.java"
    public class com.tony.test.jvmexec.dispatch.StaticDispatch
    minor version: 0
    major version: 55
    flags: (0x0021) ACC_PUBLIC, ACC_SUPER
    this_class: #11                         // com/tony/test/jvmexec/dispatch/StaticDispatch
    super_class: #19                        // java/lang/Object
    interfaces: 0, fields: 0, methods: 5, attributes: 3
    Constant pool:
            #1 = Methodref          #19.#52        // java/lang/Object."<init>":()V
            #2 = Fieldref           #53.#54        // java/lang/System.out:Ljava/io/PrintStream;
            #3 = String             #55            // hi! human
            #4 = Methodref          #56.#57        // java/io/PrintStream.println:(Ljava/lang/String;)V
            #5 = String             #58            // hi! man
            #6 = String             #59            // hi! woman
            #7 = Class              #60            // com/tony/test/jvmexec/dispatch/StaticDispatch$Woman
            #8 = Methodref          #7.#52         // com/tony/test/jvmexec/dispatch/StaticDispatch$Woman."<init>":()V
            #9 = Class              #61            // com/tony/test/jvmexec/dispatch/StaticDispatch$Man
            #10 = Methodref          #9.#52         // com/tony/test/jvmexec/dispatch/StaticDispatch$Man."<init>":()V
            #11 = Class              #62            // com/tony/test/jvmexec/dispatch/StaticDispatch
            #12 = Methodref          #11.#52        // com/tony/test/jvmexec/dispatch/StaticDispatch."<init>":()V
            #13 = Methodref          #11.#63        // com/tony/test/jvmexec/dispatch/StaticDispatch.sayHello:(Lcom/tony/test/jvmexec/dispatch/StaticDispatch$Human;)V
            #14 = Class              #64            // java/util/Random
            #15 = Methodref          #14.#52        // java/util/Random."<init>":()V
            #16 = Methodref          #14.#65        // java/util/Random.nextBoolean:()Z
            #17 = Methodref          #11.#66        // com/tony/test/jvmexec/dispatch/StaticDispatch.sayHello:(Lcom/tony/test/jvmexec/dispatch/StaticDispatch$Man;)V
            #18 = Methodref          #11.#67        // com/tony/test/jvmexec/dispatch/StaticDispatch.sayHello:(Lcom/tony/test/jvmexec/dispatch/StaticDispatch$Woman;)V
            #19 = Class              #68            // java/lang/Object
            #20 = Utf8               Woman
  #21 = Utf8               InnerClasses
  #22 = Utf8               Man
  #23 = Class              #69            // com/tony/test/jvmexec/dispatch/StaticDispatch$Human
            #24 = Utf8               Human
  #25 = Utf8               <init>
  #26 = Utf8               ()V
  #27 = Utf8               Code
  #28 = Utf8               LineNumberTable
  #29 = Utf8               LocalVariableTable
  #30 = Utf8               this
            #31 = Utf8               Lcom/tony/test/jvmexec/dispatch/StaticDispatch;
  #32 = Utf8               sayHello
  #33 = Utf8               (Lcom/tony/test/jvmexec/dispatch/StaticDispatch$Human;)V
  #34 = Utf8               human
  #35 = Utf8               Lcom/tony/test/jvmexec/dispatch/StaticDispatch$Human;
  #36 = Utf8               (Lcom/tony/test/jvmexec/dispatch/StaticDispatch$Man;)V
  #37 = Utf8               man
  #38 = Utf8               Lcom/tony/test/jvmexec/dispatch/StaticDispatch$Man;
  #39 = Utf8               (Lcom/tony/test/jvmexec/dispatch/StaticDispatch$Woman;)V
  #40 = Utf8               woman
  #41 = Utf8               Lcom/tony/test/jvmexec/dispatch/StaticDispatch$Woman;
  #42 = Utf8               main
  #43 = Utf8               ([Ljava/lang/String;)V
  #44 = Utf8               args
  #45 = Utf8               [Ljava/lang/String;
  #46 = Utf8               women
  #47 = Utf8               staticDispatch
  #48 = Utf8               StackMapTable
  #49 = Utf8               SourceFile
  #50 = Utf8               StaticDispatch.java
  #51 = Utf8               NestMembers
  #52 = NameAndType        #25:#26        // "<init>":()V
            #53 = Class              #70            // java/lang/System
            #54 = NameAndType        #71:#72        // out:Ljava/io/PrintStream;
            #55 = Utf8               hi! human
  #56 = Class              #73            // java/io/PrintStream
            #57 = NameAndType        #74:#75        // println:(Ljava/lang/String;)V
            #58 = Utf8               hi! man
  #59 = Utf8               hi! woman
  #60 = Utf8               com/tony/test/jvmexec/dispatch/StaticDispatch$Woman
  #61 = Utf8               com/tony/test/jvmexec/dispatch/StaticDispatch$Man
  #62 = Utf8               com/tony/test/jvmexec/dispatch/StaticDispatch
  #63 = NameAndType        #32:#33        // sayHello:(Lcom/tony/test/jvmexec/dispatch/StaticDispatch$Human;)V
            #64 = Utf8               java/util/Random
  #65 = NameAndType        #76:#77        // nextBoolean:()Z
            #66 = NameAndType        #32:#36        // sayHello:(Lcom/tony/test/jvmexec/dispatch/StaticDispatch$Man;)V
            #67 = NameAndType        #32:#39        // sayHello:(Lcom/tony/test/jvmexec/dispatch/StaticDispatch$Woman;)V
            #68 = Utf8               java/lang/Object
  #69 = Utf8               com/tony/test/jvmexec/dispatch/StaticDispatch$Human
  #70 = Utf8               java/lang/System
  #71 = Utf8               out
  #72 = Utf8               Ljava/io/PrintStream;
  #73 = Utf8               java/io/PrintStream
  #74 = Utf8               println
  #75 = Utf8               (Ljava/lang/String;)V
  #76 = Utf8               nextBoolean
  #77 = Utf8               ()Z
    {
  public com.tony.test.jvmexec.dispatch.StaticDispatch();
        descriptor: ()V
        flags: (0x0001) ACC_PUBLIC
        Code:
        stack=1, locals=1, args_size=1
        0: aload_0
        1: invokespecial #1                  // Method java/lang/Object."<init>":()V
        4: return
            LineNumberTable:
        line 8: 0
        LocalVariableTable:
        Start  Length  Slot  Name   Signature
        0       5     0  this   Lcom/tony/test/jvmexec/dispatch/StaticDispatch;

        public void sayHello(com.tony.test.jvmexec.dispatch.StaticDispatch$Human);
        descriptor: (Lcom/tony/test/jvmexec/dispatch/StaticDispatch$Human;)V
        flags: (0x0001) ACC_PUBLIC
        Code:
        stack=2, locals=2, args_size=2
        0: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
        3: ldc           #3                  // String hi! human
        5: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
        8: return
            LineNumberTable:
        line 19: 0
        line 20: 8
        LocalVariableTable:
        Start  Length  Slot  Name   Signature
        0       9     0  this   Lcom/tony/test/jvmexec/dispatch/StaticDispatch;
        0       9     1 human   Lcom/tony/test/jvmexec/dispatch/StaticDispatch$Human;

        public void sayHello(com.tony.test.jvmexec.dispatch.StaticDispatch$Man);
        descriptor: (Lcom/tony/test/jvmexec/dispatch/StaticDispatch$Man;)V
        flags: (0x0001) ACC_PUBLIC
        Code:
        stack=2, locals=2, args_size=2
        0: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
        3: ldc           #5                  // String hi! man
        5: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
        8: return
            LineNumberTable:
        line 23: 0
        line 24: 8
        LocalVariableTable:
        Start  Length  Slot  Name   Signature
        0       9     0  this   Lcom/tony/test/jvmexec/dispatch/StaticDispatch;
        0       9     1   man   Lcom/tony/test/jvmexec/dispatch/StaticDispatch$Man;

        public void sayHello(com.tony.test.jvmexec.dispatch.StaticDispatch$Woman);
        descriptor: (Lcom/tony/test/jvmexec/dispatch/StaticDispatch$Woman;)V
        flags: (0x0001) ACC_PUBLIC
        Code:
        stack=2, locals=2, args_size=2
        0: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
        3: ldc           #6                  // String hi! woman
        5: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
        8: return
            LineNumberTable:
        line 27: 0
        line 28: 8
        LocalVariableTable:
        Start  Length  Slot  Name   Signature
        0       9     0  this   Lcom/tony/test/jvmexec/dispatch/StaticDispatch;
        0       9     1 woman   Lcom/tony/test/jvmexec/dispatch/StaticDispatch$Woman;

        public static void main(java.lang.String[]);
        descriptor: ([Ljava/lang/String;)V
        flags: (0x0009) ACC_PUBLIC, ACC_STATIC
        Code:
        stack=2, locals=5, args_size=1
        0: new           #7                  // class com/tony/test/jvmexec/dispatch/StaticDispatch$Woman
        3: dup
        4: invokespecial #8                  // Method com/tony/test/jvmexec/dispatch/StaticDispatch$Woman."<init>":()V
        7: astore_1
        8: new           #9                  // class com/tony/test/jvmexec/dispatch/StaticDispatch$Man
        11: dup
        12: invokespecial #10                 // Method com/tony/test/jvmexec/dispatch/StaticDispatch$Man."<init>":()V
        15: astore_2
        16: new           #11                 // class com/tony/test/jvmexec/dispatch/StaticDispatch
        19: dup
        20: invokespecial #12                 // Method "<init>":()V
        23: astore_3
        24: aload_3
        25: aload_1
        26: invokevirtual #13                 // Method sayHello:(Lcom/tony/test/jvmexec/dispatch/StaticDispatch$Human;)V
        29: aload_3
        30: aload_2
        31: invokevirtual #13                 // Method sayHello:(Lcom/tony/test/jvmexec/dispatch/StaticDispatch$Human;)V
        34: new           #14                 // class java/util/Random
        37: dup
        38: invokespecial #15                 // Method java/util/Random."<init>":()V
        41: invokevirtual #16                 // Method java/util/Random.nextBoolean:()Z
        44: ifeq          57
        47: new           #9                  // class com/tony/test/jvmexec/dispatch/StaticDispatch$Man
        50: dup
        51: invokespecial #10                 // Method com/tony/test/jvmexec/dispatch/StaticDispatch$Man."<init>":()V
        54: goto          64
        57: new           #7                  // class com/tony/test/jvmexec/dispatch/StaticDispatch$Woman
        60: dup
        61: invokespecial #8                  // Method com/tony/test/jvmexec/dispatch/StaticDispatch$Woman."<init>":()V
        64: astore        4
        66: aload_3
        67: aload         4
        69: checkcast     #9                  // class com/tony/test/jvmexec/dispatch/StaticDispatch$Man
        72: invokevirtual #17                 // Method sayHello:(Lcom/tony/test/jvmexec/dispatch/StaticDispatch$Man;)V
        75: aload_3
        76: aload         4
        78: checkcast     #7                  // class com/tony/test/jvmexec/dispatch/StaticDispatch$Woman
        81: invokevirtual #18                 // Method sayHello:(Lcom/tony/test/jvmexec/dispatch/StaticDispatch$Woman;)V
        84: return
            LineNumberTable:
        line 31: 0
        line 32: 8
        line 33: 16
        line 34: 24
        line 35: 29
        line 37: 34
        line 39: 66
        line 40: 75
        line 41: 84
        LocalVariableTable:
        Start  Length  Slot  Name   Signature
        0      85     0  args   [Ljava/lang/String;
        8      77     1 women   Lcom/tony/test/jvmexec/dispatch/StaticDispatch$Human;
        16      69     2   man   Lcom/tony/test/jvmexec/dispatch/StaticDispatch$Human;
        24      61     3 staticDispatch   Lcom/tony/test/jvmexec/dispatch/StaticDispatch;
        66      19     4 human   Lcom/tony/test/jvmexec/dispatch/StaticDispatch$Human;
        StackMapTable: number_of_entries = 2
        frame_type = 254 */
/* append *//*

        offset_delta = 57
        locals = [ class com/tony/test/jvmexec/dispatch/StaticDispatch$Human, class com/tony/test/jvmexec/dispatch/StaticDispatch$Human, class com/tony/test/jvmexec/dispatch/StaticDispatch ]
        frame_type = 70 */
/* same_locals_1_stack_item *//*

        stack = [ class com/tony/test/jvmexec/dispatch/StaticDispatch$Human ]
    }
    SourceFile: "StaticDispatch.java"
    NestMembers:
    com/tony/test/jvmexec/dispatch/StaticDispatch$Woman
    com/tony/test/jvmexec/dispatch/StaticDispatch$Man
    com/tony/test/jvmexec/dispatch/StaticDispatch$Human
    InnerClasses:
    static #20= #7 of #11;                  // Woman=class com/tony/test/jvmexec/dispatch/StaticDispatch$Woman of class com/tony/test/jvmexec/dispatch/StaticDispatch
    static #22= #9 of #11;                  // Man=class com/tony/test/jvmexec/dispatch/StaticDispatch$Man of class com/tony/test/jvmexec/dispatch/StaticDispatch
    static #24= #23 of #11;                 // Human=class com/tony/test/jvmexec/dispatch/StaticDispatch$Human of class com/tony/test/jvmexec/dispatch/StaticDispatch
*/
}
