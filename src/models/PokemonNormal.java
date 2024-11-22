package models;

public class PokemonNormal extends Pokemon {
    private PokemonNormal evolution;

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
