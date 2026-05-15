package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home {
    private JButton registratiComeStudenteRButton;
    private JTextField loginTextField;
    private JPasswordField passwordPasswordField;
    private JButton registratiComeDocenteButton;
    private JLabel BENBENUTOJLabel;

    public Home() {
        registratiComeStudenteRButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // LISTENER RIFERITO AL PULSANTE PER REGISTRARSI COME STUDENTE
            }
        });
        registratiComeDocenteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // LISTENER RIFERITO AL PULSANTE PER REGISTRARSI COME DOCENTE
            }
        });
    }
}
