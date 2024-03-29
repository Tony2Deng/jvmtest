package com.tony.test.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * VM args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 */
public class HeapOut {
    static class OOMObject {

    }
    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }
    }
/*
java.lang.OutOfMemoryError: Java heap space
    Dumping heap to java_pid21100.hprof ...
    Heap dump file created [28182420 bytes in 0.050 secs]
    Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
    at java.util.Arrays.copyOf(Arrays.java:3210)
    at java.util.Arrays.copyOf(Arrays.java:3181)
    at java.util.ArrayList.grow(ArrayList.java:267)
    at java.util.ArrayList.ensureExplicitCapacity(ArrayList.java:241)
    at java.util.ArrayList.ensureCapacityInternal(ArrayList.java:233)
    at java.util.ArrayList.add(ArrayList.java:464)
    at com.tony.test.oom.HeapOut.main(HeapOut.java:16)
*/
}