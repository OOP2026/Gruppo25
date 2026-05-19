package gui;

import controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DocenteHome {
    private JButton aggiungiTirocinioButton;
    private JButton visualizzaElencoDelleRichiesteButton;
    private JButton visualizzaTirocininantiButton;
    private JButton visualizzaTesiInCorsoButton;
    private JButton indietroButton;
    private JPanel panelDocenteHome;
    private JFrame frame;
    private Controller controller;

    public DocenteHome(JFrame FrameChiamante, Controller controller) {
        this.controller = controller;
        frame = new JFrame("Home Docente");
        frame.setContentPane(panelDocenteHome);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null); //Questo metodo serve per far avviare la schermata al centro dello schermo.

        aggiungiTirocinioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AggiungiNuovoArgomento aggiungiNuovoArgomento = new AggiungiNuovoArgomento(frame,controller);
                frame.setVisible(false);
            }
        });

        visualizzaElencoDelleRichiesteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ElencoRichiesteTirocinio elencoRichiesteTirocinio = new ElencoRichiesteTirocinio(frame,controller);
                frame.setVisible(false);
            }
        });

        visualizzaTirocininantiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ElencoTirocinanti elencoTirocinanti = new ElencoTirocinanti(frame,controller);
                frame.setVisible(false);
            }
        });
        visualizzaTesiInCorsoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ElencoTesisti elencoTesisti = new ElencoTesisti(frame,controller);
                frame.setVisible(false);
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
