package cn.ak.gc.designMode.staticProxy;

import cn.ak.gc.designMode.staticProxy.impl.RealObjectImpl;
import cn.ak.gc.designMode.staticProxy.impl.RealObjectImpl2;

public class Client {
    public static void main(String[] args) {
        // 首先是一个接口,然后是一个实现接口的目标对象
        // 然后是一个有可以传入目标对象构造方法的代理类
        // 再在重写的代理方法里面做逻辑,实际上还是调用了目标对象的方法
        RealObject realObject = new RealObjectImpl();
//        RealObject realObject2 = new RealObjectImpl2();
        RealObject staticProxy = new StaticProxy(realObject);
        staticProxy.request();
        staticProxy.hello();
    }
}
