package gui;

import javax.swing.*;
import java.awt.*;

public class UtenteLogin extends JFrame {

    private JPanel panel1;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JLabel username;
    private JLabel password;
    private JButton LButton;

    public UtenteLogin() {
        setTitle("Login");

        // ho modificato il colore dello sfondo, poi ho creato un oggetto c = new GBC(); dove GBC è una classe ausiliaria
        // usata come layout manager e contiene vari campi come gridx, gridy che possiamo modificare come vogliamo per poi aggiungere
        // tutto in panel1, il campo insets serve ad aggiungere padding attorno al componente.

        panel1 = new JPanel(new GridBagLayout());
        panel1.setBackground(Color.WHITE);
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(20, 20, 20, 20);


        // ho dato colore e font alla scritta username, ed ho deciso dove posizionarla in questo caso colonna 0 riga 0
        //poichè il GBL divide lo spazio in una griglia invisibile e ci permette di posizionare i componenti in modo preciso.

        username = new JLabel("Username:");
        username.setForeground(Color.BLACK);
        username.setFont(new Font("Arial", Font.BOLD, 16));
        c.gridx = 0;
        c.gridy = 0;
        panel1.add(username, c);

        // il 20 in parentesi significa che sta creando un campo di testo che può mostrare fino a 20 caratteri visibili senza scorrere
        // come sopra ho posizionato il campo nella propria colonna e riga.

        textField1 = new JTextField(20);
        c.gridx = 1;
        c.gridy = 0;
        panel1.add(textField1, c);

        // stessa cosa di username

        password = new JLabel("password:");
        password.setForeground(Color.BLACK);
        password.setFont(new Font("Arial", Font.BOLD, 16));
        c.gridx = 0;
        c.gridy = 1;
        panel1.add(password, c);

        // stessa cosa di textField1

        passwordField1 = new JPasswordField(20);
        c.gridx = 1;
        c.gridy = 1;
        panel1.add(passwordField1, c);

        // qui ho aggiunto gridwidth ci dice quante colonne deve occupare il bottone, e anchor va a centrare il componente
        // nell'area che occupa in questo caso il bottone è centrato ed occupa 2 colonne.

        LButton = new JButton("LOGIN");
        LButton.setBackground(Color.BLACK);
        c.gridx = 1;
        c.gridy = 2;
        c.gridwidth = 2;
        c.anchor = GridBagConstraints.CENTER;
        panel1.add(LButton, c);

        add(panel1);

        setSize(1150, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public JTextField getUsernameField(){
        return textField1;
    }

    public JPasswordField getPasswordField(){
        return passwordField1;
    }

    public JButton getLoginButton(){
        return LButton;
    }

    public static void main(String[] args) {

        new UtenteLogin();
    }
}