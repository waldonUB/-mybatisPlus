package cn.ak.gc.designMode.dynamic.test;

import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        SubObject subObject = new SubObject();
        DynamicProxyFactory dynamicProxyFactory = new DynamicProxyFactory(subObject);
        RealObject realObject = (RealObject) Proxy.newProxyInstance(dynamicProxyFactory.getClass().getClassLoader(), subObject.getClass().getInterfaces(), dynamicProxyFactory);
        realObject.doSomething();
    }
}
