package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrazioneDocente extends JFrame {
    private JButton d_confermaButton;
    private JTextField d_loginText;
    private JTextField d_PasswordText;
    private JTextField d_NomeText;
    private JTextField d_CognomeText;
    private JTextField d_EmailText;
    private JButton annullaButton;
    private JPanel panelRegDocenti;
    private JTextField d_CorsoLaureaText;
    private JTextField d_ArgomentiTirocinioText;
    private JFrame frame;


    public RegistrazioneDocente(JFrame frameHome) {
        frame = new JFrame("Registrazione Docente");
        frame.setContentPane(panelRegDocenti);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        d_confermaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // LISTENER RIFERITO AL PULSANTE PER CONFERMARE LA REGISTRAZIONE DEL DOCENTE
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

        d_confermaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // LISTENER RIFERITO AL PULSANTE PER CONFERMARE LA REGISTRAZIONE DEL DOCENTE
                frameHome.setVisible(true);
                frame.dispose();
            }
        });
    };
}
