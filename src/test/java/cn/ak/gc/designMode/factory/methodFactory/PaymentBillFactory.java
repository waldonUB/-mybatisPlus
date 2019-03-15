package cn.ak.gc.designMode.factory.methodFactory;

public class PaymentBillFactory implements BillFactory {
    @Override
    public Bill createBill() {
        return new PaymentBill();
    }
}
