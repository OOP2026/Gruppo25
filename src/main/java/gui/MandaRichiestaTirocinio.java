package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MandaRichiestaTirocinio {
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JButton OKButton;
    private JButton annullaButton;

    public MandaRichiestaTirocinio() {
        annullaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // LISTENER RIFERITO AL PULSANTE PER TORNARE INDIETRO DELLA SCHERMATA PER MANDARE LA RICHIESTA DI TIROCINIO
            }
        });

        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // LISTENER RIFERITO AL PULSANTE OK DELLA SCHERMATA PER MANDARE LA RICHIESTA DI TIROCINIO
            }
        });
    }
}
