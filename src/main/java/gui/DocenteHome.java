package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DocenteHome {
    private JButton aggiungiTirocinioButton;
    private JButton visualizzaElencoDelleRichiesteButton;
    private JButton visualizzaTirocininantiButton;
    private JButton visualizzaTesiInCorsoButton;
    private JButton indietroButton;
    private JPanel panelDocenteHome;
    private JFrame frame;

    public DocenteHome(JFrame FrameChiamante) {
        frame = new JFrame("Home Docente");
        frame.setContentPane(panelDocenteHome);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        aggiungiTirocinioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        visualizzaElencoDelleRichiesteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        visualizzaTirocininantiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        visualizzaTesiInCorsoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        indietroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrameChiamante.setVisible(true);
                frame.dispose();
            }
        });
    }
}
