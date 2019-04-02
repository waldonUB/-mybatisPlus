package cn.ak.gc.designMode.dynamic.cglibTest;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {

    public <T> T getInstance(Class<T> clazz) {
        return (T) Enhancer.create(clazz, this);
    }

    public void before() {
        System.out.println("我是before方法");
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        before();
        methodProxy.invokeSuper(o, objects);
        return null;
    }
}
