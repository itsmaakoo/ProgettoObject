package gui;

import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import model.volo;

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
        JSpinner dataPartenzaSpinner = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor dataPartenzaEditor = new JSpinner.DateEditor(dataPartenzaSpinner, "dd/MM/yyyy HH:mm");
        dataPartenzaSpinner.setEditor(dataPartenzaEditor);
        c.gridx = 0;
        c.gridy = 1;
        panel1.add(dataPartenza, c);
        c.gridx = 1;
        panel1.add(dataPartenzaSpinner, c);


        JLabel dataArrivo = new JLabel("Data e orario arrivo destinazione");
        JSpinner dataArrivoSpinner = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor dataArrivoEditor = new JSpinner.DateEditor(dataArrivoSpinner, "dd-MM-yyyy HH:mm");
        dataArrivoSpinner.setEditor(dataArrivoEditor);
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
            Date partenza=(Date)dataPartenzaSpinner.getValue();
            Date arrivo=(Date)dataArrivoSpinner.getValue();

            if(arrivo.before(partenza)){
                JOptionPane.showMessageDialog(this, "Errore: la data di arrivo è prima della partenza", "Error", JOptionPane.ERROR_MESSAGE);
            }

            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
            volo nuovoVolo = new volo(destinazione, partenza, arrivo, "in orario ", "");
            volo.archivio.add(nuovoVolo);
            JOptionPane.showMessageDialog(this, "Volo inserito  " + nuovoVolo);
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