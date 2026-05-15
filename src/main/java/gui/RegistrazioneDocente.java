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

    public RegistrazioneDocente(JFrame frameHome) {

        controller = new Controller();
        frame = new JFrame("Registrazione Docente");
        frame.setContentPane(panelRegDocenti);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

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
                } else {
                    JOptionPane.showMessageDialog(frame, "Benvenuto Prof. " +cognome);
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
