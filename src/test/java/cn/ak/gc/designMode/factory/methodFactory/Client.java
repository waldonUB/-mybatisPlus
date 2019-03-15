package cn.ak.gc.designMode.factory.methodFactory;

public class Client {
    public static void main(String[] args) {
        BillFactory billFactory = new PaymentBillFactory();
        Bill bill = billFactory.createBill();
        bill.record();
        bill.createBarCode();
    }
}
