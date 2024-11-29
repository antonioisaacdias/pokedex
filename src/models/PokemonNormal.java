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
        String evolutionName;
        if (this.evolution == null) {
            evolutionName = "Não evolui!";
        } else {
            evolutionName = this.evolution;
        }
        String info = "Número: " + this.number + " | Nome: " + this.name + " | Tipo: " + this.type.getName() + " | Evolução: " + evolutionName;
        System.out.println(info);
    }
}
