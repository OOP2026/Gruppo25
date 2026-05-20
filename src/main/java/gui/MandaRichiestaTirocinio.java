package gui;

import controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MandaRichiestaTirocinio {
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JButton OKButton;
    private JPanel panelRichiestaTirocinio;
    private JButton annullaButton;
    private JFrame frame;
    private Controller controller;

    public MandaRichiestaTirocinio(JFrame FrameChiamante, Controller controller) {
        this.controller = controller;
        frame = new JFrame("Richiesta Tirocinio");
        frame.setContentPane(panelRichiestaTirocinio);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null); //Questo metodo serve per far avviare la schermata al centro dello schermo.

        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // LISTENER RIFERITO AL PULSANTE OK DELLA SCHERMATA PER MANDARE LA RICHIESTA DI TIROCINIO
                FrameChiamante.setVisible(true);
                frame.dispose();
            }
        });

        // Per poter aggiungere tutti i docenti diversi alla tendina.
        for(String nomeProf : controller.getNomiUnaVolta()){
            comboBox1.addItem(nomeProf);
        }

    }
}
