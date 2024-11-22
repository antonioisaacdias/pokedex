package models;

public abstract class Pokemon{
protected int number;
protected String name;
protected Type[] type;

abstract void getInfo();

abstract void makeNoise();
}
