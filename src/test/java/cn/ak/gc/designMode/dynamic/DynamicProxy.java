package cn.ak.gc.designMode.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxy implements InvocationHandler {

    private RealObject realObject;

    public DynamicProxy(RealObject realObject) {
        this.realObject = realObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 代理前
        System.out.println("代理前");
        method.invoke(realObject, args);
        System.out.println("代理后");
        return null;
    }
}
