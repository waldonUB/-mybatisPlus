package cn.ak.gc.base;

public class Father1 {
    String name = "";
    public Father1() {
        System.out.println("father1无参");
    }
    public Father1(String type) {
        System.out.println("father1有1参");
    }

    public Father1(String type, String type1) {
        System.out.println("father1有2参");
    }
}
