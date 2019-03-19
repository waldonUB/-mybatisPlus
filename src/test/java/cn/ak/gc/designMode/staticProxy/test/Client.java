package cn.ak.gc.designMode.staticProxy.test;

public class Client {
    public static void main(String[] args) {
        SubObject subObject = new SubObject();
        ProxyPerson proxyPerson = new ProxyPerson(subObject);
        proxyPerson.dosomething();
    }
}
