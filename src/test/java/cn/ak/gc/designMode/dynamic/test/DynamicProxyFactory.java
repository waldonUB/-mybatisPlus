package cn.ak.gc.designMode.dynamic.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxyFactory implements InvocationHandler {

    private RealObject realObject;

    public DynamicProxyFactory(RealObject realObject) {
        this.realObject = realObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理前");
        method.invoke(realObject, args);
        return null;
    }
}
