package cn.ak.gc.designMode.staticProxy.impl;

import cn.ak.gc.designMode.staticProxy.RealObject;

public class RealObjectImpl implements RealObject {

    @Override
    public void request() {
        System.out.println("static request");
    }

}
