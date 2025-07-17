package dao;

import db.connessioneDb;
import model.prenotazione;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class prenotazioniDAO {

    public prenotazioniDAO(Connection conn) {
    }

    public void salvaPrenotazione(prenotazione p){
        String sql = "INSERT INTO prenotazioni(num_biglietto, passeggeroId, documento, voloId, prenotazioneId, stato_prenotazione) VALUES(?,?,?,?,?,?)";
        try(Connection connessione = connessioneDb.getConnection();
            PreparedStatement stmt = connessione.prepareStatement(sql)){

            // i vari get (getCognome....) devono essere aggiunti nel passeggero model
            stmt.setInt(1, p.getNum_biglietto());
            stmt.setInt(2, p.getPasseggeroId());
            stmt.setString(3, p.getDocumento());
            stmt.setInt(4, p.getVoloId());
            stmt.setInt(5, p.getPrenotazioneId());
            stmt.setString(6, p.getStato_prenotazione());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<prenotazione> trovaPrenotazioni() throws SQLException {
        List<prenotazione> lista = new ArrayList<prenotazione>();
        String sql = "SELECT * FROM prenotazioni";

        try(Connection connessione = connessioneDb.getConnection();
            Statement stmt = connessione.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){

            while(rs.next()){
                prenotazione p = new prenotazione(
                        rs.getInt ("num_biglietto"),
                        rs.getInt ("passeggeroId"),
                        rs.getString("documento"),
                        rs.getInt ("voloId"),
                        rs.getInt ("prenotazioneId"),
                        rs.getString("stato_prenotazione")
                );
                lista.add(p);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return lista;
    }
    public List<prenotazione> trovaPrenotazioniPerVolo(int Id) throws SQLException {
        List<prenotazione> lista = new ArrayList<prenotazione>();
        String sql = "SELECT * FROM prenotazioni WHERE voloId=?";

        try (Connection connessione = connessioneDb.getConnection();
             PreparedStatement stmt = connessione.prepareStatement(sql)) {
            stmt.setInt(1, Id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                prenotazione p = new prenotazione(
                        rs.getInt("num_biglietto"),
                        rs.getInt("passeggeroId"),
                        rs.getString("documento"),
                        rs.getInt("voloId"),
                        rs.getInt("prenotazioneId"),
                        rs.getString("stato_prenotazione")
                );
                lista.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}

