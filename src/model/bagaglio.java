package model;

public class Bagaglio {
    private int prenotazioneId;
    private  int codice;
    private stato_bagaglio stato;
    private String descrizione;

    public Bagaglio(int prenotazioneId, int codice, String descrizione) {
        this.prenotazioneId = prenotazioneId;
        this.codice = codice;
        this.stato = stato_bagaglio.registrato;
        this.descrizione = descrizione;
    }

    public int getPrenotazioneId() {
        return prenotazioneId;
    }
    public void setPrenotazioneId(int prenotazioneId) {
        this.prenotazioneId = prenotazioneId;
    }

    public  int getCodice() {
        return codice;
    }

    public void setCodice(int codice) {

        this.codice = codice;
    }
    public String getDescrizione() {
        return descrizione;
    }
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public stato_bagaglio getStato() {
        return stato;
    }

    public void setStato(stato_bagaglio stato) {
        this.stato = stato;
    }

    @Override
    public String toString() {
        return  "\ncodice: " + codice + "\nstato: " + stato + "\ndescrizione: " + descrizione;

    }
}