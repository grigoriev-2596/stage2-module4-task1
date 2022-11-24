package com.mjc.stage2;

public class ThreadSafeSingleton {
    private volatile ThreadSafeSingleton instance;

    private ThreadSafeSingleton() {

    }

    public ThreadSafeSingleton getInstance() {
        ThreadSafeSingleton localRef = instance;
        if (localRef == null) {
            synchronized (this) {
                localRef = instance;
                if (localRef == null) {
                    localRef = instance = new ThreadSafeSingleton();
                }
            }
        }
        return localRef;
    }
}
