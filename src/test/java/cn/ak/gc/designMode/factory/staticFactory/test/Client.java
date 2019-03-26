package cn.ak.gc.designMode.factory.staticFactory.test;

public class Client {
    public static void main(String[] args) {
        BillFactory billFactory = new BillFactory();
        Bill bill = billFactory.createBill("PaymentBill");
    }
}
