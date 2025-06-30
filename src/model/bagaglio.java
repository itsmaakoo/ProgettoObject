package model;

public class bagaglio {
    private  int codice;
    private stato_bagaglio stato;

   public bagaglio(int codice, stato_bagaglio stato) {

        this.codice = codice;
        this.stato = stato;
    }
    public  int getCodice() {
        return codice;
    }

    public void setCodice(int codice) {

       this.codice = codice;
    }

    public stato_bagaglio getStato() {
       return stato;
    }

    public void setStato(stato_bagaglio stato) {
       this.stato = stato;
    }

    @Override
    public String toString() {
        return  "\ncodice: " + codice + "\nstato: " + stato;

    }
}
