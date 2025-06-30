package gui;

import model.volo;

import javax.swing.*;
import java.awt.*;

public class aggiungiBagaglio extends JFrame {

    private JComboBox<volo> voloJComboBox;
    private JTextField campoBagaglio;
    private JButton confermaButton;

    public aggiungiBagaglio() {
        setTitle("Aggiungi bagaglio");
        setSize(400,200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(3, 2, 10, 10));

        voloJComboBox = new JComboBox<>(volo.archivio.toArray(new volo[0]));
        campoBagaglio = new JTextField();
        confermaButton = new JButton("Aggiungi");

        add(new JLabel("Seleziona Volo: "));
        add(voloJComboBox);
        add(new JLabel("Seleziona bagaglio: "));
        add(campoBagaglio);
        add(new JLabel());
        add(confermaButton);

        confermaButton.addActionListener(e -> {
            volo selezionato = (volo) voloJComboBox.getSelectedItem();
            String bagaglio = campoBagaglio.getText().trim();

            if(selezionato !=null && !bagaglio.isEmpty()) {

            }
        });
    }
}
