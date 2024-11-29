package models;

import java.util.List;

public class Type {
    private String name;
    private String subtype1;
    private String subtype2;

    public Type(String typeName1, String typeName2) {
        if ( typeName2 == null || typeName2.isEmpty() ) {
            this.subtype1 = typeName1;
            this.subtype2 = null;
            this.name = typeName1;
        } else {
            this.subtype1 = typeName1;
            this.subtype2 = typeName2;
            this.name = typeName1 + "/" + typeName2;
        }
    }

    public String getName() {
        return name;
    }

    public String getSubtype1() {
        return subtype1;
    }

    public String getSubtype2() {
        return subtype2;
    }

    public void getInfo(){
        System.out.println(this.name);
    }
}
