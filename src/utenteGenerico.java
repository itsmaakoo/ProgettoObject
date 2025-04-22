public class utenteGenerico {
    private String nome;
    private String cognome;
    private String codiceFiscale;


    public utenteGenerico(String nome, String cognome, String codiceFiscale){  //funzione per "creare" l'oggetto
        this.nome = nome;
        this.cognome = cognome;
        this.codiceFiscale = codiceFiscale;
}

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setcodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public void prenotaVolo(volo volo) {
        System.out.println("volo" + volo.getCodice());
    }

    public void cercaPrenotazione(volo volo) {
        System.out.println("volo" + volo.getCodice());
    }

    public void segnalaBagaglio(volo volo) {
        System.out.println("volo" + volo.getCodice());
    }
}


