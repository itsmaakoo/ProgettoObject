package controller;
import gui.mainFrame;

public class Controller{

    private mainFrame mainFrame;
    public Controller(mainFrame mainFrame){
        this.mainFrame = mainFrame;
    }

    public void login(String username, String password){

        if(username.equals("admin") && password.equals("<PASSWORD>")){
            mainFrame.showPanel(new String[]{"admin"});
        } else if(username.equals("utente") && password.equals("<PASSWORD>")){
            mainFrame.showPanel(new String[]{"user"});
        } else {
            System.out.println("Credenziali non valide");
        }

        }
    public void prenotaVolo(String codiceVolo){
    }

    public void statoVolo(String codiceVolo){

    }

    public void segnalaBagaglioSmarrito(String codiceVolo){

    }

    public void assegnaGate(String codiceVolo){

    }

    public void assegnaBagaglio(String codiceVolo){

    }

    public void visualizzaSmarrimenti(){

    }

    public void logout(){

    }
}
