package com.tony.test.oom;


/**
 * VM args: -Xss2m
 */
public class MoreThreadOut {
    private void noStop() {
        while (true) {
        }
    }

    private void stackLeakByThead() {
        while (true) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    noStop();
                }
            });
            thread.start();
        }
    }
    public static void main(String[] args) {
        MoreThreadOut moreThreadOut = new MoreThreadOut();
        moreThreadOut.stackLeakByThead();
    }
/*
妈的，CPU飙到100%
 */
}