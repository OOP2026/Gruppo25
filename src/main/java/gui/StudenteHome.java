package gui;

import controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

;

public class StudenteHome {
    private JButton elencoDocentiButton;
    private JButton compilaRichiestaDiTirocinioButton;
    private JButton visualizzaStatoRichiestaTirocinioButton;
    private JButton caricaTesiButton;
    private JButton prenotaSedutaButton;
    private JPanel panelStudenteHome;
    private JButton indietroButton;
    private JFrame frame;
    private Controller controller;

    public StudenteHome(JFrame FrameChiamante, Controller controller) {
        this.controller = controller;
        frame = new JFrame("Home Studente");
        frame.setContentPane(panelStudenteHome);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null); //Questo metodo serve per far avviare la schermata al centro dello schermo.

        // Aggiungiamo un listener che si attiva quando la finestra cambia stato
        frame.addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentShown(java.awt.event.ComponentEvent e) {
                compilaRichiestaDiTirocinioButton.setEnabled(!controller.controlloRichiesta());
            }
        });


        elencoDocentiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // LISTENER RIFERITO AL BOTTONE PER APRIRE LA FINESTRA DELL'ELENCO DEI DOCENTI
                ElencoDocenti elencoDocenti = new ElencoDocenti(frame,controller);
                frame.setVisible(false);
            }
        });
        compilaRichiestaDiTirocinioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // LISTENER RIFERITO AL BOTTONE PER APRIRE LA FINESTRA PER COMPILARE LA RICHIESTA DI TIROCINIO
                MandaRichiestaTirocinio mandaRichiestaTirocinio = new MandaRichiestaTirocinio(frame,controller);
                frame.setVisible(false);
            }
        });
        visualizzaStatoRichiestaTirocinioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // LISTENER RIFERITO AL BOTTONE PER APRIRE LA FINESTRA PER VISUALIZZARE LO STATO DELLA RICHIESTA DEL TIROCINIO
                StatoRichiestaTirocinio statoRichiestaTirocinio = new StatoRichiestaTirocinio(frame,controller);
                frame.setVisible(false);
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
        indietroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrameChiamante.setVisible(true);
                frame.dispose();
            }
        });
    }
}
