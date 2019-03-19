package cn.ak.gc.threadTest;

import java.util.concurrent.*;

public class ExecutorThreadPoolTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int coreSize = Runtime.getRuntime().availableProcessors(); // 获取当前核心数
        long start = System.currentTimeMillis();
        System.out.println("当前核心数：" + coreSize);
        ExecutorService executorService = new ThreadPoolExecutor(3, coreSize, 60, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(2000));
        Future<String> future1 = executorService.submit(new Callable<String>() { // 默认写法
            @Override
            public String call() throws Exception {
                Thread.sleep(5000);
                return "第一个任务";
            }
        });
        Future<String> future2 = executorService.submit(() -> {
            Thread.sleep(3000);
            return "第二个任务";
        });
        Future<String> future3 = executorService.submit(() -> {
            Thread.sleep(8000);
            return "第三个任务";
        });
        String result1 = future1.get();
        String result2 = future2.get();
        String result3 = future3.get();
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        long end = System.currentTimeMillis();
        System.out.println("耗费时间：" + (end - start));
    }
}
