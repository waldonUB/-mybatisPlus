package cn.ak.gc.base;

import cn.ak.gc.domain.entities.UserInfo;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class InvokeTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        Class<?> clazz = Class.forName("cn.ak.gc.base.Father");
        Father father = new Father();
        Method[] methods = clazz.getMethods();
        Object object = clazz.newInstance(); // 只能用来实例化带无参构造函数的类
        Method method1 = object.getClass().getMethod("overrideTest"); // 获取单个方法
        for (Method method : methods) {
            if (method.getName().equals("overrideTest")) {
                method.invoke(object);
            }
        }
    }

    @Test
    public void exceptionTest() {
    }
}
