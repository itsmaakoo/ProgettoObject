package gui;

import model.volo;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class ModificaVolo extends JFrame {
    private JComboBox<volo> voloJComboBox;
    private JButton confermaButton;
    private JComboBox<String> statoBox;


    public ModificaVolo() {

        setTitle("Modifica Volo");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(3,2,10,10));

        voloJComboBox = new JComboBox<>(volo.archivio.toArray(new volo[0]));
        statoBox= new JComboBox<>(new String[]{"In Orario","In ritardo","Cancellato"});
        confermaButton = new JButton("Conferma");

        add(new JLabel("Seleziona volo:"));
        add(voloJComboBox);
        add(new JLabel("Seleziona stato:"));
        add(statoBox);
        add(new JLabel());
        add(confermaButton);



        confermaButton.addActionListener(e->{
            volo voloSelezionato = (volo)voloJComboBox.getSelectedItem();
            if (voloSelezionato != null) {
                voloSelezionato.setStato((String) statoBox.getSelectedItem());
                JOptionPane.showMessageDialog(this, "Stato Aggiornato"+voloSelezionato);
            }
        });

        setVisible(true);

    }
    public static void main(String[] args) {
        new Amministratore();
    }
}
