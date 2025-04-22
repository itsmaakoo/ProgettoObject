package org.example;

public class bagaglio {
    private int codice;
    private stato_bagaglio stato;

    bagaglio(int codice, String stato) {
        this.codice = codice;
    }
    public int getCodice() {
        return codice;
    }

    public void setCodice(int codice) {
        this.codice = codice;
    }

    public String toString() {
        String stringa = "\ncodice: " + codice + "\nstato: " + stato;
        return stringa;
    }
}
