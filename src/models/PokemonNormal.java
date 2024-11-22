package models;

public class PokemonNormal extends Pokemon {
    private PokemonNormal evolution;

    public PokemonNormal(int number, String name, Type[] type, PokemonNormal evolution) {
        super(number, name, type);
        this.evolution = evolution;
    }

    @Override
    void getInfo(){
        System.out.println(this.number);
        System.out.println(this.name);
        System.out.println(this.evolution);
    }

    @Override
    void makeNoise() {

    }
}
