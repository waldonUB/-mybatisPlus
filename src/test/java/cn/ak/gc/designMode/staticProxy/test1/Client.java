package cn.ak.gc.designMode.staticProxy.test1;

public class Client {
    public static void main(String[] args) {
        RealObject realObject = new StaticProxy(new RealObjectImpl());
        realObject.doSomething();
    }
}
