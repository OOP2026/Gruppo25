package gui;

import controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudenteHome {
    private JButton elencoDocentiButton;
    private JButton compilaRichiestaDiTirocinioButton;
    private JButton visualizzaStatoRichiestaTirocinioButton;
    private JButton caricaTesiButton;
    private JPanel panelStudenteHome;
    private JButton indietroButton;
    private JButton visualizzaStatoTesiButton;
    private JFrame frame;
    private Controller controller;

    public StudenteHome(JFrame frameChiamante, Controller controller) {
        this.controller = controller;
        frame = new JFrame("Home Studente");
        frame.setContentPane(panelStudenteHome);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null); //Questo metodo serve per far avviare la schermata al centro dello schermo.
        compilaRichiestaDiTirocinioButton.setEnabled(controller.controlloRichiesta()); // NOSONAR
        //caricaTesiButton.setEnabled(controller.controlloTesiButton());
        visualizzaStatoTesiButton.setEnabled(controller.haTesi());

        // Aggiungiamo un listener che si attiva quando la finestra cambia stato
        frame.addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentShown(java.awt.event.ComponentEvent e) {
                compilaRichiestaDiTirocinioButton.setEnabled(controller.controlloRichiesta());
                //caricaTesiButton.setEnabled(controller.controlloTesiButton());
                visualizzaStatoTesiButton.setEnabled(controller.haTesi());
            }
        });


        elencoDocentiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // LISTENER RIFERITO AL BOTTONE PER APRIRE LA FINESTRA DELL'ELENCO DEI DOCENTI
                new ElencoDocenti(frame,controller);
                frame.setVisible(false);
            }
        });
        compilaRichiestaDiTirocinioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // LISTENER RIFERITO AL BOTTONE PER APRIRE LA FINESTRA PER COMPILARE LA RICHIESTA DI TIROCINIO
                new MandaRichiestaTirocinio(frame,controller);
                frame.setVisible(false);
            }
        });
        visualizzaStatoRichiestaTirocinioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // LISTENER RIFERITO AL BOTTONE PER APRIRE LA FINESTRA PER VISUALIZZARE LO STATO DELLA RICHIESTA DEL TIROCINIO
                new StatoRichiestaTirocinio(frame,controller);
                frame.setVisible(false);
            }
        });
        caricaTesiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // LISTENER RIFERITO AL BOTTONE PER CARICARE IL FILE DELLA TESI
                new CaricaTesi(frame,controller);
                frame.setVisible(false);
            }
        });

        indietroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameChiamante.setVisible(true);
                frame.dispose();
            }
        });

        visualizzaStatoTesiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StatoTesi(frame,controller);
                frame.setVisible(false);
            }
        });
    }
}
