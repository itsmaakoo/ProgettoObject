package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connessioneDb {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/aereoportoNapoliDB";
        String user = "postgres";
        String password = "Tomako11";

        public static Connection getConnection() {
            try {
                return DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException e) {
                System.out.println(" Errore di connessione al DB:");
                e.printStackTrace();
                return null;
            }
        }
    }
