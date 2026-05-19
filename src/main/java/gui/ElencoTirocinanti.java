package gui;

import controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ElencoTirocinanti {
    private JButton ritornaAllaHomeButton;
    private JTable tabellaStudenteArgomentoTirocinio;
    private JPanel panelElencoTirocinanti;
    private JScrollBar scrollBar1;
    private JFrame frame;
    private Controller controller;

    public ElencoTirocinanti(JFrame FrameChiamante, Controller controller) {
        this.controller = controller;
        frame = new JFrame("Elenco Tirocinanti");
        frame.setContentPane(panelElencoTirocinanti);
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
