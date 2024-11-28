package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database_Manager {
    private static final String URL = "jdbc:mariadb://localhost:3306/pokedex";
    private static final String USER = "root";
    private static final String PASSWORD = "33202121";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Erro ao estabelecer conexão: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}