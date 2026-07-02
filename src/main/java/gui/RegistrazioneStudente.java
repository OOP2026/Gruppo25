package gui;

import controller.Controller;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class RegistrazioneStudente extends JFrame {
    private JTextField sLoginTextField;
    private JTextField sNomeTextField;
    private JTextField sEmailTextField;
    private JTextField sCognomeTextField;
    private JButton sConfermaButton;
    private JLabel TitoloRegistraStudenteJLabel; // NOSONAR
    private JPanel panelRegStudenti;
    private JButton annullaButton;
    private JPasswordField sPasswordPasswordField;
    private JTextField sMatricolaTextField;
    private JFrame frame;
    private transient Controller controller;
    private static final String TITOLO_ERRORE = "Errore";

    public RegistrazioneStudente(JFrame frameHome, Controller controller) {
        this.controller = controller;

        frame = new JFrame("Registrazione Studente");
        frame.setContentPane(panelRegStudenti);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null); //Questo metodo serve per far avviare la schermata al centro dello schermo.
        frame.setResizable(false); //Questo metodo permetto(o non) di far ingrandire la schermata.
        frame.getRootPane().setDefaultButton(sConfermaButton); // Con questo metodo il pulsante conferma rileva anche l'invio da tastiera

        sConfermaButton.addActionListener(new ActionListener() { // NOSONAR
            @Override
            public void actionPerformed(ActionEvent e) {
                // LISTENER RIFERITO AL PULSANTE PER CONFERMARE LA REGISTRAZIONE DELLO STUDENTE
                String login = sLoginTextField.getText().trim();
                String password = String.valueOf(sPasswordPasswordField.getPassword()).trim();
                String nome = sNomeTextField.getText().trim();
                String cognome = sCognomeTextField.getText().trim();
                String email = sEmailTextField.getText().trim();
                String matricola = sMatricolaTextField.getText().trim();

                if(login.isEmpty() || password.isEmpty() || nome.isEmpty() || cognome.isEmpty() || email.isEmpty()  || matricola.isEmpty()){
                    JOptionPane.showMessageDialog(frame, "Attenzione riempire correttamente tutti i campi!", TITOLO_ERRORE, JOptionPane.ERROR_MESSAGE);
                }
                // Verifico se il login inserito è già presente
                else {
                    try {
                        if(RegistrazioneStudente.this.controller.controlloLogin(login)) {JOptionPane.showMessageDialog(frame, "Login già esistente! Utilizzare una login differente",TITOLO_ERRORE, JOptionPane.ERROR_MESSAGE);}
                        // Verifico che la password inserita abbia almeno 8 caratteri
                        else if(RegistrazioneStudente.this.controller.controlloPassoword(password)){JOptionPane.showMessageDialog(frame,"Attenzione inserire una password di almeno 8 caratteri!",TITOLO_ERRORE, JOptionPane.ERROR_MESSAGE);}
                        // Verifico se nel nome sono inseriti dei numeri
                        else if(RegistrazioneStudente.this.controller.controlloNomeCognome(nome)){JOptionPane.showMessageDialog(frame, "Attenzione carattere non consentito nel nome!",TITOLO_ERRORE, JOptionPane.ERROR_MESSAGE);}
                        // Verifico se nel cognome sono inseriti dei numeri
                        else if (RegistrazioneStudente.this.controller.controlloNomeCognome(cognome)){JOptionPane.showMessageDialog(frame,"Attenzione carattere non consentito nel cognome!",TITOLO_ERRORE, JOptionPane.ERROR_MESSAGE);}
                        // Verifico se la mail inserita è nel formato giusto
                        else if(RegistrazioneStudente.this.controller.controlloEmailStudente(email)){JOptionPane.showMessageDialog(frame,"Attenzione inserire la mail nel formato corretto!",TITOLO_ERRORE, JOptionPane.ERROR_MESSAGE);}
                        // Verifico se la matricola è inserita correttamente
                        else if(RegistrazioneStudente.this.controller.controlloFormatoMatricola(matricola)){JOptionPane.showMessageDialog(frame,"Attenzione la matricola deve essere nel formato giusto",TITOLO_ERRORE, JOptionPane.ERROR_MESSAGE);}
                        // Verifico se la matricola inserita è già presente
                        else if(RegistrazioneStudente.this.controller.controlloMatricola(matricola)){JOptionPane.showMessageDialog(frame,"Attenzione matricola già presente nel database!",TITOLO_ERRORE, JOptionPane.ERROR_MESSAGE);}
                        else {
                            JOptionPane.showMessageDialog(frame, "Benvenuto " + nome + " " + cognome + ".");
                            RegistrazioneStudente.this.controller.setStudente(login, password, nome, cognome, email, matricola);
                            frameHome.setVisible(true);
                            frame.dispose();
                        }
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });
        annullaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                frameHome.setVisible(true);
                frame.dispose();
            }
        });
    }
}
