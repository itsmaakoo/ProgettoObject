package gui;

import javax.swing.*;
import java.awt.*;
import model.volo;

public class assegnaGate extends JFrame {
    public assegnaGate() {
        setTitle("Assegna Gate");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(2, 2, 2, 2);
        c.fill = GridBagConstraints.HORIZONTAL;

        JLabel voloLabel = new JLabel("Seleziona volo");
        c.gridx = 0;
        c.gridy = 0;
        panel.add(voloLabel, c);

        JComboBox<volo> voloJComboBox = new JComboBox<>(volo.archivio.toArray(new volo[0]));
        c.gridx = 1;
        c.gridy = 0;
        c.gridwidth = 2;
        panel.add(voloJComboBox, c);

        //campo gate
        JLabel gateLabel = new JLabel("Seleziona gate");
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        panel.add(gateLabel, c);

        JTextField gateJTextField = new JTextField(10);
        c.gridx = 1;
        c.gridy = 1;
        c.gridwidth = 2;
        panel.add(gateJTextField, c);

        //bottone conferma
        JButton confermaButton = new JButton("Assegna Gate");
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 3;
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
