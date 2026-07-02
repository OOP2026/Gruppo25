package gui;

import controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AggiungiNuovoArgomento {
    private JLabel nomeArgomentoLabel; //NOSONAR
    private JTextField nomeArgomentoText;
    private JButton okbutton;
    private JButton annullaButton;
    private JPanel panelAggArg;
    private JTextField tipologiaTirocinioTextField;
    private JTextField nomeAziendaTextField;
    private JTextField nominativoReferenteTextField;
    private JFrame frame;
    private Controller controller;
    private static final String TITOLO_ERRORE = "Errore";

    public AggiungiNuovoArgomento(JFrame frameChiamante, Controller controller) {
        this.controller = controller;
        frame = new JFrame("Aggiungi Argomento di Tirocinio");
        frame.setContentPane(panelAggArg);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);//Questo metodo serve per far avviare la schermata al centro dello schermo.
        nomeAziendaTextField.setVisible(false); // NOSONAR
        nominativoReferenteTextField.setVisible(false);
        frame.getRootPane().setDefaultButton(okbutton); // Con questo metodo il pulsante ok rileva anche l'invio da tastiera

        annullaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameChiamante.setVisible(true);
                frame.dispose();
            }
        });

        okbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String argomentoInput = nomeArgomentoText.getText().trim();
                String tipologiaTirocinio = tipologiaTirocinioTextField.getText().trim();
                // 1. Controlli generici sul riempimento dei campi
                if(argomentoInput.isEmpty() || tipologiaTirocinio.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Devi riempire tutti i campi idoneamente.",TITOLO_ERRORE,JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if(!(controller.controlloInserimentoTirocinio(tipologiaTirocinio))) {
                    JOptionPane.showMessageDialog(null, "Inserire correttamente la tipologia del tirocinio. [INTERNO o ESTERNO].",TITOLO_ERRORE,JOptionPane.ERROR_MESSAGE);
                    return;
                }
                boolean successo = false;
                // 2. Gestione del caso ESTERNO
                if(tipologiaTirocinio.equalsIgnoreCase("ESTERNO")) {
                    nomeAziendaTextField.setVisible(true);
                    nominativoReferenteTextField.setVisible(true);

                    if (nomeAziendaTextField.getText().trim().isEmpty() || nominativoReferenteTextField.getText().trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Ora aggiungi le info dell'azienda collaboratrice.","Aggiungi Azienda",JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }
                    if (controller.controlloNomeCognome(nominativoReferenteTextField.getText())) {
                        JOptionPane.showMessageDialog(null, "Attenzione: carattere non consentito nel nome!",TITOLO_ERRORE,JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    successo = controller.aggiungiNuovoArgomento(nomeArgomentoText.getText(), tipologiaTirocinioTextField.getText(), nomeAziendaTextField.getText(), nominativoReferenteTextField.getText());
                    if (successo){
                        JOptionPane.showMessageDialog(null, "Tirocinio aggiunto correttamente.");
                    } else{
                        JOptionPane.showMessageDialog(null, "Errore nel salvataggio dei dati nel DataBase, azienda non esistente",TITOLO_ERRORE,JOptionPane.ERROR_MESSAGE);
                    }
                }
                // 3. Gestione del caso INTERNO
                if(tipologiaTirocinio.equalsIgnoreCase("INTERNO")) {
                    successo = controller.aggiungiNuovoArgomento(nomeArgomentoText.getText(), tipologiaTirocinioTextField.getText(), nomeAziendaTextField.getText(), nominativoReferenteTextField.getText());

                    if (successo){
                        JOptionPane.showMessageDialog(null, "Tirocinio aggiunto correttamente.");
                    } else{
                        JOptionPane.showMessageDialog(null,"Errore nel salvataggio dei dati nel DataBase",TITOLO_ERRORE,JOptionPane.ERROR_MESSAGE);
                    }
                }
                // 4. Chiusura del frame SOLO se l'inserimento è andato a buon fine
                if (successo) {
                    frameChiamante.setVisible(true);
                    frame.dispose();
                }
            }
        });
    }
}
