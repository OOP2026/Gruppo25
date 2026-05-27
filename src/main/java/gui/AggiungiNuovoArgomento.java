package gui;

import controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AggiungiNuovoArgomento {
    private JLabel nomeArgomentoLabel;
    private JTextField nomeArgomentoText;
    private JButton OKButton;
    private JButton annullaButton;
    private JPanel panelAggArg;
    private JTextField tipologiaTirocinioTextField;
    private JTextField nomeAziendaTextField;
    private JTextField nominativoReferenteTextField;
    private JFrame frame;
    private Controller controller;

    public AggiungiNuovoArgomento(JFrame FrameChiamante, Controller controller) {
        this.controller = controller;
        frame = new JFrame("Aggiungi Argomento di Tirocinio");
        frame.setContentPane(panelAggArg);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);//Questo metodo serve per far avviare la schermata al centro dello schermo.
        nomeAziendaTextField.setVisible(false); // NOSONAR
        nominativoReferenteTextField.setVisible(false);
        frame.getRootPane().setDefaultButton(OKButton); // Con questo metodo il pulsante ok rileva anche l'invio da tastiera

        annullaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrameChiamante.setVisible(true);
                frame.dispose();
            }
        });

        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Variabile per contenere l'argomento in input dal Docente.
                String argomentoInput = nomeArgomentoText.getText();
                String tipologiaTirocinio = tipologiaTirocinioTextField.getText();
                // Controlliamo che il campo non sia vuoto.
                if(argomentoInput.isEmpty() || tipologiaTirocinio.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Devi riempire tutti i campi idoneamente.","Errore",JOptionPane.ERROR_MESSAGE);
                    return;
                } else if(!(controller.controlloInserimentoTirocinio(tipologiaTirocinio))) {
                    JOptionPane.showMessageDialog(null, "Inserire correttamente la tipologia del tirocinio. [INTERNO o ESTERNO].","Errore",JOptionPane.ERROR_MESSAGE);
                    return;
                }else if(tipologiaTirocinio.equalsIgnoreCase("ESTERNO")) {
                    nomeAziendaTextField.setVisible(true);
                    nominativoReferenteTextField.setVisible(true);
                    if (nomeAziendaTextField.getText().trim().isEmpty() || nominativoReferenteTextField.getText().trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Ora aggiungi le info dell'azienda collaboratrice.","Aggiungi Azienda",JOptionPane.INFORMATION_MESSAGE);
                        return;
                    } else if (controller.controlloNomeCognome(nominativoReferenteTextField.getText())) {
                        JOptionPane.showMessageDialog(null, "Attenzione: carattere non consentito nel nome!","Errore",JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    else{
                        AggiungiNuovoArgomento.this.controller.aggiungiNuovoArgomento(nomeArgomentoText.getText(),tipologiaTirocinioTextField.getText(),nomeAziendaTextField.getText(),nominativoReferenteTextField.getText());
                        JOptionPane.showMessageDialog(null, "Tirocinio aggiunto correttamente.");
                    }
                }
                else if(tipologiaTirocinio.equalsIgnoreCase("INTERNO")) {
                    AggiungiNuovoArgomento.this.controller.aggiungiNuovoArgomento(nomeArgomentoText.getText(),tipologiaTirocinioTextField.getText(),nomeAziendaTextField.getText(),nominativoReferenteTextField.getText());
                    JOptionPane.showMessageDialog(null, "Tirocinio aggiunto correttamente.");
                }
                FrameChiamante.setVisible(true);
                frame.dispose();

            }
        });
    }
}
