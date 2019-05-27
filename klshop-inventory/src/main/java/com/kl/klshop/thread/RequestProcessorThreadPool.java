package com.kl.klshop.thread;

import com.kl.klshop.request.Request;
import com.kl.klshop.request.RequestQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Auther: dalele
 * @Date: 2019/4/20 21:43
 * @Description: 线程池单例
 */
public class RequestProcessorThreadPool {

    // 在实际项目中，你设置线程池大小是多少，每个线程监控的那个内存队列的大小是多少
    // 都可以做到一个外部的配置文件中
    // 我们这了就给简化了，直接写死了，好吧

    /**
     * 线程池
     */
    private ExecutorService threadPool = Executors.newFixedThreadPool(10);

    public RequestProcessorThreadPool() {
        RequestQueue requestQueue = RequestQueue.getInstance();

        for(int i = 0; i < 10; i++) {
            ArrayBlockingQueue<Request> queue = new ArrayBlockingQueue<Request>(100);
            requestQueue.addQueue(queue);
            threadPool.submit(new RequestProcessorThread(queue));
        }
    }


    public static RequestProcessorThreadPool instance;
    //单例绝对线程安全的方式
    private static class SingLeton{
        private static RequestProcessorThreadPool instance;

        static {
            instance=new RequestProcessorThreadPool();
        }
        public static RequestProcessorThreadPool getInstance() {
            return instance;
        }
    }

    /**
     * 利用jvm机制保证线程并发安全
     *内部类的初始化，一定只会发生一次，不管多少个线程并发去初始化
     * @return
     */
    public static  RequestProcessorThreadPool getInstance(){
        return  SingLeton.getInstance();
    }

    /**
     * 初始化的便捷方法
     */
    public static void init() {
        getInstance();
    }
}
