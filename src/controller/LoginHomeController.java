package controller;

import gui.HomePage;
import gui.UtenteLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginHomeController {
    private HomePage homePage;

    public LoginHomeController(HomePage home) {
        this.homePage = home;

        this.homePage.getLoginUtenteButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                apriLoginUtente();
            }
        });
       // this.homePage.getLoginAdminButton().addActionListener(new ActionListener(){
           // @Override
           // public void actionPerformed(ActionEvent e) {
        // apriLoginAdmin();
    }
       // });
   // }
    private void apriLoginUtente() {
        UtenteLogin utenteLogin = new UtenteLogin();
        new LoginUtenteController(utenteLogin);
        homePage.setVisible(false);
        homePage.dispose();
    }

    // qui bisogna aggiungere apriLoginAdmin, una volta creata l'interfaccia amministratore.
}
