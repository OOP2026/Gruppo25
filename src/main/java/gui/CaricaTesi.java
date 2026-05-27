package gui;

import javax.swing.*;
import controller.Controller;
import model.Stato;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CaricaTesi {
    private JTextField titoloTesiTextField;
    private JTextArea tesiTextArea;
    private JPanel panelCaricaTesi;
    private JButton OKButton;
    private JButton annullaButton;
    private JComboBox comboBoxDateSeduteDiLaurea;
    private JFrame frame;
    private Controller controller;

    public CaricaTesi(JFrame frameChiamante, Controller controller){
        this.controller = controller;
        frame = new JFrame("Carica Tesi");
        frame.setContentPane(panelCaricaTesi);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);


        OKButton.addActionListener(new ActionListener() { // NOSONAR
            @Override
            public void actionPerformed(ActionEvent e) {
                if (titoloTesiTextField.getText().isEmpty() || tesiTextArea.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Attenzione riempire correttamente tutti i campi!", "Errore", JOptionPane.ERROR_MESSAGE);
                }else if (comboBoxDateSeduteDiLaurea.getSelectedItem().equals("--- Seleziona una data ---")) {
                        JOptionPane.showMessageDialog(null, "Per favore, seleziona una data per la seduta!", "Errore", JOptionPane.ERROR_MESSAGE);
                }else {
                    CaricaTesi.this.controller.aggiungiNuovaTesi(Stato.ATTESA, titoloTesiTextField.getText(), tesiTextArea.getText(), (String)comboBoxDateSeduteDiLaurea.getSelectedItem());
                    frame.setVisible(false);
                    frameChiamante.setVisible(true);
                    frame.dispose();
                }
            }
        });
        annullaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                frameChiamante.setVisible(true);
                frame.dispose();
            }
        });
        comboBoxDateSeduteDiLaurea.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
    }


}

