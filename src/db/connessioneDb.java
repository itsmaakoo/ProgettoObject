package db; // cambia se hai un altro package

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connessioneDb {
    private static final String URL = "jdbc:postgresql://localhost:5432/aereoportoNapoliDB";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Zr8v!pDq21@LmXeK"; // <- cambia con la tua password

    public static Connection getConnection() {
        Connection conn = null;
        try {
            // Carica il driver PostgreSQL (non sempre necessario con JDBC 4+, ma meglio farlo)
            Class.forName("org.postgresql.Driver");

            // Prova a connetterti
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connessione al DB riuscita!");
        } catch (ClassNotFoundException e) {
            System.err.println("Driver PostgreSQL non trovato. Aggiungi il JAR al progetto!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Errore nella connessione al DB:");
            e.printStackTrace();
        }
        return conn;
    }
}
