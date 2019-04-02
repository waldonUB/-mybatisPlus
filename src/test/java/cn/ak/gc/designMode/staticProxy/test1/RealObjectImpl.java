package cn.ak.gc.designMode.staticProxy.test1;

public class RealObjectImpl implements RealObject {
    @Override
    public void doSomething() {
        System.out.println("我是实现真正接口的");
    }
}
