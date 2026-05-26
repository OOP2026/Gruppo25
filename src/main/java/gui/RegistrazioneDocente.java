package gui;

import controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrazioneDocente extends JFrame {
    private JButton d_confermaButton;
    private JTextField d_loginText;
    private JPasswordField d_passwordText;
    private JTextField d_nomeText;
    private JTextField d_cognomeText;
    private JTextField d_emailText;
    private JButton annullaButton;
    private JPanel panelRegDocenti;
    private JLabel TitoloRegistraDocenteJLabel;
    private JFrame frame;
    private Controller controller;

    public RegistrazioneDocente(JFrame frameHome, Controller controller) {

        this.controller = controller;
        frame = new JFrame("Registrazione Docente");
        frame.setContentPane(panelRegDocenti);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null); //Questo metodo serve per far avviare la schermata al centro dello schermo.
        frame.setResizable(false); //Questo metodo permetto(o non) di far ingrandire la schermata.
        frame.getRootPane().setDefaultButton(d_confermaButton); // Con questo metodo il pulsante conferma rileva anche l'invio da tastiera

        d_confermaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // LISTENER RIFERITO AL PULSANTE PER CONFERMARE LA REGISTRAZIONE DEL DOCENTE
                String login = d_loginText.getText().trim();
                String password = new String (d_passwordText.getText());
                password.trim();
                String nome = d_nomeText.getText().trim();
                String cognome = d_cognomeText.getText().trim();
                String email = d_emailText.getText().trim();

                if(login.isEmpty() || password.isEmpty() || nome.isEmpty() || cognome.isEmpty() || email.isEmpty()){
                    JOptionPane.showMessageDialog(frame, "Attenzione riempire correttamente tutti i campi!", "Errore", JOptionPane.ERROR_MESSAGE);
                }
                // verifico se la login inserita è già presente
                else if(RegistrazioneDocente.this.controller.controlloLogin(login)){JOptionPane.showMessageDialog(frame, "Login già esistente! Utilizzare una login differente","Errore", JOptionPane.ERROR_MESSAGE);}
                // Verifico che la password inserita abbia almeno 8 caratteri
                else if(RegistrazioneDocente.this.controller.controlloPassoword(password)){JOptionPane.showMessageDialog(frame,"Attenzione inserire una password di almeno 8 caratteri!","Errore", JOptionPane.ERROR_MESSAGE);}
                // Verifico se nel nome sono inseriti dei numeri
                else if(RegistrazioneDocente.this.controller.controlloNomeCognome(nome)){JOptionPane.showMessageDialog(frame, "Attenzione carattere non consentito nel nome!","Errore", JOptionPane.ERROR_MESSAGE);}
                // Verifico se nel cognome sono inseriti dei numeri
                else if (RegistrazioneDocente.this.controller.controlloNomeCognome(cognome)){JOptionPane.showMessageDialog(frame,"Attenzione carattere non consentito nel cognome!","Errore", JOptionPane.ERROR_MESSAGE);}
                // verifico che la mail sia inserita nel formato giusto
                else if(RegistrazioneDocente.this.controller.controlloEmailDocente(email)) {JOptionPane.showMessageDialog(frame,"Attenzione inserire la mail nel formato corretto!","Errore", JOptionPane.ERROR_MESSAGE);}
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

    };
}
