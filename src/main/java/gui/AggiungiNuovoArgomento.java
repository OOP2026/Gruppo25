package gui;

import controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AggiungiNuovoArgomento {
    private JLabel nomeArgomentoLabel;
    private JTextField nomeArgomentoText;
    private JButton okButtun;
    private JButton annullaButton;
    private JPanel panelAggArg;
    private JFrame frame;
    private Controller controller;

    public AggiungiNuovoArgomento(JFrame FrameChiamante, Controller controller) {
        this.controller = controller;
        frame = new JFrame("Aggiungi Argomento di Tirocinio");
        frame.setContentPane(panelAggArg);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null); //Questo metodo serve per far avviare la schermata al centro dello schermo.

        annullaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrameChiamante.setVisible(true);
                frame.dispose();
            }
        });
        okButtun.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Variabile per contenere l'argomento in input dal Docente.
                String argomentoInput = nomeArgomentoText.getText().trim();
                // Controlliamo che il campo non sia vuoto.
                if(argomentoInput.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Devi riempire tutti i campi idoneamente.");
                    return;
                } else {
                    // Chiamiamo il metodo aggiungiNuovoArgomento del controller per fare aggiungere nella lista la stringa presa dal TextField.
                    AggiungiNuovoArgomento.this.controller.aggiungiNuovoArgomento(nomeArgomentoText.getText());
                    JOptionPane.showMessageDialog(null, "Argomento aggiunto correttamente.");
                }
                FrameChiamante.setVisible(true);
                frame.dispose();
            }
        });
    }
}
