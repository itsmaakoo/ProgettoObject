package gui;

import model.volo;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class PrenotaVolo extends JFrame {

    public PrenotaVolo() {
        setTitle("Prenota Volo");
        setSize(500,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());

        DefaultListModel<volo> model = new DefaultListModel<>();
        List<volo> voli= volo.archivio;
        for(volo v : voli){
            model.addElement(v);
        }

        JList<volo> listaVoli= new JList<>(model);
        listaVoli.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(listaVoli);

        JButton checkInButton = new JButton(" Effettua check in");
        checkInButton.addActionListener(e -> {
           volo selezionato = listaVoli.getSelectedValue();
           if(selezionato != null){
               JOptionPane.showMessageDialog(this, "Check-in effettuato per: " + selezionato.getDestinazione());

           }else{
               JOptionPane.showMessageDialog(this, "Seleziona Volo!! ");

           }
        });
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(checkInButton, BorderLayout.SOUTH);

        add(panel);
        setVisible(true);
    }
}
