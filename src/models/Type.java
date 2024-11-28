package models;

import java.util.List;

public class Type {
    private String name;
    private List<Type> strong;
    private List<Type> weak;

    public Type(String typeName1, String typeName2) {
        if (typeName2.isEmpty()) {
            this.name = typeName1;
        } else {
            this.name = typeName1 + "/" + typeName2;
        }
    }

    public String getName() {
        return name;
    }

    public List<Type> getStrong() {
        return strong;
    }

    public List<Type> getWeak() {
        return weak;
    }

    public void getInfo(){
        System.out.println(this.name);
        System.out.println(this.strong);
        System.out.println(this.weak);
    }
}
