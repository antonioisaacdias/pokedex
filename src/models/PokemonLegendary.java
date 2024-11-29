package models;

public class PokemonLegendary extends Pokemon {

    private final String history;

    public PokemonLegendary(int number, String name, Type type, String history) {
        super(number, name, type);
        this.history = history;
    }

    public String getHistory() {
        return history;
    }

    @Override
    public void getInfo(){
        String info = "Número: " + this.number + " | Nome: " + this.name + " | Tipo: " + this.type.getName() + " | ESSE POKEMON É LENDÁRIO! | História: " + this.history;
        System.out.println(info);
    }

}
