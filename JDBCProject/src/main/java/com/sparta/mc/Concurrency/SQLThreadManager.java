package com.sparta.mc.Concurrency;

public class SQLThreadManager {

    private static int threadCount = 0;

    public synchronized static void incrementThreadCount() {
        threadCount++;
    }

    public static int getThreadCount() {
        return threadCount;
    }

}
