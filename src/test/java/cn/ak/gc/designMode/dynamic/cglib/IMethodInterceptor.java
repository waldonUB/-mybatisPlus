package cn.ak.gc.designMode.dynamic.cglib;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public interface IMethodInterceptor {
    Object intercept(Object proxy, Method method, Object[] args, Method proxyMethod) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException;
}
