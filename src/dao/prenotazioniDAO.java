package dao;

import db.connessioneDb;
import model.prenotazione;
import org.postgresql.core.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class prenotazioniDAO {

    public void salvaPrenotazione(prenotazione p){
        String sql = "INSERT INTO prenotazioni(nome, cognome, stato, numBiglietto, voloId) VALUES(?,?,?,?,?)";
        try(Connection connessione = connessioneDb.getConnection();
            PreparedStatement stmt = connessione.prepareStatement(sql)){

            // i vari get (getCognome....) devono essere aggiunti nel passeggero model
            stmt.setString(1, p.getConnection());
            stmt.setString(2, p.getCogmome());
            stmt.setInt(3, p.getStato_prenotazione());
            stmt.setInt(3, getnumBiglietto());
            stmt.setInt(4, getvoloID());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public List<prenotazione> getListaPrenotazioni(){
        List<prenotazione> lista = new ArrayList<prenotazione>();
        String sql = "SELECT * FROM prenotazioni";

        try(Connection connessione = connessioneDb.getConnection();
            Statement stmt = connessione.createStatement();
            ResultSet rs = stmt.executeQuery(sql));{

            while(rs.next()){
                prenotazione p = new prenotazione(
                        rs.getString ("nome"),
                        rs.getString ("cognome"),
                        rs.getInt ("stato_prenotazione"),
                        rs.getInt ("numBiglietto"),
                        rs.getInt ("voloID")

                );
                p.setId(rs.getInt("id"));
                lista.add(p);
            }

        }catch (SQLException e){
            e.printStackTrace();

        }
        return lista;
    }
}
