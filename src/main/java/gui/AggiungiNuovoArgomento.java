package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AggiungiNuovoArgomento {
    private JLabel nomeArgomentoLabel;
    private JTextField nomeArgomentoText;
    private JButton okButtun;
    private JButton annullaButton;
    private JPanel panelAggArg;
    private JFrame frame;

    public AggiungiNuovoArgomento(JFrame FrameChiamante) {
        frame = new JFrame("Home Docente");
        frame.setContentPane(panelAggArg);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null); //Questo metodo serve per far avviare la schermata al centro dello schermo.

        annullaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrameChiamante.setVisible(true);
                frame.dispose();
            }
        });
        okButtun.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // !!! VANNO AGGIUNTI I METODI PER AGGIUNGERE E SALVARE GLI ARGOMENTI DEL TIROCINIO!1
                FrameChiamante.setVisible(true);
                frame.dispose();
            }
        });
    }
}
