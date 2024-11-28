package models;

public class PokemonLengendary extends Pokemon {

    private final String history;

    public PokemonLengendary(int number, String name, Type type, String history) {
        super(number, name, type);
        this.history = history;
    }

    @Override
    public void getInfo(){
        System.out.println(this.number);
        System.out.println(this.name);
        System.out.println(this.history);
    }

    @Override
    void makeNoise() {

    }
}
