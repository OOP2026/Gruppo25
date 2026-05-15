package gui;

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
    private JTextField s_corsoLaureaTextField;
    private JPasswordField s_passwordPasswordField;
    private JTextField s_matricolaTextField;
    private JFrame frame;

    public RegistrazioneStudente(JFrame frameHome) {
        frame = new JFrame("Registrazione Studente");
        frame.setContentPane(panelRegStudenti);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        s_confermaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // LISTENER RIFERITO AL PULSANTE PER CONFERMARE LA REGISTRAZIONE DELLO STUDENTE
                frameHome.setVisible(true);
                frame.dispose();
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
