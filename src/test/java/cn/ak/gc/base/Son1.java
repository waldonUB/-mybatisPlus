package cn.ak.gc.base;

public class Son1 extends Father1{

    public Son1() {
//        super("", "");
//        System.out.println();
        this(""); // 不能和super一起,只能放第一行,调用本来其他构造器
    }
    public Son1(String type) {
        super.name = "w";
        super.name = "w";
//        super("", "");
    }
    public static void main(String[] args) {
        new Son1();
    }
}
