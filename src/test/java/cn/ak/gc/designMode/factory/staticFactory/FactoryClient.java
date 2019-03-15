package cn.ak.gc.designMode.factory.staticFactory;

public class FactoryClient {
    public static void main(String[] args) {
        Car car = CarFactory.getCar("BWM");
    }
}
