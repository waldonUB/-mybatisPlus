package cn.ak.gc.designMode.factory.staticFactory.test;

public class PaymentBill implements Bill {
    @Override
    public void createBill() {
        System.out.println("我是付款单");
    }
}
