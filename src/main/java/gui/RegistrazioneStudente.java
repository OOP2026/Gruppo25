package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrazioneStudente {
    private JTextField s_nomeTextField;
    private JTextField s_cognomeTextField;
    private JTextField s_emailTextField;
    private JTextField ls_oginTextField;
    private JPasswordField s_passwordPasswordField;
    private JTextField s_matricolaTextField;
    private JButton s_confermaButton;
    private JLabel TitoloRegistraStudenteJLabel;

    public RegistrazioneStudente() {
        s_confermaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // LISTENER RIFERITO AL PULSANTE PER CONFERMARE LA REGISTRAZIONE DELLO STUDENTE
            }
        });
    }
}
