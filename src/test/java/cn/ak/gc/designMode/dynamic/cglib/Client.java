package cn.ak.gc.designMode.dynamic.cglib;

import java.lang.reflect.InvocationTargetException;

public class Client {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Kid kid = new KidProxy(new HealthyKidMethodInterceptor());
        kid.eat(Food.APPLE);
    }
}
