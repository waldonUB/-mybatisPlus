package cn.ak.gc.designMode.dynamic.cglib;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class HealthyKidMethodInterceptor implements IMethodInterceptor{
    @Override
    public Object intercept(Object proxy, Method method, Object[] args, Method proxyMethod) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Kid kid = (Kid) proxy;
        if ("eat".equals(method.getName())) {
            kid.washHand();
        }
        Object result = proxyMethod.invoke(proxy, args); // 这里才是真实调用kid的方法
        if ("eat".equals(method.getName())) {
            kid.brushTeeth();
        }
        return result;
    }
}
