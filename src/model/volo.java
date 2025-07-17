package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class volo {
    private int id;
    private String destinazione;
    private Date dataPartenza;
    private Date dataArrivo;
    private String stato;
    private String gate;

    public volo(int id, String destinazione, Date dataPartenza, Date dataArrivo, String stato, String gate) {
        this.id = id;
        this.destinazione = destinazione;
        this.dataPartenza = dataPartenza;
        this.dataArrivo = dataArrivo;
        this.stato = stato;
        this.gate = gate;
    }

    // costruttore senza id utile se si deve salvare un nuovo volo, e l'id lo genera il db.
    public volo(String destinazione, Date dataPartenza, Date dataArrivo, String stato, String gate) {
        this.destinazione = destinazione;
        this.dataPartenza = dataPartenza;
        this.dataArrivo = dataArrivo;
        this.stato = stato;
        this.gate = gate;
    }

    private List<Bagaglio> bagagli = new ArrayList<Bagaglio>();

    public void aggiungiBagaglio(Bagaglio b) {
        bagagli.add(b);
    }
    public List<Bagaglio> getBagagli() {
        return bagagli;
    }
    private List<Passeggero> passggeri = new ArrayList<>();

    public void aggiungiPasseggero(Passeggero p) {
        passggeri.add(p);
    }
    public List<Passeggero> getPassggeri() {
        return passggeri;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDestinazione() {
        return destinazione;
    }
    public void setDestinazione(String destinazione) {
        this.destinazione = destinazione;
    }
    public Date getDataPartenza() {
        return dataPartenza;
    }
    public void setDataPartenza(Date dataPartenza) {
        this.dataPartenza = dataPartenza;
    }
    public Date getDataArrivo() {
        return dataArrivo;
    }
    public void setDataArrivo(Date dataArrivo) {
        this.dataArrivo = dataArrivo;
    }
    public String getStato() {
        return stato;
    }
    public void setStato(String stato) {
        this.stato = stato;
    }
    public String getGate() {
        return gate;
    }
    public void setGate(String gate) {
        this.gate = gate;
    }
    @Override
    public String toString() {
        return destinazione + " " + new SimpleDateFormat("dd/MM/yyyy").format(dataPartenza) + "Stato: " + stato;
    }
    public static List<volo> archivio= new ArrayList<>();
}