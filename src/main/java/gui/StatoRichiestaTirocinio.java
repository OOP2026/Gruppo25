package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StatoRichiestaTirocinio {
    private JButton OKButton;
    private JLabel statoEffettivoJLabel;
    private JLabel stato_della_richiestaJLabel;
    private JButton annullaButton;
    private JPanel panelStatoRichiestaTirocinio;
    private JFrame frame;

    public StatoRichiestaTirocinio(JFrame FrameChiamante) {
        frame = new JFrame("Stato Richiesta Tirocinio");
        frame.setContentPane(panelStatoRichiestaTirocinio);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // LISTENER DEL PULSANTE OK DELLA SCHERMATA DELLO STATO DELLA RICHIESTA DI TIROCINIO
                FrameChiamante.setVisible(true);
                frame.dispose();
            }
        });

    }
}
