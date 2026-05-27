package gui;

import controller.Controller;
import model.Docente;
import model.Studente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MandaRichiestaTirocinio extends JFrame {
    private JButton OKButton;
    private JPanel panelRichiestaTirocinio;
    private JButton annullaButton;
    private JTextField argomentoTextField;
    private JTextField nomeDocenteTextField;
    private JTextField cognomeDocenteTextField;
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
        frame.getRootPane().setDefaultButton(OKButton); // Con questo metodo il pulsante ok rileva anche l'invio da tastiera

        OKButton.addActionListener(new ActionListener() { // NOSONAR
            @Override
            public void actionPerformed(ActionEvent e) {
                // LISTENER RIFERITO AL PULSANTE OK DELLA SCHERMATA PER MANDARE LA RICHIESTA DI TIROCINIO
                String nomeDocente = nomeDocenteTextField.getText();
                String cognomeDocente = cognomeDocenteTextField.getText();
                String argomentoProf = argomentoTextField.getText();
                if(nomeDocente.trim().isEmpty() || cognomeDocente.trim().isEmpty() || argomentoProf.trim().isEmpty() ){
                    JOptionPane.showMessageDialog(frame, "Attenzione riempire correttamente tutti i campi!", "Errore", JOptionPane.ERROR_MESSAGE);
                } else if (MandaRichiestaTirocinio.this.controller.controllaRichiestaTirocinio(nomeDocente, cognomeDocente, argomentoProf)) {
                    JOptionPane.showMessageDialog(frame, "Attenzione riempire correttamente tutti i campi!", "Errore", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    MandaRichiestaTirocinio.this.controller.aggiungiRichiestaTirocinio(nomeDocente, cognomeDocente, argomentoProf);
                    JOptionPane.showMessageDialog(frame,"Richiesta inoltrata correttamente.");
                    FrameChiamante.revalidate();
                    FrameChiamante.repaint();
                    MandaRichiestaTirocinio.this.controller.setArgomentoStudente(argomentoProf);
                    FrameChiamante.setVisible(true);
                    frame.dispose();
                }

            }
        });

        annullaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                FrameChiamante.setVisible(true);
                frame.dispose();
            }
        });

    }
}
