package gui;

import java.text.SimpleDateFormat;
import java.util.Date;

public class volo {

    private int id;
    private String destinazione;
    private Date dataPartenza;
    private StatoDelVolo stato;
    private Date dataArrivo;
    private int ritardo;

    public volo(String codice, String compagniaAerea, String origine, String destinazione, String orarioPrevisto, StatoDelVolo stato, String data, int ritardo ){

        this.id = id;
        this.destinazione = destinazione;
        this.dataPartenza = dataPartenza;
        this.dataArrivo = dataArrivo;
        this.ritardo = ritardo;

    }
    public int getId(){
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getDestinazione(){return destinazione;}

    public void setDestinazione(String destinazione) {
        this.destinazione = destinazione;
    }

    public Date getDataPartenza(){return dataPartenza;}

    public void setDataPartenza(Date dataPartenza) {this.dataPartenza = dataPartenza;}



    public Date getDataArrivo(){ return dataArrivo;}

    public void setDataArrivo(String data) {
        this.dataArrivo = dataArrivo;
    }

    public void getStato(){}

    public void setStato(StatoDelVolo stato) {
        this.stato = stato;
    }

    public void getRitardo(){}

    public void setRitardo(int ritardo) {
            this.ritardo = ritardo;
    }


    @Override
    public String toString() {
        if (destinazione == null || dataPartenza == null) {
            return "Volo non trovato";
        }
        return destinazione + " " + new SimpleDateFormat("dd/MM/yyyy").format(dataPartenza);
    }


}
