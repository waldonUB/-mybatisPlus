package cn.ak.gc.base.extendsE;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public interface RunnableTest extends Runnable, Future, RunnableTest2 { // , RunableTest1 接口支持多继承,除非两个接口中含有相同的default方法

    @Override
    void run();

    @Override
    boolean cancel(boolean mayInterruptIfRunning);

    @Override
    boolean isCancelled();

    @Override
    boolean isDone();

    @Override
    Object get() throws InterruptedException, ExecutionException;

    @Override
    Object get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException;
}
