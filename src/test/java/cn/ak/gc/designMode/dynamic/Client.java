package cn.ak.gc.designMode.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        RealObjectImpl realObject = new RealObjectImpl();
        InvocationHandler invocationHandler = new DynamicProxy(realObject);
        RealObject realObject1 = (RealObject) Proxy.newProxyInstance(invocationHandler.getClass().getClassLoader(),
                realObject.getClass().getInterfaces(), invocationHandler);
        realObject1.hello();
        realObject1.request();
    }
}
