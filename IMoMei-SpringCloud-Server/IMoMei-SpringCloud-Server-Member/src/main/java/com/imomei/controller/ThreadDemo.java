package com.imomei.controller;

public class ThreadDemo {

    public static final String USER_NAME_FIX = "getName+123";

    static ThreadLocal<Integer> ina = new ThreadLocal<Integer>();

    public static void main(String[] args) {
        new Object();
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        try {
            System.out.println(Class.forName("com.imomei.controller.ThreadDemo").getClassLoader());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void getName(String username) {
        String trueName = username + USER_NAME_FIX;
        String password = username + USER_NAME_FIX;
    }
}

class MyThread implements Runnable {
    @Override
    public void run() {
        Thread thisThread = Thread.currentThread();
        while (!thisThread.isInterrupted()) {            // 判断当前线程中断标志位
            try {
                thisThread.sleep(10);
            } catch (InterruptedException e) {
                System.out.println("我进到异常当中了，但是我不停止" + thisThread.isInterrupted());
                thisThread.interrupt();
                e.printStackTrace();
            }
            System.out.println(thisThread.getName() + "在运行呢！~");
        }
        System.out.println(thisThread.getName() + "被中断了。555");
    }
}