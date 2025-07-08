package dao;

import db.connessioneDb;
import model.Passeggero;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class passeggeroDAO {
    private Connection connessione;

    public passeggeroDAO(Connection connessione) {
        this.connessione = connessione;
    }
    public void salvaPasseggero(Passeggero passeggero) throws SQLException{
        String sql = "INSERT INTO passeggeri (nome, cognome, codiceFiscale) VALUES (?,?,?)";
        try(PreparedStatement stmt = connessione.prepareStatement(sql)){
            stmt.setString(1, passeggero.getNome());
            stmt.setString(2, passeggero.getCognome());
            stmt.setString(3, passeggero.getCodiceFiscale());
            stmt.executeUpdate();
        }
    }
    public Passeggero trovaPerCodiceFiscale(String codiceFiscale ) throws SQLException{
        String sql = "SELECT * FROM passeggeri WHERE codiceFiscale = ?";
        try(PreparedStatement stmt = connessione.prepareStatement(sql)){
            stmt.setString(1, codiceFiscale);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                return new Passeggero(
                        rs.getString("nome"),
                        rs.getString("cognome"),
                        rs.getString("codiceFiscale")
                );
            }
        }
        return null;
    }
    public List<Passeggero> trovaListaPasseggero() throws SQLException{
        List<Passeggero> listaPasseggero = new ArrayList<>();
        String sql = "SELECT * FROM passeggeri";
        try(PreparedStatement stmt = connessione.prepareStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                listaPasseggero.add(new Passeggero(
                        rs.getString("nome"),
                        rs.getString("cognome"),
                        rs.getString("codiceFiscale")
                ));
            }
        }
        return listaPasseggero;
    }
    public void aggiornaPasseggero(Passeggero passeggero) throws SQLException{
        String sql = "UPDATE passeggeri SET nome=?, cognome=?, WHERE codiceFiscale=?";
        try(PreparedStatement stmt = connessione.prepareStatement(sql)){
            stmt.setString(1, passeggero.getNome());
            stmt.setString(2, passeggero.getCognome());
            stmt.setString(3, passeggero.getCodiceFiscale());
            stmt.executeUpdate();
        }
    }
    public void eliminaPasseggero(String codiceFiscale) throws SQLException{
        String sql = "DELETE FROM passeggeri WHERE codiceFiscale = ?";
        try(PreparedStatement stmt = connessione.prepareStatement(sql)){
            stmt.setString(1, codiceFiscale);
            stmt.executeUpdate();
        }
    }
}
