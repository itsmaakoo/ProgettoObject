public class Amministratore {
    private String login;
    private String password;

    public Amministratore(String login, String password) {
        this.login = login;
        this.password = password;
    }
    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public void inserisciVolo(volo volo){
        System.out.println("volo" + volo.getCodice() + "inserito");
    }
    public void modificaVolo(volo volo){
        System.out.println("volo" + volo.getCodice());
    }
    public void assegnaGate(volo volo){
        System.out.println("assegna gate" + volo.getNumero() + "al volo" + volo.getCodice());
    }
    public void assegnaBagaglio (volo volo){
        System.out.println("Bagaglio" + bagaglio.getCodice()+ "assegno alla prenotazione" + prenotazione.getBiglietto());

    }
    public void VisualizzaSmarrimento(volo volo){
        System.out.println("Visualizza Smarrimento");
    }
}
