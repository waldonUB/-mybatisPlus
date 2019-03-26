package cn.ak.gc.threadTest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        long start = System.currentTimeMillis();
        List<String> list = new ArrayList<>();
        list.add("1");
        Callable<List<String>> shopping = new Callable<List<String>>() { // 第一个任务
            @Override
            public List<String> call() throws Exception {
                System.out.println("下单");
                System.out.println("等待送货");
                Thread.sleep(10000);
                System.out.println("快递送到");
                return list;
            }
        };
        // 第二个任务
        Callable<Chuju> shopping2 = () -> {
            System.out.println("下单2");
            System.out.println("等待送货2");
            Thread.sleep(12000);
            System.out.println("快递送到2");
            return new Chuju();
        };
        FutureTask<List<String>> task = new FutureTask<>(shopping);
        FutureTask<Chuju> task2 = new FutureTask<>(shopping2);
        new Thread(task).start();
        new Thread(task2).start();
        // 第二步  购买食材
        Thread.sleep(2000); // 模拟购买食材时间
        Shicai shicai = new Shicai();
        System.out.println("食材可以了");
        if (!task.isDone()) {
            System.out.println("厨具还没有到");
        } else {
            System.out.println("厨具到了");
        }
        List<String> list1 = task.get();
        Chuju chuju2 = task2.get();
        System.out.println(list1);
        System.out.println("厨具到了,开始展现厨艺");
        long end = System.currentTimeMillis();
        System.out.println("耗时:" + (end - start));
    }

    static class Chuju {}
    static class Shicai {}
}
