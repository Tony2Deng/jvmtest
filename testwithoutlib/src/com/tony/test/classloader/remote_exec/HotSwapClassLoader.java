package com.tony.test.classloader.remote_exec;

/**
 * 为了能多次载入执行类而创建的加载器
 * 把defineClass公开，只有外部显式调用时才使用loadByte方法
 * 虚拟机调用时仍按照双亲委派机制加载
 */
public class HotSwapClassLoader extends ClassLoader{
    public HotSwapClassLoader() {
        super(HotSwapClassLoader.class.getClassLoader());
    }

    public Class loadByte(byte[] classByte) {
        return defineClass(null, classByte, 0 , classByte.length);
    }
}
