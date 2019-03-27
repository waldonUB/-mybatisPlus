package cn.ak.gc.base;

public class Father {
    static {
        System.out.println("我是Father的static块");
    }

    {
        System.out.println("我是Father的非static块");
    }

    public static int i;

    public static int getI() {
        return i;
    }

    public static void setI(int i) {
        Father.i = i;
    }

    public static void test() {

    }

    protected String type = "";
    public Father(String type) {

    }

    public Father() {

    }

    public static void overrideTest() {
        System.out.println("测试invoke方法");
    }
}
