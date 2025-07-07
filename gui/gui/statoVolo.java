package gui;

import model.volo;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class statoVolo extends JFrame {
    public statoVolo() {
        setTitle("Stato del Volo");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());
        DefaultListModel<volo> model = new DefaultListModel<>();
        List<volo> voli = volo.archivio;
        for(volo volo : voli) {
            model.addElement(volo);
        }
        JList<volo> lista= new JList<>(model);
        JScrollPane scrollPane = new JScrollPane(lista);
        panel.add(scrollPane, BorderLayout.CENTER);
        add(panel);
        setVisible(true);
    }
}