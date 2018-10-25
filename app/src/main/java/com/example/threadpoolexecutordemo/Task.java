package com.example.threadpoolexecutordemo;

import android.util.Log;

public class Task implements Runnable {

    private String TAG = "TASK";

    @Override
    public void run() {
        try {
            Log.d(TAG, Thread.currentThread().getName() + "开始工作");
            Thread.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
