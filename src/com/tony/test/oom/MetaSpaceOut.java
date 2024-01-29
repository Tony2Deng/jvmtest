package com.tony.test.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * VM args: -Xms6m -Xmx6m -XX:+HeapDumpOnOutOfMemoryError
 */
public class MetaSpaceOut {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }
/*
java.lang.OutOfMemoryError: Java heap space
Dumping heap to java_pid81584.hprof ...
Heap dump file created [6607698 bytes in 0.015 secs]
Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
	at java.util.Arrays.copyOf(Arrays.java:3210)
	at java.util.Arrays.copyOf(Arrays.java:3181)
	at java.util.ArrayList.grow(ArrayList.java:267)
	at java.util.ArrayList.ensureExplicitCapacity(ArrayList.java:241)

*/
}