package com.common.utils;

import java.text.SimpleDateFormat;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @title : seckill-online
 * @description:
 * @author: 番茄很忙
 * @date: 2018/1/4 14:45
 * @version: 1.0
 */
public class CountLast60s {

    private AtomicLong count = new AtomicLong(0); // 总计数

    //private int lastSeconds = 60; // 需要统计的时间段

    private int precision = 60; // 精度，具体控制的方法应该更复杂

    private LinkedBlockingQueue<Long> queue = new LinkedBlockingQueue<Long>(precision);// 精度越大，队列的长度也越大

    private volatile boolean stopped = false;


    private long getCountBeforeOneMinutes() {
        //LinkedBlockingQueue 用起来方便,同时，也会有约束
        //这边与下面的poll会出现同步问题，
        //解决办法，可以用自己的Queue，加相关的锁，
        if(queue.size()==precision){
            return queue.peek();
        }
        return 0;
    }


    /**
     * 打印当前近60秒的点击数
     */
    public void printCountInLast60s(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("printer works");
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS");
                while (!stopped) {
                    long c = count.get();
                    long countInLast60s = c - getCountBeforeOneMinutes();
                    System.out.println("["
                            + sdf.format(System.currentTimeMillis()) + "] -- "
                            + countInLast60s
                            + "/" + c);
                    try {
                        Thread.sleep((long) (1000 * Math.random()));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }


    /**
     * 每隔1秒，采集一次
     */
    public void gatherVeryMinutes() {

        new Thread(new Runnable() {

            @Override
            public void run() {
                while (!stopped) {
                    if(queue.size()==precision){
                        queue.poll();
                    }
                    queue.offer(count.get());
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }


    /**
     * 模拟网站点击计数
     */
    public void emulateWebCount(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (!stopped) {
                    count.addAndGet((long) (100 * Math.random()));
                    try {
                        Thread.sleep((long) (1000 * Math.random()));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        CountLast60s reporter = new CountLast60s();
        reporter.gatherVeryMinutes();
        reporter.emulateWebCount();
        reporter.printCountInLast60s();

        try {
            TimeUnit.MINUTES.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        reporter.stopped = true;
    }
}
