package com.tony.test.classloader.remote_exec;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class JavaClassExec {
    public static String execute(byte[] classBytes) {
       HackSystem.clearBuffer();
        ClassModifier classModifier = new ClassModifier(classBytes);
        byte[] modifyBytes = classModifier.modifyUtf8Constant("java/lang/System", "com/tony/test/classloader/remote_exec/HackSystem");
        HotSwapClassLoader hotSwapClassLoader = new HotSwapClassLoader();
        Class aClass = hotSwapClassLoader.loadByte(modifyBytes);
        try {
            Method main = aClass.getMethod("main", String[].class);
            main.invoke(null, new String[]{null});
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace(HackSystem.out);
        }
        return HackSystem.getBufferString();
    }

    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("");
        String execute = execute(fileInputStream.readAllBytes());
        System.out.println(execute);
    }
}
