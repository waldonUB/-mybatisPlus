package cn.ak.gc.designMode.staticProxy.test1;

public class StaticProxy implements RealObject{
    private RealObject realObject;
    public StaticProxy(RealObject realObject) {
        this.realObject = realObject;
    }
    public void before() {
        System.out.println("我是before方法");
    }

    @Override
    public void doSomething() {
        before();
        realObject.doSomething();
    }
}
