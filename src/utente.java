package org.example;

public class utente {
    private String login;
    private String password;

    //costrutto per creare l'oggetto
    utente(String login, String password) {
        this.login = login;
        this.password = password;
    }

    //get, funzione per scegliere il valore
    public String getLogin(){
        return login;
    }
    public String getPassword(){
        return password;
    }

    //set, funzione per settare il valore
    public void setLogin(String login) {
        this.login = login;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String toString(){
        String stringa = "Login: " + login + "\nPassword: " + password;
        return stringa;
    }
    public void visualizza_voli(){
    }
}
