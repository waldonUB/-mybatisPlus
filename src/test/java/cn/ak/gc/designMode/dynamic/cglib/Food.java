package cn.ak.gc.designMode.dynamic.cglib;

public enum Food {
    RICE("米饭"),APPLE("苹果");
    private Food(String name){
        this.foodName = name;
    }
    private String foodName;
    public String foodName() {
        return foodName;
    }
}
