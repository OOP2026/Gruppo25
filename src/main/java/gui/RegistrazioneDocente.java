package gui;

import controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrazioneDocente extends JFrame {
    private JButton d_confermaButton;
    private JTextField d_loginText;
    private JTextField d_passwordText;
    private JTextField d_nomeText;
    private JTextField d_cognomeText;
    private JTextField d_emailText;
    private JTextField d_CorsoLaureaText;
    private JButton annullaButton;
    private JPanel panelRegDocenti;
    private JFrame frame;
    private final Controller controller;
// eliminami!!!!!!!!!!
    public RegistrazioneDocente(JFrame frameHome) {

        controller = new Controller();
        frame = new JFrame("Registrazione Docente");
        frame.setContentPane(panelRegDocenti);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null); //Questo metodo serve per far avviare la schermata al centro dello schermo.
        frame.setResizable(false); //Questo metodo permetto(o non) di far ingrandire la schemrata.

        d_confermaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // LISTENER RIFERITO AL PULSANTE PER CONFERMARE LA REGISTRAZIONE DEL DOCENTE
                String login = d_loginText.getText().trim();
                String password = new String(d_passwordText.getText());
                password.trim();
                String nome = d_nomeText.getText().trim();
                String cognome = d_cognomeText.getText().trim();
                String email = d_emailText.getText().trim();
                String corsoLaurea = d_CorsoLaureaText.getText().trim();

                if(login.isEmpty() || password.isEmpty() || nome.isEmpty() || cognome.isEmpty() || email.isEmpty() || corsoLaurea.isEmpty()){
                    JOptionPane.showMessageDialog(frame, "Inserisci tutti i campi coglione");
                }
                // verifico se la login inserita è già presente
                else if(controller.controlloLogin(login)){JOptionPane.showMessageDialog(frame, "Login già esistente! Utilizzare una login differente");}
                // Verifico che la password inserita abbia almeno 8 caratteri
                else if(controller.controlloPassoword(password)){JOptionPane.showMessageDialog(frame,"Attenzione inserire una password di almeno 8 caratteri!");}
                // Verifico se nel nome sono inseriti dei numeri
                else if(controller.controlloNomeCognome(nome)){JOptionPane.showMessageDialog(frame, "Attenzione carattere non consentito nel nome!");}
                // Verifico se nel cognome sono inseriti dei numeri
                else if (controller.controlloNomeCognome(cognome)){JOptionPane.showMessageDialog(frame,"Attenzione carattere non consentito nel cognome!");}
                // verifico che la mail sia inserita nel formato giusto
                else if(controller.controlloEmailDocente(email)) {JOptionPane.showMessageDialog(frame,"Attenzione inserire la mail nel formato corretto!");}
                else {
                    JOptionPane.showMessageDialog(frame, "Benvenuto Prof. " +cognome);
                    controller.setDocente(login, password, nome, cognome, email, corsoLaurea);
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
