package cn.ak.gc.designMode.factory;

public interface Car {
    default void ring () {
        System.out.println("每个车都能鸣喇叭");
    }
    void run();
}
