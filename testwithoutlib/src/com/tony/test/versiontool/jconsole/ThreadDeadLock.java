package com.tony.test.versiontool.jconsole;

public class ThreadDeadLock {
    static class SyncAddRunnable implements Runnable {
        int a, b;

        public SyncAddRunnable(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public void run() {
            synchronized (Integer.valueOf(a)) {
                synchronized (Integer.valueOf(b)) {
                    System.out.println(a + b);
                }
            }
        }
    }

    /**
     * Integer.valueOf在-128~127之间返回常亮池中同一对象，从而导致死锁
     * 100循环增加概率
     */
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(new SyncAddRunnable(1, 2), "1 + 2  " + i).start();
            new Thread(new SyncAddRunnable(2, 1), "2 + 1  " + i).start();
        }
    }
}
