package model;

public class prenotazione {
    private int num_biglietto;
    private int passeggeroId;
    private String documento;
    private int voloId;
    private int prenotazioneId;
    private String stato_prenotazione;

    public prenotazione(int num_biglietto, int passeggeroId, String documento, int voloId, int prenotazioneId, String stato_prenotazione) {
        this.num_biglietto = num_biglietto;
        this.passeggeroId = passeggeroId;
        this.documento = documento;
        this.voloId = voloId;
        this.prenotazioneId = prenotazioneId;
        this.stato_prenotazione = stato_prenotazione;
    }

    public int getNum_biglietto() {
        return num_biglietto;
    }
    public void setNum_biglietto(int num_biglietto) {
        this.num_biglietto = num_biglietto;
    }
    public int getPasseggeroId() {
        return passeggeroId;
    }
    public void setPasseggeroId(int passeggeroId) {
        this.passeggeroId = passeggeroId;
    }
    public String getDocumento() {
        return documento;
    }
    public void setDocumento(String documento) {
        this.documento = documento;
    }
    public int getVoloId() {
        return voloId;
    }
    public void setVoloId(int voloId) {
        this.voloId = voloId;
    }
    public int getPrenotazioneId() {
        return prenotazioneId;
    }
    public void setPrenotazioneId(int prenotazioneId) {
        this.prenotazioneId = prenotazioneId;
    }
    public String getStato_prenotazione() {
        return stato_prenotazione;
    }
    public void setStato_prenotazione(String stato_prenotazione) {
        this.stato_prenotazione = stato_prenotazione;
    }

    public String toString() {
        String stringa = "\nbiglietto: "+ num_biglietto +" \nposto_assegnato: " + " \nstato_prenotazione: "+ stato_prenotazione;
        return stringa;
    }
    public void checkin(){
    }
}
