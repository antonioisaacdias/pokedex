package models;

public class PokemonLengendary extends Pokemon {

    private String history;

    @Override
    void getInfo(){
        System.out.println(this.number);
        System.out.println(this.name);
        System.out.println(this.history);
    }

    @Override
    void makeNoise() {

    }
}
