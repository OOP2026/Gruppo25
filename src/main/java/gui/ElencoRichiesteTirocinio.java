package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ElencoRichiesteTirocinio {
    private JButton ritornaAllaHomeButton;
    private JList listaRrichiesteTirocinio;
    private JPanel panelElencoRichiesteTirocinio;
    private JFrame frame;

    public ElencoRichiesteTirocinio(JFrame FrameChiamante) {
        frame = new JFrame("Elenco Richieste di Tirocinio");
        frame.setContentPane(panelElencoRichiesteTirocinio);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null); //Questo metodo serve per far avviare la schermata al centro dello schermo.

        ritornaAllaHomeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrameChiamante.setVisible(true);
                frame.dispose();
            }
        });
    }
}
