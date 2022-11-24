package com.mjc.stage2;

public class ThreadSafeSingleton {
    private static volatile ThreadSafeSingleton instance;
    private static Object mutex = new Object();
    private ThreadSafeSingleton() {

    }

    public static ThreadSafeSingleton getInstance() {
        ThreadSafeSingleton localRef = instance;
        if (localRef == null) {
            synchronized (mutex) {
                localRef = instance;
                if (localRef == null) {
                    localRef = instance = new ThreadSafeSingleton();
                }
            }
        }
        return localRef;
    }
}
