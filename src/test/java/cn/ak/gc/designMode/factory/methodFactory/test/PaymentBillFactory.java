package cn.ak.gc.designMode.factory.methodFactory.test;

public class PaymentBillFactory implements BillFactory {
    @Override
    public Bill createBill() {
        return new PaymentBill();
    }

//    @Override
//    public void c() {
////        return new PaymentBill();
//    }
}
