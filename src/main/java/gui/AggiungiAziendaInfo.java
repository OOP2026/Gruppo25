package gui;

import controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AggiungiAziendaInfo {
    private Controller controller;
    private JFrame frame;
    private JPanel panelAggiungiAziendaInfo;
    private JTextField nomeAziendaTextField;
    private JTextField nominativoReferenteTextField;
    private JButton OKbutton;
    private JButton annullaButton;


    public AggiungiAziendaInfo(JFrame FrameChiamante, Controller controller) {
        this.controller = controller;
        frame = new JFrame("Aggiungi Info Azienda");
        frame.setContentPane(panelAggiungiAziendaInfo);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null); //Questo metodo serve per far avviare la schermata al centro dello schermo.


        OKbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Controlliamo che i campi non siano vuoti.
                if(nomeAziendaTextField.getText().trim().isEmpty() || nominativoReferenteTextField.getText().trim().isEmpty() ){
                    JOptionPane.showMessageDialog(null,"Devi riempire tutti i campi idoneamente.");
                    return;
                } else if(controller.controlloNomeCognome(nominativoReferenteTextField.getText())){
                    JOptionPane.showMessageDialog(null,"Attenzione: carattere non consentito nel nome!");
                    return;
                } else {
                    controller.istanziaAzienda(nomeAziendaTextField.getText(), nominativoReferenteTextField.getText());
                    JOptionPane.showMessageDialog(null, "Azienda aggiunta con successo.");
                }
                FrameChiamante.setVisible(true);
                frame.dispose();
            }
        });

        annullaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrameChiamante.setVisible(true);
                frame.dispose();
            }
        });

    }
}
