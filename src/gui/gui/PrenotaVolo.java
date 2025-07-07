package gui;

import model.volo;
import model.Passeggero;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class PrenotaVolo extends JFrame {

    private JTextField nomeField, cognomeField, codiceFiscale;
    private JList<volo> listaVoli;

    public PrenotaVolo() {
        setTitle("Prenota Volo");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());

        JPanel formPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        nomeField = new JTextField();
        cognomeField = new JTextField();
        codiceFiscale = new JTextField();

        formPanel.add(new JLabel("Nome:"));
        formPanel.add(nomeField);
        formPanel.add(new JLabel("Cognome:"));
        formPanel.add(cognomeField);
        formPanel.add(new JLabel("CodiceFiscale:"));
        formPanel.add(codiceFiscale);

        panel.add(formPanel, BorderLayout.NORTH);


        DefaultListModel<volo> model = new DefaultListModel<>();
        List<volo> voli = volo.archivio;
        for (volo v : voli) {
            model.addElement(v);
        }

        listaVoli = new JList<>(model);
        listaVoli.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(listaVoli);
        panel.add(scrollPane, BorderLayout.CENTER);

        JButton checkInButton = new JButton(" Effettua check in");
        checkInButton.addActionListener(e -> prenota());
        panel.add(checkInButton, BorderLayout.SOUTH);

        add(panel);
        setVisible(true);
    }

    private void prenota(){
        volo selezionato = listaVoli.getSelectedValue();
        String nome = nomeField.getText().trim();
        String cognome = cognomeField.getText().trim();
        String cf = codiceFiscale.getText().trim();

        if(selezionato==null || nome.isEmpty() || cognome.isEmpty() || cf.isEmpty()) {
            JOptionPane.showMessageDialog(this, "compila tutti i campi");
        }
        Passeggero p = new Passeggero(nome, cognome, cf);

        JOptionPane.showMessageDialog(this, "Preonatazione effettuata" +nome +"sul volo per " +selezionato.getDestinazione());

        nomeField.setText("");
        cognomeField.setText("");
        codiceFiscale.setText("");



    }
}