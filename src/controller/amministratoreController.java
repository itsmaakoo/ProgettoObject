package controller;
import gui.Amministratore;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class amministratoreController {
    private final Amministratore view;

    public amministratoreController(Amministratore view){
        this.view = view;
        initController();
    }
    private  void initController() {
        view.getInserisciVolo().addActionListener(e->InserisciVolo());
        view.getAssegnaBagaglio().addActionListener(e->AssegnaVolo());
        view.getAssegnaGate().addActionListener(e->AssegnaGate());
        view.getAssegnaBagaglio().addActionListener(e->AssegnaGate());
        view.getVisualizzaSmarrimento().addActionListener(e->VisualizzaSmarrimento());

    }
    private void InserisciVolo() {
        JOptionPane.showMessageDialog(view, "Inserisci il volo");
    }
    private void ModificaVolo() {
        JOptionPane.showMessageDialog(view, "Modifica il volo");
    }
    private void AssegnaGate(){
        JOptionPane.showMessageDialog(view, "Assegna gate");
    }
    private void AssegnaVolo() {
        JOptionPane.showMessageDialog(view, "Assegna il volo");
    }
    private void VisualizzaSmarrimento() {
        JOptionPane.showMessageDialog(view, "Visualizza Smarrimento");
    }




}
