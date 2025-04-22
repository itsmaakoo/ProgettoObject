public class passeggero {

    private String nome;
    private String cognome;
    private String numDoc;

    public passeggero(String nome, String cognome, String numDoc){

        this.nome = nome;
        this.cognome = cognome;
        this.numDoc = numDoc;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCognome() {
        return cognome;
    }
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    public String getNumDoc() {
        return numDoc;
    }
    public void setNumDoc(String numDoc) {
        this.numDoc = numDoc;
    }

}
