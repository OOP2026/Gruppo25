package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MandaRichiestaTirocinio {
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JButton OKButton;
    private JPanel panelRichiestaTirocinio;
    private JButton annullaButton;
    private JFrame frame;

    public MandaRichiestaTirocinio(JFrame FrameChiamante) {
        frame = new JFrame("Richiesta Tirocinio");
        frame.setContentPane(panelRichiestaTirocinio);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null); //Questo metodo serve per far avviare la schermata al centro dello schermo.

        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // LISTENER RIFERITO AL PULSANTE OK DELLA SCHERMATA PER MANDARE LA RICHIESTA DI TIROCINIO
                FrameChiamante.setVisible(true);
                frame.dispose();
            }
        });
    }
}
