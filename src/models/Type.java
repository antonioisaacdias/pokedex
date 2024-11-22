package models;

import java.util.List;

public class Type {
    private String name;
    private List<Type> strong;
    private List<Type> weak;

    public Type(String name, List<Type> strong, List<Type> weak) {
        this.name = name;
        this.strong = strong;
        this.weak = weak;
    }

    public void getInfo(){
        System.out.println(this.name);
        System.out.println(this.strong);
        System.out.println(this.weak);
    }
}
