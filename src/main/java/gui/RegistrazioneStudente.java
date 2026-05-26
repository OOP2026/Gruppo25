package gui;

import controller.Controller;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrazioneStudente extends JFrame {
    private JTextField s_loginTextField;
    private JTextField s_nomeTextField;
    private JTextField s_emailTextField;
    private JTextField s_cognomeTextField;
    private JButton s_confermaButton;
    private JLabel TitoloRegistraStudenteJLabel;
    private JPanel panelRegStudenti;
    private JButton annullaButton;
    private JPasswordField s_passwordPasswordField;
    private JTextField s_matricolaTextField;
    private JFrame frame;
    private Controller controller;

    public RegistrazioneStudente(JFrame frameHome, Controller controller) {
        this.controller = controller;

        frame = new JFrame("Registrazione Studente");
        frame.setContentPane(panelRegStudenti);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null); //Questo metodo serve per far avviare la schermata al centro dello schermo.
        frame.setResizable(false); //Questo metodo permetto(o non) di far ingrandire la schemrata.
        frame.getRootPane().setDefaultButton(s_confermaButton); // Con questo metodo il pulsante conferma rileva anche l'invio da tastiera

        s_confermaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // LISTENER RIFERITO AL PULSANTE PER CONFERMARE LA REGISTRAZIONE DELLO STUDENTE
                String login = s_loginTextField.getText().trim();
                String password = new String (s_passwordPasswordField.getText());
                password.trim();
                String nome = s_nomeTextField.getText().trim();
                String cognome = s_cognomeTextField.getText().trim();
                String email = s_emailTextField.getText().trim();
                String matricola = s_matricolaTextField.getText().trim();

                if(login.isEmpty() || password.isEmpty() || nome.isEmpty() || cognome.isEmpty() || email.isEmpty()  || matricola.isEmpty()){
                    JOptionPane.showMessageDialog(frame, "Attenzione riempire correttamente tutti i campi!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
                // Verifico se il login inserito è già presente
                else if(RegistrazioneStudente.this.controller.controlloLogin(login)) {JOptionPane.showMessageDialog(frame, "Login già esistente! Utilizzare una login differente","Errore", JOptionPane.ERROR_MESSAGE);}
                // Verifico che la password inserita abbia almeno 8 caratteri
                else if(RegistrazioneStudente.this.controller.controlloPassoword(password)){JOptionPane.showMessageDialog(frame,"Attenzione inserire una password di almeno 8 caratteri!","Errore", JOptionPane.ERROR_MESSAGE);}
                // Verifico se nel nome sono inseriti dei numeri
                else if(RegistrazioneStudente.this.controller.controlloNomeCognome(nome)){JOptionPane.showMessageDialog(frame, "Attenzione carattere non consentito nel nome!","Errore", JOptionPane.ERROR_MESSAGE);}
                // Verifico se nel cognome sono inseriti dei numeri
                else if (RegistrazioneStudente.this.controller.controlloNomeCognome(cognome)){JOptionPane.showMessageDialog(frame,"Attenzione carattere non consentito nel cognome!","Errore", JOptionPane.ERROR_MESSAGE);}
                // Verifico se la mail inserita è nel formato giusto
                else if(RegistrazioneStudente.this.controller.controlloEmailStudente(email)){JOptionPane.showMessageDialog(frame,"Attenzione inserire la mail nel formato corretto!","Errore", JOptionPane.ERROR_MESSAGE);}
                // Verifico se la matricola è inserita correttamente
                else if(RegistrazioneStudente.this.controller.controlloFormatoMatricola(matricola)){JOptionPane.showMessageDialog(frame,"Attenzione la matricola deve essere nel formato giusto","Errore", JOptionPane.ERROR_MESSAGE);}
                // Verifico se la matricola inserita è già presente
                else if(RegistrazioneStudente.this.controller.controlloMatricola(matricola)){JOptionPane.showMessageDialog(frame,"Attenzione matricola già presente nel database!","Errore", JOptionPane.ERROR_MESSAGE);}
                else {
                    JOptionPane.showMessageDialog(frame, "Benvenuto " + nome + " " + cognome + ".");
                    RegistrazioneStudente.this.controller.setStudente(login, password, nome, cognome, email, matricola);
                    frameHome.setVisible(true);
                    frame.dispose();
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
