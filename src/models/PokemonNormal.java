package models;

public class PokemonNormal extends Pokemon {
    private String evolution;

    public PokemonNormal(int number, String name, Type type) {
        super(number, name, type);
    }


    @Override
    public void getInfo(){
        String info = "Número: " + this.number + " | Nome: " + this.name + " | Tipo: " + this.type.getName();
        System.out.println(info);
    }

    @Override
    public void makeNoise() {

    }
}
