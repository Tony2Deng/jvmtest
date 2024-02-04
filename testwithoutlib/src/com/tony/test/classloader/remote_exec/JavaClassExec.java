package com.tony.test.classloader.remote_exec;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class JavaClassExec {
    public static String execute(byte[] classBytes) {
       HackSystem.clearBuffer();
        ClassModifier classModifier = new ClassModifier(classBytes);
        String name = HackSystem.class.getName().replace(".", "/");
        byte[] modifyBytes = classModifier.modifyUtf8Constant("java/lang/System", name);
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

    /*
      用于本地测试
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("out/production/testwithoutlib/com/tony/test/classloader/remote_exec/TestRemoteExec.class");
        String execute = execute(fileInputStream.readAllBytes());
        System.out.println(execute);
    }
    */
}
