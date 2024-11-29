import models.*;
import service.Pokedex;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        aplicationMenuIntro();

        Treiner treiner = registerUser();
        aplicationOptions(treiner);
    }

    public static void aplicationMenuIntro () {
        System.out.println("----------------------------------------------");
        System.out.println("--------------- Java Pokedex -----------------");
    }

    public static Treiner registerUser () {
        System.out.println("----------------------------------------------");
        System.out.println("Insira seu nome de treinador: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        Treiner treiner = new Treiner(name);
        return treiner;
    }

    public static void aplicationOptions (Treiner treiner) {
        Scanner scanner = new Scanner(System.in);
        int option = 99;
        while (option != 0){
            System.out.println("\n----------------------------------------------");
            System.out.println("Bem vindo " + treiner.getName() + "!");
            System.out.println("Escolha uma das opções.\n");
            System.out.println("1. Buscar todos os pokemons.");
            System.out.println("2. Buscar pokemon pelo número.");
            System.out.println("3. Buscar pokemon pelo nome.");
            System.out.println("4. Excluir pokemon da equipe.");
            System.out.println("5. Visualizar pokemons da sua equipe.");
            System.out.println("6. Menu de edição da Pokedex.");
            System.out.println("0. Finalizar programa.");
            System.out.println("\nDigite o número de uma das opções acima: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    int localOption1 = -1;
                    while (localOption1 != 0) {
                        System.out.println("\nPokedex Atualizada");
                        System.out.println("\n----------------------------------------------");
                        ArrayList<Pokemon> pokemons = Pokedex.fetchAllPokemon();
                        for (Pokemon pokemon : pokemons) {
                            pokemon.getInfo();
                        }
                        System.out.println("Digite 0 para retornar ao menu anterior.");
                        localOption1 = scanner.nextInt();
                    }
                    break;

                case 2:
                    int number = -1;
                    while (number != 0) {
                        System.out.println("\n----------------------------------------------");
                        System.out.println("Digite o número do pokemon desejado ou 0 para retornar ao menu anterior: ");
                        number = scanner.nextInt();
                        if (number != 0){
                            System.out.println("Buscando pokemon...\n");
                            Pokemon pokemon = Pokedex.fetchPokemonByNumber(number);
                            pokemon.getInfo();
                            System.out.println("\nDeseja adicionar pokemon à sua equipe?");
                            System.out.println("Digite 's' para SIM ou qualquer outra tecla para NÃO");
                            scanner.nextLine();
                            String addNumber = scanner.nextLine();
                            if (addNumber.equals("s")) {
                                treiner.addPokemon(pokemon);
                            }
                        }
                    }
                    break;

                case 3:
                    String optionName = "";
                    while (!optionName.equals("0")) {
                        System.out.println("\n----------------------------------------------");
                        System.out.println("Digite o nome do pokemon desejado ou 0 para retornar ao menu anterior: ");
                        scanner.nextLine();
                        optionName = scanner.nextLine();
                        if (!optionName.equals("0")){
                            System.out.println("Buscando pokemon...\n");
                            Pokemon pokemon = Pokedex.fetchPokemonByName(optionName);
                            pokemon.getInfo();
                            System.out.println("\nDeseja adicionar pokemon à sua equipe?");
                            System.out.println("Digite 's' para SIM ou qualquer outra tecla para NÃO");
                            String addNome = scanner.nextLine();
                            if (addNome.equals("s")) {
                                treiner.addPokemon(pokemon);
                            }
                        }
                    }
                    break;

                case 4:
                    String name = "";
                    while (!name.equals("0")){
                        System.out.println("\n");
                        treiner.showPokemons();
                        System.out.println("\nDigite nome de um pokemon para excluí-lo ou 0 para retornar ao menu: ");
                        scanner.nextLine();
                        name = scanner.nextLine();
                        treiner.removePokemon(name);
                    }
                    break;


                case 5:
                    int localOption5 = -1;
                    while (localOption5 != 0) {
                        System.out.println("\n----------------------------------------------");
                        treiner.showPokemons();
                        System.out.println("Digite 0 para retornar ao menu anterior.");
                        localOption5 = scanner.nextInt();
                    }
                    break;

                case 6:

                    int localOption6 = -1;
                    while (localOption6 != 0) {
                        System.out.println("\n----------------------------------------------");
                        System.out.println("----- Menu de edição dos dados da Pokedex ----");
                        System.out.println("----------------------------------------------");
                        System.out.println("1. Adicionar novo pokemon à Pokedex.");
                        System.out.println("2. Atualizar dados de pokemon já existete na Pokedex.");
                        System.out.println("3. Excluir pokemon da Pokedex.");
                        System.out.println("\nDigite o número da opção desejada:");
                        localOption6 = scanner.nextInt();

                        switch (localOption6) {
                            case 1:
                                System.out.println("\nPara adicionar o pokemon você fornecer alguns dados...");
                                System.out.println("Esse pokemon é lendário? Responda 's' para SIM ou qualquer outra tecla para NÃO:");
                                scanner.nextLine();
                                String isLegendary = scanner.nextLine();
                                if (isLegendary.equals("s")) {
                                    System.out.println("\nAdicionando pokemon lendário...");
                                    System.out.println("Insira o número do novo pokemon: ");
                                    int numberNew = scanner.nextInt();
                                    System.out.println("Insira o nome do novo pokemon: ");
                                    scanner.nextLine();
                                    String nameNew = scanner.nextLine();
                                    System.out.println("Insira o primeiro subtipo do pokemon: ");
                                    String subtype1New = scanner.nextLine();
                                    System.out.println("Insira o segundo subtipo do pokemon (Caso não possua, deixe vazio!): ");
                                    String subtype2New = scanner.nextLine();
                                    System.out.println("Insira um pouco da história desse pokemon: ");
                                    String historyNew = scanner.nextLine();

                                    Type typeNew = new Type(subtype1New, subtype2New);

                                    PokemonLegendary pokemonLegendary = new PokemonLegendary(numberNew, nameNew, typeNew, historyNew);
                                    Pokedex.addPokemon(pokemonLegendary);
                                }
                                else {
                                    System.out.println("\nAdicionando pokemon normal...");
                                    System.out.println("Insira o número do novo pokemon: ");
                                    int numberNew = scanner.nextInt();
                                    System.out.println("Insira o nome do novo pokemon: ");
                                    scanner.nextLine();
                                    String nameNew = scanner.nextLine();
                                    System.out.println("Insira o primeiro subtipo do pokemon: ");
                                    String subtype1New = scanner.nextLine();
                                    System.out.println("Insira o segundo subtipo do pokemon (Caso não possua, deixe vazio!): ");
                                    String subtype2New = scanner.nextLine();
                                    System.out.println("Insira o nome da próxima evolução do pokemon (Caso não possua, deixe vazio!): ");
                                    String evolutionNew = scanner.nextLine();

                                    Type typeNew = new Type(subtype1New, subtype2New);

                                    PokemonNormal pokemonNormal = new PokemonNormal(numberNew, nameNew, typeNew, evolutionNew);
                                    Pokedex.addPokemon(pokemonNormal);
                                }
                                break;

                            case 2:
                                int numberToUpdate = -1;
                                while (numberToUpdate != 0) {
                                    System.out.println("\nPara atualizar os dados de um pokemon digite seu número, ou digite 0 para retornar: ");
                                    numberToUpdate = scanner.nextInt();
                                    if (numberToUpdate != 0){
                                        Pokemon pokemon = Pokedex.fetchPokemonByNumber(numberToUpdate);
                                        pokemon.getInfo();
                                        System.out.println("Deseja editar esse pokemon? Responda 's' para SIM ou qualquer outra tecla para NÃO:");
                                        scanner.nextLine();
                                        String confirm = scanner.nextLine();
                                        if (confirm.equals("s")){
                                            System.out.println("\nEditando pokemon...");
                                            System.out.println("Insira o novo nome do pokemon: ");
                                            String nameNew = scanner.nextLine();
                                            System.out.println("Insira o primeiro subtipo do pokemon: ");
                                            String subtype1New = scanner.nextLine();
                                            System.out.println("Insira o segundo subtipo do pokemon (Caso não possua, deixe vazio!): ");
                                            String subtype2New = scanner.nextLine();
                                            pokemon.setName(nameNew);
                                            Type typeNew = new Type(subtype1New, subtype2New);
                                            pokemon.setType(typeNew);

                                            Pokedex.updatePokemon(pokemon);
                                        }
                                    }
                                }

                                break;

                            case 3:
                                int numberToDelete = -1;
                                while (numberToDelete != 0){
                                    System.out.println("\nPara excluir um pokemon digite seu número ou digite 0 para retornar ao menu anterior: ");
                                    numberToDelete = scanner.nextInt();
                                    if (numberToDelete != 0){
                                        Pokemon pokemon = Pokedex.fetchPokemonByNumber(numberToDelete);
                                        pokemon.getInfo();
                                        System.out.println("Tem certeza que deseja excluir esse pokemon? Responda 's' para SIM ou qualquer outra tecla para NÃO:");
                                        scanner.nextLine();
                                        String confirm = scanner.nextLine();
                                        if (confirm.equals("s")) {
                                            Pokedex.removePokemon(numberToDelete);
                                        }
                                    }
                                }
                                break;
                        }
                    }
                    break;

            }

            System.out.println("\n----------------------------------------------");
            System.out.println("Finalizando aplicação...");
            System.out.println("----------------------------------------------");
        }
    }
}