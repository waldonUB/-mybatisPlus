package cn.ak.gc.designMode.factory.staticFactory.test;

public class BillFactory{
    public Bill createBill(String billType) {
        if ("PaymentBill".equals(billType)) {
            return new PaymentBill();
        }
        return null;
    }
}
