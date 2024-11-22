package models;

import java.util.List;

public class Type {
    private String name;
    private List<Type> strong;
    private List<Type> weak;

    public void getInfo(){
        System.out.println(this.name);
        System.out.println(this.strong);
        System.out.println(this.weak);
    }
}
