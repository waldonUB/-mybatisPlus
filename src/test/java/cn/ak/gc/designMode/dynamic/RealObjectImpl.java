package cn.ak.gc.designMode.dynamic;

public class RealObjectImpl implements RealObject {

    @Override
    public void request() {
        System.out.println("request");
    }

    @Override
    public void hello() {
        System.out.println("hello");
    }
}
