package cn.ak.gc.designMode.factory.methodFactory.test;

public class PaymentBill implements Bill {
    @Override
    public void record() {
        System.out.println("我记录付款结算");
    }
}
