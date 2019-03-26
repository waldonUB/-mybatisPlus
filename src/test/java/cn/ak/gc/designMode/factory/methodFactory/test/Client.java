package cn.ak.gc.designMode.factory.methodFactory.test;

import java.util.Arrays;

public class Client {
    public static void main(String[] args) {
        BillFactory[] billFactory = new BillFactory[]{
                () -> new PaymentBill(),
                new BillFactory() {
                    @Override
                    public Bill createBill() {
                        return new PaymentBill();
                    }

                }
        };
//        Arrays.stream(billFactory).map(() -> );
    }
}
