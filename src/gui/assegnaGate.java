package gui;

import model.volo;

import javax.swing.*;
import java.awt.*;

public class assegnaGate extends JFrame {
    public assegnaGate() {
        setTitle("Assegna Gate");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(10, 10, 10, 10);
        c.fill = GridBagConstraints.HORIZONTAL;

        JLabel voloLabel = new JLabel("Seleziona volo");
        JComboBox<volo> voloJComboBox = new JComboBox<>(volo.archivio.toArray(new volo[0]));
        c.gridx = 0;
        c.gridy = 0;
        panel.add(voloLabel, c);
        c.gridx = 1;
        panel.add(voloJComboBox, c);

        //campo gate
        JLabel gateLabel = new JLabel("Seleziona gate");
        JTextField gateJTextField = new JTextField(10);
        c.gridx = 0;
        c.gridy = 1;
        panel.add(gateLabel, c);
        c.gridx = 1;
        panel.add(gateJTextField, c);

        //bottone conferma
        JButton confermaButton = new JButton("Assegna Gate");
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 2;
        panel.add(confermaButton, c);

        confermaButton.addActionListener(e -> {
            volo volo = (volo) voloJComboBox.getSelectedItem();
            String gate = gateJTextField.getText();

            if(volo != null && !gate.isEmpty()){

                JOptionPane.showMessageDialog(this, "Assegna gate: " +gate + "al volo" + volo.getDestinazione());


            }else{
                JOptionPane.showMessageDialog(this, "Assegna gate: Non trovato");
            }
        });
        add(panel);
        setVisible(true);


    }
}
