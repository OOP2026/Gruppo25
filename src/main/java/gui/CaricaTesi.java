package gui;

import javax.swing.*;
import controller.Controller;
import model.Stato;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CaricaTesi {
    private JTextField titoloTesiTextField;
    private JTextArea tesiTextArea;
    private Controller controller;
    private JFrame frame;
    private JPanel panelCaricaTesi;
    private JButton OKButton;
    private JButton annullaButton;

    public CaricaTesi(JFrame framechiamante, Controller controller){
        this.controller = controller;
        frame = new JFrame("Carica Tesi");
        frame.setContentPane(panelCaricaTesi);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);


        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (titoloTesiTextField.getText().isEmpty() || tesiTextArea.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Attenzione riempire correttamente tutti i campi!", "Erro", JOptionPane.ERROR_MESSAGE);
                } else {
                    CaricaTesi.this.controller.aggiungiNuovaTesi(Stato.ATTESA, titoloTesiTextField.getText(), tesiTextArea.getText());
                    frame.setVisible(false);
                    framechiamante.setVisible(true);
                    frame.dispose();
                }
            }
        });
        annullaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                framechiamante.setVisible(true);
                frame.dispose();
            }
        });
    }


}

