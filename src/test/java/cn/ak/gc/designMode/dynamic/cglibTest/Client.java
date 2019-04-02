package cn.ak.gc.designMode.dynamic.cglibTest;

public class Client {
    public static void main(String[] args) throws NoSuchMethodException {
        CglibProxy cglibProxy = new CglibProxy();
        RealObject realObject = cglibProxy.getInstance(RealObjectImpl.class);
        realObject.doSomething();
    }

}
