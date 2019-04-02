package cn.ak.gc.designMode.dynamic.cglib;

import java.lang.reflect.InvocationTargetException;

public class Kid {
    public void eat(Food food) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        System.out.println("吃" + food.foodName());
    }

    public void brushTeeth() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        System.out.println("刷牙");
    }

    public void washHand() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        System.out.println("洗手");
    }
}


