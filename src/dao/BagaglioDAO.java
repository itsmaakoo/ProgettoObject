package dao;

import db.connessioneDb;
import model.Bagaglio;
import model.stato_bagaglio;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static javax.swing.UIManager.getString;

public class BagaglioDAO {
    private Connection connessione;

    public BagaglioDAO(Connection connessione){
        this.connessione = connessione;
    }
    public void add(Bagaglio b, int prenotazioneId) throws SQLException{
        String sql = "INSERT INTO bagagli (codiceTracciamento, prenotazioneId, stato, note) VALUES (?,?,?,?)";
        try(PreparedStatement stmt = connessione.prepareStatement(sql)){
            stmt.setInt(1, b.getCodice());
            stmt.setInt(2, prenotazioneId);
            stmt.setString(3, b.getStato().name());
            stmt.setString(4, b.getDescrizione());
            stmt.executeUpdate();
        }
    }
    public List<Bagaglio> trovaBagagliPerPrenotazione(int prenotazioneId) throws SQLException{
        List<Bagaglio> bagagli = new ArrayList<>();
        String sql = "SELECT * FROM bagagli WHERE prenotazioneId = ?";
        try(PreparedStatement stmt = connessione.prepareStatement(sql)){
            stmt.setInt(1, prenotazioneId);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Bagaglio b = new Bagaglio(
                        rs.getInt("codiceTracciamento"),
                        rs.getString("note")
                );
                b.setStato(stato_bagaglio.valueOf(rs.getString("stato")));
                bagagli.add(b);
            }
        }
        return bagagli;
    }
    public void aggiornaStatoBagaglio(String codiceTracciamento, stato_bagaglio nuovoStato) throws SQLException{
        String sql = "UPDATE stato SET stato = ? WHERE codiceTracciamento = ?";
        try(PreparedStatement stmt = connessione.prepareStatement(sql)){
            stmt.setString(1, nuovoStato.name());
            stmt.setString(2, codiceTracciamento);
            stmt.executeUpdate();
        }
    }
    public void eliminaBagaglio(int codiceTracciamento) throws SQLException{
        String sql = "DELETE FROM bagagli WHERE codiceTracciamento = ?";
        try(PreparedStatement stmt = connessione.prepareStatement(sql)){
            stmt.setInt(1, codiceTracciamento);
            stmt.executeUpdate();
        }
    }
    public Bagaglio trovaCodice(int codiceTracciamento) throws SQLException{
        String sql = "SELECT * FROM bagagli WHERE codiceTracciamento = ?";
        try(PreparedStatement stmt = connessione.prepareStatement(sql)){
            stmt.setInt(1, codiceTracciamento);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                Bagaglio b = new Bagaglio(
                        rs.getInt("codiceTraccaimento"),
                        rs.getString("note")
                );
                b.setStato(stato_bagaglio.valueOf(rs.getString("stato")));
                return b;
            }
        }
        return null;
    }
}
