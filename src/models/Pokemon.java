package models;

public abstract class Pokemon{
protected int number;
protected String name;
protected Type type;

    public Pokemon(int number, String name, Type type) {
        this.number = number;
        this.name = name;
        this.type = type;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public abstract void getInfo();

abstract void makeNoise();
}
