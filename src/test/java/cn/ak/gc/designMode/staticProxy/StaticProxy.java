package cn.ak.gc.designMode.staticProxy;

public class StaticProxy implements RealObject{

    private RealObject realObject;

    public StaticProxy(RealObject realObject) {
        this.realObject = realObject;
    }

    @Override
    public void request() {
        System.out.println("代理前");
        realObject.request();
    }
}
