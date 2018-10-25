package com.example.threadpoolexecutordemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    private ThreadPoolExecutor threadPoolExecutor;

    private Task task;

    private String TAG = "Task";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        task = new Task();
        startExecute();
    }

    private void startExecute() {
        threadPoolExecutor = new ThreadPoolExecutor(3,6,3,TimeUnit.SECONDS,new LinkedBlockingDeque<Runnable>());
        threadPoolExecutor.execute(task);
        threadPoolExecutor.execute(task);
        threadPoolExecutor.execute(task);
        Log.d(TAG, "核心线程数: " + threadPoolExecutor.getCorePoolSize());
        Log.d(TAG, "线程池数: " + threadPoolExecutor.getPoolSize());
        Log.d(TAG, "任务队列数: " + threadPoolExecutor.getQueue().size());
        threadPoolExecutor.execute(task);
        threadPoolExecutor.execute(task);
        threadPoolExecutor.execute(task);
        Log.d(TAG, "核心线程数: " + threadPoolExecutor.getCorePoolSize());
        Log.d(TAG, "线程池数: " + threadPoolExecutor.getPoolSize());
        Log.d(TAG, "任务队列数: " + threadPoolExecutor.getQueue().size());
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "核心线程数: " + threadPoolExecutor.getCorePoolSize());
        Log.d(TAG, "线程池数: " + threadPoolExecutor.getPoolSize());
        Log.d(TAG, "任务队列数: " + threadPoolExecutor.getQueue().size());
    }
}
