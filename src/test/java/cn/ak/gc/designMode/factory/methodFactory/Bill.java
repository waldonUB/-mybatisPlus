package cn.ak.gc.designMode.factory.methodFactory;

public interface Bill {
    default void createBarCode() {
        System.out.println("这里生产条形码");
    }
    void record();
}
