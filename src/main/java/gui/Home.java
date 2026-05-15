package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home {
    public static JFrame frame;
    private JButton registratiComeStudenteRButton;
    private JTextField loginTextField;
    private JPasswordField passwordPasswordField;
    private JButton registratiComeDocenteButton;
    private JLabel BENVENUTOJLabel;
    private JPanel panelHome;
    private JButton inviaButton;

    public static void main(String[] args) {
        frame = new JFrame("Home"); // finestra nella quale ci sono gli elementi da visualizzare, qui è incluso anche il JPanel, e attraverso questo possiamo specificare il contenuto delle GUI
        frame.setContentPane(new Home().panelHome);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public Home() {
        registratiComeStudenteRButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // LISTENER RIFERITO AL PULSANTE PER REGISTRARSI COME STUDENTE
                RegistrazioneStudente guiRegistrazioneStudente = new RegistrazioneStudente(frame);
                frame.setVisible(false);
            }
        });
        registratiComeDocenteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // LISTENER RIFERITO AL PULSANTE PER REGISTRARSI COME DOCENTE.
                RegistrazioneDocente guiRegistrazione = new RegistrazioneDocente(frame);
                frame.setVisible(false);
                String login =
            }
        });

        inviaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // LISTENER PER ACCEDERE ALL'ACCOUNT E ANDARE NELLA HOME DOCENTE OPPURE STUDENTE.
                String login = loginTextField.getText().trim();
                String password = new String(passwordPasswordField.getPassword()).trim();
                // CONTROLLO PER CONVALIDARE SE I CAMPI LOGIN E PASSWORD NON SONO VUOTI.
                if(login.isEmpty() || password.isEmpty()){
                    JOptionPane.showMessageDialog(frame,"FORZA NAPOLI");
                } else {
                    // ALTRIMENTI SE TUTTI I CONTROLLI SONO PASSATI, APRE LA FINESTRA STUDENTE / DOCENTE
                }
            }
        });
    }

}
