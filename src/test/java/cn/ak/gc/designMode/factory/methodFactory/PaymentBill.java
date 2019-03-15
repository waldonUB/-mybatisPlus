package cn.ak.gc.designMode.factory.methodFactory;

public class PaymentBill implements Bill {
    @Override
    public void record() {
        System.out.println("我是负责记录付款信息的");
    }
}
