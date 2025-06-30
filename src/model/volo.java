package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class volo {

    private String destinazione;
    private Date dataPartenza;
    private Date dataArrivo;
    private String stato;
    private String gate;

    private List<bagaglio> b = new ArrayList<bagaglio>();

    public void aggiungiBagaglio(bagaglio bagaglio) {
        b.add(bagaglio);
    }


    public volo( String destinazione,Date dataPartenza, Date dataArrivo, String stato, String gate ) {

        this.destinazione = destinazione;
        this.dataPartenza = dataPartenza;
        this.dataArrivo = dataArrivo;
        this.stato = stato;
        this.gate = gate;



    }

    public String getDestinazione(){return destinazione;}

    public void setDestinazione(String destinazione) {
        this.destinazione = destinazione;
    }

    public Date getDataPartenza(){return dataPartenza;}

    public void setDataPartenza(Date dataPartenza) {this.dataPartenza = dataPartenza;}

    public Date getDataArrivo(){ return dataArrivo;}

    public void setDataArrivo(Date dataArrivo) {
        this.dataArrivo = dataArrivo;
    }

    public String getStato(){return stato;}

    public void setStato(String stato) {this.stato = stato;}

    public String getGate(){return gate;}
    public void setGate(String gate) {this.gate = gate;}
    
    @Override
    public String toString() {
        return destinazione + " " + new SimpleDateFormat("dd/MM/yyyy").format(dataPartenza) + "Stato: " +stato;
        }
       public static java.util.List<volo> archivio= new java.util.ArrayList<>();



    // DA MODIFICARE PERCHè SE TOLGO MI DA ERRORE
    public String getCodice() {
        return null;
    }

    public String getNumero() {
        return null;
    }
}



