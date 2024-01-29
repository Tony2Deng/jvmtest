package com.tony.test.classtest;

public class TestClass {
    private int m;

    public TestClass(int m) {
        this.m = m;
    }

    public int inc() {
        return m + 1;
    }
}

/* class文件16进制表示
00000000   CA FE BA BE 00 00 00 37  00 16 0A 00 04 00 12 09  00 03 00 13 07 00 14 07  00 15 01 00 01 6D 01 00   漱壕   7                     m
00000020   01 49 01 00 06 3C 69 6E  69 74 3E 01 00 03 28 29  56 01 00 04 43 6F 64 65  01 00 0F 4C 69 6E 65 4E    I   <init>   ()V   Code   LineN
00000040   75 6D 62 65 72 54 61 62  6C 65 01 00 12 4C 6F 63  61 6C 56 61 72 69 61 62  6C 65 54 61 62 6C 65 01   umberTable   LocalVariableTable
00000060   00 04 74 68 69 73 01 00  23 4C 63 6F 6D 2F 74 6F  6E 79 2F 74 65 73 74 2F  63 6C 61 73 73 74 65 73     this  #Lcom/tony/test/classtes
00000080   74 2F 54 65 73 74 43 6C  61 73 73 3B 01 00 03 69  6E 63 01 00 03 28 29 49  01 00 0A 53 6F 75 72 63   t/TestClass;   inc   ()I   Sourc
000000A0   65 46 69 6C 65 01 00 0E  54 65 73 74 43 6C 61 73  73 2E 6A 61 76 61 0C 00  07 00 08 0C 00 05 00 06   eFile   TestClass.java
000000C0   01 00 21 63 6F 6D 2F 74  6F 6E 79 2F 74 65 73 74  2F 63 6C 61 73 73 74 65  73 74 2F 54 65 73 74 43     !com/tony/test/classtest/TestC
000000E0   6C 61 73 73 01 00 10 6A  61 76 61 2F 6C 61 6E 67  2F 4F 62 6A 65 63 74 00  21 00 03 00 04 00 00 00   lass   java/lang/Object !
00000100   01 00 02 00 05 00 06 00  00 00 02 00 01 00 07 00  08 00 01 00 09 00 00 00  2F 00 01 00 01 00 00 00                           /
00000120   05 2A B7 00 01 B1 00 00  00 02 00 0A 00 00 00 06  00 01 00 00 00 03 00 0B  00 00 00 0C 00 01 00 00    *? ?
00000140   00 05 00 0C 00 0D 00 00  00 01 00 0E 00 0F 00 01  00 09 00 00 00 31 00 02  00 01 00 00 00 07 2A B4                        1        *?
00000160   00 02 04 60 AC 00 00 00  02 00 0A 00 00 00 06 00  01 00 00 00 07 00 0B 00  00 00 0C 00 01 00 00 00      `?
00000180   07 00 0C 00 0D 00 00 00  01 00 10 00 00 00 02 00  11
 */

/* class 信息,使用 javap -verbose filename输出
  Last modified 2024年1月18日; size 401 bytes
  MD5 checksum d47186920d8cbfaea8feaad41be2308d
  Compiled from "TestClass.java"
public class com.tony.test.classtest.TestClass
  minor version: 0
  major version: 55
  flags: (0x0021) ACC_PUBLIC, ACC_SUPER
  this_class: #3                          // com/tony/test/classtest/TestClass
  super_class: #4                         // java/lang/Object
  interfaces: 0, fields: 1, methods: 2, attributes: 1
Constant pool:
   #1 = Methodref          #4.#18         // java/lang/Object."<init>":()V
   #2 = Fieldref           #3.#19         // com/tony/test/classtest/TestClass.m:I
   #3 = Class              #20            // com/tony/test/classtest/TestClass
   #4 = Class              #21            // java/lang/Object
   #5 = Utf8               m
   #6 = Utf8               I
   #7 = Utf8               <init>
   #8 = Utf8               ()V
   #9 = Utf8               Code
  #10 = Utf8               LineNumberTable
  #11 = Utf8               LocalVariableTable
  #12 = Utf8               this
  #13 = Utf8               Lcom/tony/test/classtest/TestClass;
  #14 = Utf8               inc
  #15 = Utf8               ()I
  #16 = Utf8               SourceFile
  #17 = Utf8               TestClass.java
  #18 = NameAndType        #7:#8          // "<init>":()V
  #19 = NameAndType        #5:#6          // m:I
  #20 = Utf8               com/tony/test/classtest/TestClass
  #21 = Utf8               java/lang/Object
{
  public com.tony.test.classtest.TestClass();
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
            0       5     0  this   Lcom/tony/test/classtest/TestClass;

  public int inc();
    descriptor: ()I
    flags: (0x0001) ACC_PUBLIC
    Code:
      stack=2, locals=1, args_size=1
         0: aload_0
         1: getfield      #2                  // Field m:I
         4: iconst_1
         5: iadd
         6: ireturn
      LineNumberTable:
        line 7: 0
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0       7     0  this   Lcom/tony/test/classtest/TestClass;
}
SourceFile: "TestClass.java"
 */
