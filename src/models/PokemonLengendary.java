package models;

public class PokemonLengendary extends Pokemon {

    private final String history;

    public PokemonLengendary(int number, String name, Type type, String history) {
        super(number, name, type);
        this.history = history;
    }

    public String getHistory() {
        return history;
    }

    @Override
    public void getInfo(){
        String info = "Número: " + this.number + " | Nome: " + this.name + " | Tipo: " + this.type.getName();
        System.out.println(info);
        System.out.println(this.history);
    }

    @Override
    void makeNoise() {

    }
}
