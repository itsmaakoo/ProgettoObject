package model;

public class volo {

    private String codice;
    private String compagniaAerea;
    private String origine;
    private String destinazione;
    private String orarioPrevisto;
    private StatoDelVolo stato;
    private String data;
    private int ritardo;

    public volo(String codice, String compagniaAerea, String origine, String destinazione, String orarioPrevisto, StatoDelVolo stato, String data, int ritardo ){
        this.codice = codice;
        this.compagniaAerea = compagniaAerea;
        this.origine = origine;
        this.destinazione = destinazione;
        this.orarioPrevisto = orarioPrevisto;
        this.stato = stato;
        this.data = data;
        this.ritardo = ritardo;

    }
    public String getCodice(){
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }


    public void getCompagniaAerea(){}

    public void setCompagniaAerea(String compagniaAerea) {
        this.compagniaAerea = compagniaAerea;
    }

    public void getOrigine(){}

    public void setOrigine(String origine) {
        this.origine = origine;
    }

    public void getDestinazione(){}

    public void setDestinazione(String destinazione) {
        this.destinazione = destinazione;
    }

    public void getOrarioPrevisto(){}

    public void setOrarioPrevisto(String orarioPrevisto) {
        this.orarioPrevisto = orarioPrevisto;
    }

    public void getStato(){}

    public void setStato(StatoDelVolo stato) {
        this.stato = stato;
    }

    public void getData(){}

    public void setData(String data) {
        this.data = data;
    }

    public void getRitardo(){}

    public void setRitardo(int ritardo) {
            this.ritardo = ritardo;
    }


    public String getNumero() {
        return "";
    }
    public void setNumero(String numero) {}
}
