import models.Pokemon;
import models.PokemonLegendary;
import models.PokemonNormal;
import models.Type;
import service.Pokedex;

public class Principal {
    public static void main(String[] args) {
        Type type = new Type("Fogo", null);
        PokemonLegendary  pokemonLegendary = new  PokemonLegendary(154, "EnteiR", type, "Cão lendário de fogo");
        Pokedex.updatePokemon(pokemonLegendary);
    }
}