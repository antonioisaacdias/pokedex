package service;

import models.Pokemon;
import models.PokemonLegendary;
import models.PokemonNormal;
import models.Type;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Pokedex {

    public static void addPokemon(Pokemon pokemon) {
        String sql = "INSERT INTO pokemon (number, name, type1, type2, evolution, isLegendary, history) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = Database_Manager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            if (pokemon instanceof PokemonNormal pokemonNormal) {
                int number = pokemonNormal.getNumber();
                String name = pokemonNormal.getName();
                String type1 = pokemonNormal.getType().getSubtype1();
                String type2 = pokemonNormal.getType().getSubtype2();
                String evolution = pokemonNormal.getEvolution();
                int isLegendary = 0;
                String history = null;

                preparedStatement.setInt(1, number);
                preparedStatement.setString(2, name);
                preparedStatement.setString(3, type1);
                preparedStatement.setString(4, type2);
                preparedStatement.setString(5, evolution);
                preparedStatement.setInt(6, isLegendary);
                preparedStatement.setString(7, history);

            }
            else if (pokemon instanceof PokemonLegendary pokemonLegendary) {
                int number = pokemonLegendary.getNumber();
                String name = pokemonLegendary.getName();
                String type1 = pokemonLegendary.getType().getSubtype1();
                String type2 = pokemonLegendary.getType().getSubtype2();
                String evolution = null;
                int isLegendary = 1;
                String history = pokemonLegendary.getHistory();

                preparedStatement.setInt(1, number);
                preparedStatement.setString(2, name);
                preparedStatement.setString(3, type1);
                preparedStatement.setString(4, type2);
                preparedStatement.setString(5, evolution);
                preparedStatement.setInt(6, isLegendary);
                preparedStatement.setString(7, history);
            }

            preparedStatement.executeUpdate();
            System.out.println("Pokemon cadastrado com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar Pokémon: " + e.getMessage());
        }
    }

    public static void removePokemon(int number){
        String sql = "DELETE FROM pokemon WHERE number = ?";
        try (Connection connection = Database_Manager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, number);
            int linhasAfetadas = preparedStatement.executeUpdate();

            System.out.println("Pokemon excluído com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao excluir Pokémon: " + e.getMessage());

        }
    }

    public static void updatePokemon(Pokemon pokemon){
        String sql = "UPDATE pokemon SET name = ?, type1 = ?, type2 = ?, evolution = ?, isLegendary = ?, history = ? WHERE number = ?";
        try (Connection connection = Database_Manager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            if (pokemon instanceof PokemonNormal pokemonNormal) {
                int number = pokemonNormal.getNumber();
                System.out.println(number);
                String name = pokemonNormal.getName();
                String type1 = pokemonNormal.getType().getSubtype1();
                String type2 = pokemonNormal.getType().getSubtype2();
                String evolution = pokemonNormal.getEvolution();
                System.out.println(evolution);
                int isLegendary = 0;
                String history = null;

                preparedStatement.setInt(7, number);
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, type1);
                preparedStatement.setString(3, type2);
                preparedStatement.setString(4, evolution);
                preparedStatement.setInt(5, isLegendary);
                preparedStatement.setString(6, history);

            }
            else if (pokemon instanceof PokemonLegendary pokemonLegendary) {
                int number = pokemonLegendary.getNumber();
                String name = pokemonLegendary.getName();
                String type1 = pokemonLegendary.getType().getSubtype1();
                String type2 = pokemonLegendary.getType().getSubtype2();
                String evolution = null;
                int isLegendary = 1;
                String history = pokemonLegendary.getHistory();

                preparedStatement.setInt(7, number);
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, type1);
                preparedStatement.setString(3, type2);
                preparedStatement.setString(4, evolution);
                preparedStatement.setInt(5, isLegendary);
                preparedStatement.setString(6, history);
            }
            preparedStatement.executeUpdate();
            System.out.println("Pokemon atualizado com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar Pokémon: " + e.getMessage());
        }
    }

    public static List<Pokemon> fetchAllPokemon(){
        String sql = "SELECT number, name, type1, type2, evolution, isLegendary, history FROM pokemon";

        try (Connection connection = Database_Manager.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            List<Pokemon> pokemons = new ArrayList<>();

            while (resultSet.next()) {
                boolean isLegendary = (resultSet.getInt("isLegendary") == 1);

                if(!isLegendary) {
                    int number = resultSet.getInt("number");
                    String name = resultSet.getString("name");
                    String typeName1 = resultSet.getString("type1");
                    String typeName2 = resultSet.getString("type2");
                    String evolution = resultSet.getString("evolution");

                    Type type = new Type(typeName1, typeName2);
                    PokemonNormal pokemonNormal = new PokemonNormal(number, name, type, evolution);
                    pokemons.add(pokemonNormal);
                }
                else {
                    int number = resultSet.getInt("number");
                    String name = resultSet.getString("name");
                    String typeName1 = resultSet.getString("type1");
                    String typeName2 = resultSet.getString("type2");
                    String history = resultSet.getString("history");

                    Type type = new Type(typeName1, typeName2);
                    PokemonLegendary pokemonLegendary = new PokemonLegendary(number, name, type, history);
                    pokemons.add(pokemonLegendary);
                }
            }
            return pokemons;

        } catch (SQLException e) {
            System.out.println("Erro ao consultar todos os Pokémon: " + e.getMessage());
            return null;
        }
    }

    public static Pokemon fetchPokemonByNumber(int number){
        String sql = "SELECT * FROM pokemon WHERE number = ?";
        try (Connection connection = Database_Manager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, number);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Boolean isLegendary = (resultSet.getInt("isLegendary") == 1);
                if(isLegendary) {
                    System.out.println("Esse pokemon é lendário!");

                    String name = resultSet.getString("name");
                    String typeName1 = resultSet.getString("type1");
                    String typeName2 = resultSet.getString("type2");
                    String history = resultSet.getString("history");
                    Type type = new Type(typeName1, typeName2);

                    return new PokemonLegendary(number, name, type, history);

                } else {
                    String name = resultSet.getString("name");
                    String typeName1 = resultSet.getString("type1");
                    String typeName2 = resultSet.getString("type2");
                    String evolution = resultSet.getString("evolution");
                    Type type = new Type(typeName1, typeName2);

                    return new PokemonNormal(number, name, type, evolution);
                }

            } else {
                System.out.println("Pokemon não encontrado!");
                return null;
            }

        } catch (SQLException e) {
            System.out.println("Erro ao consultar Pokémon por número: " + e.getMessage());
            return null;
        }
    }

    public static Pokemon fetchPokemonByName(String name){
        String sql = "SELECT * FROM pokemon WHERE name = ?";
        try (Connection connection = Database_Manager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Boolean isLegendary = (resultSet.getInt("isLegendary?") == 1);
                if(isLegendary) {
                    System.out.println("Esse pokemon é lendário!");

                    int number = Integer.parseInt(resultSet.getString("number"));
                    String typeName1 = resultSet.getString("type1");
                    String typeName2 = resultSet.getString("type2");
                    String history = resultSet.getString("history");
                    Type type = new Type(typeName1, typeName2);

                    return new PokemonLegendary(number, name, type, history);

                } else {
                    int number = Integer.parseInt(resultSet.getString("number"));
                    String typeName1 = resultSet.getString("type1");
                    String typeName2 = resultSet.getString("type2");
                    String evolution = resultSet.getString("evolution");
                    Type type = new Type(typeName1, typeName2);

                    return new PokemonNormal(number, name, type, evolution);
                }
            }
            else {
                System.out.println("Pokemon não encontrado!");
                return null;
            }

        } catch (SQLException e) {
            System.out.println("Erro ao consultar Pokémon por nome: " + e.getMessage());
            return null;
        }
    }

}





