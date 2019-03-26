package cn.ak.gc.base;

import org.junit.Test;

public class Client {
    @Test
    public void innerClass() throws ClassNotFoundException {
//        Father father = new Father(""); // new隐式加载，会调用非static块
//        Father.getI(); // 对静态变量进行get set则不会
//        Father.setI(5); // 对静态变量进行get set则不会
//        Father.test(); // 静态方法也不会
        Class.forName("cn.ak.gc.base.Father"); // 显示加载也不会
    }
}
