package cn.ak.gc.base;

public class Son extends Father {
    private String type = "";
    public Son() {
//        System.out.println();   是super()方法只能放在构造器且只能放在第一行
        super(""); // 父类存在有参构造器时,子类必须显式声明
        super.type = "w";
        this.type = "w";
//        this();
    }

//    public Son(String type) {
//        super(type);
//    }

    public void testSuper() {
//        super();  是super()方法只能放在构造器且只能放在第一行
    }
}
