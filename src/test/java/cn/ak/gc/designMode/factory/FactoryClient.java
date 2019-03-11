package cn.ak.gc.designMode.factory;

public class FactoryClient {
    public static void main(String[] args) {
        Car car = CarFactory.getCar("BWM");
    }
}
