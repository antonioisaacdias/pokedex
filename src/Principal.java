import models.Pokemon;
import models.PokemonNormal;
import models.Type;
import service.Pokedex;

public class Principal {
    public static void main(String[] args) {
        Type type = new Type("Fogo", "");
        PokemonNormal pokemon = new PokemonNormal( 152, "Cynda", type, "Teste");
        Pokedex.updatePokemon(pokemon);
        PokemonNormal pokemonReturn = (PokemonNormal) Pokedex.fetchPokemonByNumber(152);
        pokemonReturn.getInfo();
    }
}