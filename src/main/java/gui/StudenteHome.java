package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudenteHome {
    private JButton elencoDocentiButton;
    private JButton compilaRichiestaDiTirocinioButton;
    private JButton visualizzaStatoRichiestaTirocinioButton;
    private JButton caricaTesiButton;
    private JButton prenotaSedutaButton;

    public StudenteHome() {

        elencoDocentiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // LISTENER RIFERITO AL BOTTONE PER APRIRE LA FINESTRA DELL'ELENCO DEI DOCENTI
            }
        });
        compilaRichiestaDiTirocinioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // LISTENER RIFERITO AL BOTTONE PER APRIRE LA FINESTRA PER COMPILARE LA RICHIESTA DI TIROCINIO
            }
        });
        visualizzaStatoRichiestaTirocinioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // LISTENER RIFERITO AL BOTTONE PER APRIRE LA FINESTRA PER VISUALIZZARE LO STATO DELLA RICHIESTA DEL TIROCINIO
            }
        });
        caricaTesiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // LISTENER RIFERITO AL BOTTONE PER CARICARE IL FILE DELLA TESI
            }
        });
        prenotaSedutaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // LISTENER RIFERITO AL BOTTONE PER APRIRE LA FINESTRA PER PRENOTARE LA SEDUTA DI LAUREA
            }
        });
    }
}
