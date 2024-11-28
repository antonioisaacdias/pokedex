package models;

public class PokemonNormal extends Pokemon {
    private String evolution;

    public PokemonNormal(int number, String name, Type type, String evolution) {
        super(number, name, type);
        if (evolution == null || evolution.isEmpty()) {
            this.evolution = null;
        } else {
            this.evolution = evolution;
        }
    }


    public String getEvolution() {
        if (this.evolution == null) {
            return "";
        } else {
            return this.evolution;
        }
    }

    @Override
    public void getInfo(){
        String info = "Número: " + this.number + " | Nome: " + this.name + " | Tipo: " + this.type.getName() + " | Evolução: " + this.evolution;
        System.out.println(info);
    }

    @Override
    public void makeNoise() {

    }
}
