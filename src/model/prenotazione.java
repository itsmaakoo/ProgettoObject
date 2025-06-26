package model;

public class prenotazione {
    private int num_biglietto;
    private String posto_assegnato;
    private String stato_prenotazione;

    prenotazione(int num_biglietto, String posto_assegnato, String stato_prenotazione) {
        this.num_biglietto = num_biglietto;
        this.posto_assegnato = posto_assegnato;
        this.stato_prenotazione = stato_prenotazione;
    }

    public static String getBiglietto() {
        return null;
    }

    public int getNum_biglietto() {
        return num_biglietto;
    }
    public String getPosto_assegnato() {
        return posto_assegnato;
    }
    public String getStato_prenotazione() {
        return stato_prenotazione;
    }

    public void setNum_biglietto(int num_biglietto) {
        this.num_biglietto = num_biglietto;
    }
    public void setPosto_assegnato(String posto_assegnato) {
        this.posto_assegnato = posto_assegnato;
    }
    public void setStato_prenotazione(String stato_prenotazione) {
        this.stato_prenotazione = stato_prenotazione;
    }

    public String toString() {
        String stringa = "\nbiglietto: "+ num_biglietto +" \nposto_assegnato: "+ posto_assegnato + " \nstato_prenotazione: "+ stato_prenotazione;
        return stringa;
    }
    public void checkin(){
    }
}
