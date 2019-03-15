package cn.ak.gc.designMode.staticProxy.impl;

import cn.ak.gc.designMode.staticProxy.RealObject;

public class RealObjectImpl2 implements RealObject {
    @Override
    public void request() {
        System.out.println("RealObjectImpl2");
    }

    @Override
    public void hello() {

    }
}
