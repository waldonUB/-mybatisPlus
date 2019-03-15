package cn.ak.gc.designMode.factory.staticFactory;

public class CarFactory {

    public static Car getCar(String type) {
        switch (type) {
            case "BWM" : return new BWM();
        }
        return null;
    }
}
