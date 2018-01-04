package com.common.utils;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @title : seckill-online
 * @description:
 * @author: 番茄很忙
 * @date: 2018/1/4 16:10
 * @version: 1.0
 */
public class AtomicLongDemo {

    private static long counter = 0;

    private static AtomicLong atomicLong = new AtomicLong(0);

    public static long addCount(){
        return ++counter;
    }

    public static long addOne(){
        return atomicLong.incrementAndGet();
    }



    public static void main(String[] args) {
        for(int i=0;i<100;i++){
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    Long count = AtomicLongDemo.addOne();
                    if(count==100){
                        System.out.println("count:"+count);
                    }
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            t.start();
        }
    }
}
