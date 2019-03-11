package cn.ak.gc.designMode.factory;

public class BWM implements Car {

    public void myself() {
        System.out.println("我是BWM");
    }

    @Override
    public void run() {
        myself();
    }


}
