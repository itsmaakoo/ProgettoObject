package controller;

import gui.UtenteGenericoPanel;
import gui.UtenteLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class LoginUtenteController {

    private UtenteLogin login_frame;

    public LoginUtenteController(UtenteLogin login_frame) {
        this.login_frame = login_frame;

        this.login_frame.getLoginButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleLogin();
            }
        });
    }
    private void handleLogin() {
        String username = login_frame.getUsernameField().getText().trim();
        String password = new String(login_frame.getPasswordField().getPassword()).trim();

        System.out.println("username: " + username);
        System.out.println("password: " + password);

        if(username.isEmpty()){
            JOptionPane.showMessageDialog(login_frame, "Inserisci nome utente!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!password.matches(".*[0-9].*")) {
            JOptionPane.showMessageDialog(login_frame, "La password deve contenere almeno un numero!", "Welcome", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        JOptionPane.showMessageDialog(login_frame, "Benvenuto "+ username, "Accesso riuscito!", JOptionPane.ERROR_MESSAGE);
        new UtenteGenericoPanel().setVisible(true);
        login_frame.setVisible(false);
        login_frame.dispose();
    }
}
