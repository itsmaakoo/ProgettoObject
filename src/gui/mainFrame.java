package gui;

import controller.Controller;

import javax.swing.*;
import java.awt.*;

public class mainFrame extends JFrame{
    private CardLayout layout;
    private JPanel panel1;
    private Controller controller;


    public mainFrame(){
        super("Aereoporto Napoli");
        setSize(5, 5);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        layout = new CardLayout();
        panel1 = new JPanel(layout);

        controller = new Controller(this);

        LoginFrame loginPanel = new LoginFrame();
        UtenteGenericoPanel userPanel = new UtenteGenericoPanel();
        Amministratore adminPanel = new Amministratore();

        panel1.add(loginPanel, "Login");
        panel1.add(userPanel, "user");
        panel1.add(adminPanel, "admin");

        add(panel1);
        layout.show(panel1, "Login");

    }


    public void showPanel(String[] args) {
        layout.show(panel1, null); //CAMBIALO CAMBIARE CAMBIARLO
    }{
        //cardLayout.show(mainPanel, getName())
    }

    public void setvisible(boolean b) {
    }

    public void ErrorMessage(String messaggio){
        JOptionPane.showMessageDialog(this, messaggio, "Errore", JOptionPane.ERROR_MESSAGE);
    }
}

