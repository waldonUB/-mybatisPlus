package cn.ak.gc.designMode.staticProxy.test;

public class SubObject implements RealObject {
    @Override
    public void dosomething() {
        System.out.println("我是实现这个目标的");
    }
}
