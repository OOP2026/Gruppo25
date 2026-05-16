package gui;

import controller.Controller;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class RegistrazioneStudente extends JFrame {
    private JTextField s_loginTextField;
    private JTextField s_nomeTextField;
    private JTextField s_emailTextField;
    private JTextField s_cognomeTextField;
    private JButton s_confermaButton;
    private JLabel TitoloRegistraStudenteJLabel;
    private JPanel panelRegStudenti;
    private JButton annullaButton;
    private JTextField s_corsoLaureaTextField;
    private JPasswordField s_passwordPasswordField;
    private JTextField s_matricolaTextField;
    private JFrame frame;
    private final Controller controller;

    public RegistrazioneStudente(JFrame frameHome) {
        controller = new Controller();

        frame = new JFrame("Registrazione Studente");
        frame.setContentPane(panelRegStudenti);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null); //Questo metodo serve per far avviare la schermata al centro dello schermo.
        frame.setResizable(false); //Questo metodo permetto(o non) di far ingrandire la schemrata.

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
                String corsoLaurea = s_corsoLaureaTextField.getText().trim();
                String matricola = s_matricolaTextField.getText().trim();

                if(login.isEmpty() || password.isEmpty() || nome.isEmpty() || cognome.isEmpty() || email.isEmpty() || corsoLaurea.isEmpty() || matricola.isEmpty()){
                    JOptionPane.showMessageDialog(frame, "Devi riempire tutti i campi idoneamente.");
                } else {
                    JOptionPane.showMessageDialog(frame, "Benvenuto, " + nome);
                    controller.setStudente(login, password, nome, cognome, email, corsoLaurea, matricola);
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
