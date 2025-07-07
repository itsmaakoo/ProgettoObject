package gui;

import model.Bagaglio;
import model.volo;
import model.stato_bagaglio;

import javax.swing.*;
import java.awt.*;

public class bagaglioSmarrito extends JFrame {
    private JComboBox<volo> voloJComboBox;
    private JComboBox<Bagaglio> bagaglioJComboBox;
    private JButton segnalaBagaglioButton;

    public bagaglioSmarrito() {
        setTitle("segnala bagaglio smarrito");
        setSize(400, 300);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(3,2,10,10));

        voloJComboBox = new JComboBox<>(volo.archivio.toArray(new volo[0]));
        bagaglioJComboBox=new JComboBox<>();
        segnalaBagaglioButton=new JButton("segnala bagaglio");

        add(new JLabel("Seleziona Volo"));
        add(voloJComboBox);
        add(new JLabel("Seleziona bagaglio"));
        add(bagaglioJComboBox);
        add(new JLabel());
        add(segnalaBagaglioButton);

        voloJComboBox.addActionListener(e->{
            volo v = (volo)voloJComboBox.getSelectedItem();
            bagaglioJComboBox.removeAllItems();
            if(v != null){
                for(Bagaglio b : v.getBagagli()){
                    bagaglioJComboBox.addItem(b);
                }
            }
        });

        segnalaBagaglioButton.addActionListener(e->{
            Bagaglio b = (Bagaglio) bagaglioJComboBox.getSelectedItem();
            if(b != null){
                b.setStato(stato_bagaglio.smarrito);
                JOptionPane.showMessageDialog(this, "segnala bagaglio come smarrito");

            }
        });
        setVisible(true);
    }
}