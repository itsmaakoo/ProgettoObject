package dao;

import db.connessioneDb;
import model.utente;

import java.sql.*;
import java.until.ArrayList;
import java.util.List;

public class UtenteDao{
    public void inserisciUtente(Utente u){
        String sql = "INSERT INTO utenti(username,password,ruolo) VALUES (?.?.?)";

        try (Connection conn = connessioneDb.getConnection());
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){

            ps.setString(1, u.getUsername());
            ps.setString(2, u.getPassword());
            ps.setString(3, u.getRuolo());

            ps.executeUpdate();

            Result rs = ps.getGeneratedKeys();
            if (rs.next()) {
                u.setId(rs.getInt(1));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
}

public Utente getUtenteByUsername(String username){
    String sql = "SELECT * FROM utenti WHERE username = ?";
    try(Connection conn = connessioneDb.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setString(1,username);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            return new Utente(
                rs.getInt("id"),
                rs.getString("username"),
                rs.getString("password"),
                rs.getString("ruolo"),
                );
        }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
}

public List<Utente> getTuttiGliUtenti(){
    List<Utente> utenti = new Arraylist<>();
    String sql = "SELECT * FROM utenti";

    try(Connection conn = connessioneDb.getConnection();
    Statement st = conn.createStatement();
    ResultSet rs = st.executeQuery(sql)) {

        while(rs.next()){
            utenti.add(new Utente(
            rs.getInt("id"),
            rs.getString("username"),
            rs.getString("password"),
            rs.getString("ruolo"),
                            ));

        } catch (SQLException e){
            e.printStackTrace();
        }
    return utenti;
    }

public boolean autentica(String username, String password) {
       String sql = "SELECT * FROM utenti WHERE username = ? AND password = ?";

       try(Connection conn = connessioneDb.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setString(1,username);
        ps.setString(2,password);
        ResultSet rs = ps.executeQuery();

      return rs.next();

        } catch (SQLException e){
          e.printStackTrace();
        }
return false;
}
}
