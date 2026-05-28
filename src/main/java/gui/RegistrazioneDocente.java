package gui;

import controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrazioneDocente extends JFrame {
    private JButton dConfermaButton;
    private JTextField dLogintext;
    private JPasswordField dPasswordText;
    private JTextField dNomeText;
    private JTextField dCognomeText;
    private JTextField dEmailText;
    private JButton annullaButton;
    private JPanel panelRegDocenti;
    private JLabel titoloRegistraDocenteJLabel; // NOSONAR
    private JFrame frame;
    private Controller controller;
    private static final String TITOLO_ERRORE = "Errore";

    public RegistrazioneDocente(JFrame frameHome, Controller controller) {

        this.controller = controller;
        frame = new JFrame("Registrazione Docente");
        frame.setContentPane(panelRegDocenti);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null); //Questo metodo serve per far avviare la schermata al centro dello schermo.
        frame.setResizable(false); //Questo metodo permetto(o non) di far ingrandire la schermata.
        frame.getRootPane().setDefaultButton(dConfermaButton); // Con questo metodo il pulsante conferma rileva anche l'invio da tastiera

        dConfermaButton.addActionListener(new ActionListener() { // NOSONAR
            @Override
            public void actionPerformed(ActionEvent e) {
                // LISTENER RIFERITO AL PULSANTE PER CONFERMARE LA REGISTRAZIONE DEL DOCENTE
                String login = dLogintext.getText().trim();
                String password = String.valueOf(dPasswordText.getPassword()).trim();
                String nome = dNomeText.getText().trim();
                String cognome = dCognomeText.getText().trim();
                String email = dEmailText.getText().trim();

                if(login.isEmpty() || password.isEmpty() || nome.isEmpty() || cognome.isEmpty() || email.isEmpty()){
                    JOptionPane.showMessageDialog(frame, "Attenzione riempire correttamente tutti i campi!", TITOLO_ERRORE, JOptionPane.ERROR_MESSAGE);
                }
                // verifico se la login inserita è già presente
                else if(RegistrazioneDocente.this.controller.controlloLogin(login)){JOptionPane.showMessageDialog(frame, "Login già esistente! Utilizzare una login differente",TITOLO_ERRORE, JOptionPane.ERROR_MESSAGE);}
                // Verifico che la password inserita abbia almeno 8 caratteri
                else if(RegistrazioneDocente.this.controller.controlloPassoword(password)){JOptionPane.showMessageDialog(frame,"Attenzione inserire una password di almeno 8 caratteri!",TITOLO_ERRORE, JOptionPane.ERROR_MESSAGE);}
                // Verifico se nel nome sono inseriti dei numeri
                else if(RegistrazioneDocente.this.controller.controlloNomeCognome(nome)){JOptionPane.showMessageDialog(frame, "Attenzione carattere non consentito nel nome!",TITOLO_ERRORE, JOptionPane.ERROR_MESSAGE);}
                // Verifico se nel cognome sono inseriti dei numeri
                else if (RegistrazioneDocente.this.controller.controlloNomeCognome(cognome)){JOptionPane.showMessageDialog(frame,"Attenzione carattere non consentito nel cognome!",TITOLO_ERRORE, JOptionPane.ERROR_MESSAGE);}
                // verifico che la mail sia inserita nel formato giusto
                else if(RegistrazioneDocente.this.controller.controlloEmailDocente(email)) {JOptionPane.showMessageDialog(frame,"Attenzione inserire la mail nel formato corretto!",TITOLO_ERRORE, JOptionPane.ERROR_MESSAGE);}
                else {
                    JOptionPane.showMessageDialog(frame, "Benvenuto Prof. " +cognome);
                    RegistrazioneDocente.this.controller.setDocente(login, password, nome, cognome, email);
                    frameHome.setVisible(true);
                    frame.dispose();
                }
            }
        });

        annullaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                frame.setVisible(false);
                frameHome.setVisible(true);
                frame.dispose();
            }
        });
    }
}
