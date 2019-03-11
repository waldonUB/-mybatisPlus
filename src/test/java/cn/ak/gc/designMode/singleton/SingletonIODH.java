package cn.ak.gc.designMode.singleton;

public class SingletonIODH {
    private SingletonIODH() {

    }

    private static class HolderClass {
        private final static SingletonIODH singleton = new SingletonIODH();
    }

    public static SingletonIODH getInstance() {
        return HolderClass.singleton;
    }

    public static void main(String[] args) {
        SingletonIODH singletonIODH = SingletonIODH.getInstance(); // IODH的实现方法,比饿汉和懒汉更好
    }
}
