package cn.ak.gc.designMode.staticProxy.test;

public class ProxyPerson implements RealObject {
    private RealObject realObject;

    public ProxyPerson(RealObject realObject) {
        this.realObject = realObject;
    }

    @Override
    public void dosomething() {
        System.out.println("我是代理的");
        realObject.dosomething();
    }
}
