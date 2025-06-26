package gui;

import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;

//DA AGGIUNGERE IL CONTROLLO SULLE DATE

public class InserisciVolo extends JFrame {
    public InserisciVolo() {
        JPanel panel1;
        setTitle("Inserisci il volo");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        panel1 = new JPanel(new GridBagLayout());
        panel1.setBackground(Color.WHITE);
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(10, 10, 10, 10);
        c.fill = GridBagConstraints.HORIZONTAL;

        JLabel destinazioneLabel= new JLabel("Destinazione");
        JTextField destinazioneField = new JTextField(15);
        c.gridx = 0;
        c.gridy = 0;
        panel1.add(destinazioneLabel, c);
        c.gridx = 1;
        panel1.add(destinazioneField, c);

        JLabel dataPartenza = new JLabel("Data e orario partenza");
        JSpinner dataPSpinner = new JSpinner(new SpinnerDateModel());
        JSpinner dataPartenzaSpinner = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor dataPEditor = new JSpinner.DateEditor(dataPSpinner, "dd-MM-yyyy");
        dataPSpinner.setEditor(dataPEditor);
        c.gridx = 0;
        c.gridy = 1;
        panel1.add(dataPartenza, c);
        c.gridx = 1;
        panel1.add(dataPartenzaSpinner, c);


        JLabel dataArrivo = new JLabel("Data e orario arrivo destinazione");
        JSpinner dataASpinner = new JSpinner(new SpinnerDateModel());
        JSpinner dataArrivoSpinner = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor dataAEditor = new JSpinner.DateEditor(dataASpinner, "dd-MM-yyyy");
        dataASpinner.setEditor(dataAEditor);
        c.gridx = 0;
        c.gridy = 2;
        panel1.add(dataArrivo, c);
        c.gridx = 1;
        panel1.add(dataArrivoSpinner, c);

        JButton confermaButton = new JButton("Inserisci Volo");
        confermaButton.setForeground(Color.BLACK);

        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 2;
        c.anchor = GridBagConstraints.CENTER;
        panel1.add(confermaButton, c);


        confermaButton.addActionListener(e -> {
            String destinazione =destinazioneField.getText();
            Date partenza=(Date)dataPSpinner.getValue();
            Date arrivo=(Date)dataPartenzaSpinner.getValue();

            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

            String messaggio = "Destinazione:"+destinazione +"\n"
                    + "Data da parte: "+formatter.format(partenza)+"\n"
                    + "Data da arrivo: "+formatter.format(arrivo)+"\n";

            JOptionPane.showMessageDialog(this, messaggio);
            dispose();
        });
        add(panel1);
        setVisible(true);

    }
    public static void main(String[] args) {
        new Amministratore();
    }
}
