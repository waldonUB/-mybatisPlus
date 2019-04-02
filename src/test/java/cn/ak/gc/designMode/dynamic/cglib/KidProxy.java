package cn.ak.gc.designMode.dynamic.cglib;

import java.lang.reflect.InvocationTargetException;

public class KidProxy extends Kid {

    private IMethodInterceptor methodInterceptor;

    public KidProxy(IMethodInterceptor methodInterceptor) {
        this.methodInterceptor = methodInterceptor;
    }

    @Override
    public void eat(Food food) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        methodInterceptor.intercept(this, Kid.class.getMethod("eat", Food.class),
                new Object[]{food}, this.getClass().getMethod("eatProxy", Food.class));
    }

    public void eatProxy(Food food) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        super.eat(food);
    }

    @Override
    public void brushTeeth() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        methodInterceptor.intercept(this, Kid.class.getMethod("brushTeeth"),
                new Object[]{}, this.getClass().getMethod("brushTeethProxy"));
    }

    public void brushTeethProxy() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        super.brushTeeth();
    }

    @Override
    public void washHand() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        methodInterceptor.intercept(this, Kid.class.getMethod("washHand"),
                new Object[]{}, this.getClass().getMethod("washHandProxy"));
    }

    public void washHandProxy() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        super.washHand();
    }
}
