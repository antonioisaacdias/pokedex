package models;

public abstract class Pokemon{
private int number;
private String name;
private Type[] type;

abstract void getInfo();

abstract void makeNoise();
}
