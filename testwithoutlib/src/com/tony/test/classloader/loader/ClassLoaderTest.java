package com.tony.test.classloader.loader;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

/**
 * 类加载器移instanceof关键字演示
 */
public class ClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        ClassLoader classLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String filename = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream inputStream = getClass().getResourceAsStream(filename);
                    if (Objects.isNull(inputStream)) {
                        return super.loadClass(name);
                    }
                    byte[] b = new byte[inputStream.available()];
                    int read = inputStream.read(b);
                    if (read == 0) {
                        return super.loadClass(name);
                    }
                    return defineClass(name, b, 0 ,b.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException(name);
                }
            }
        };

        Object aClass = classLoader.loadClass("com.tony.test.classloader.loader.ClassLoaderTest").newInstance();
        System.out.println(aClass.getClass());
        // 可以看到是从同一个文件加载的类，但是JVM却不认为是同一个类
        System.out.println(aClass instanceof com.tony.test.classloader.loader.ClassLoaderTest);
    }
}
