package gui;

import controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The type Docente home.
 */
public class DocenteHome {
    private JButton aggiungiTirocinioButton;
    private JButton visualizzaElencoDelleRichiesteButton;
    private JButton visualizzaTirocininantiButton;
    private JButton visualizzaTesiInCorsoButton;
    private JButton indietroButton;
    private JPanel panelDocenteHome;
    private JFrame frame;
    private Controller controller;

    /**
     * Instantiates a new Docente home.
     *
     * @param frameChiamante the frame chiamante
     * @param controller     the controller
     */
    public DocenteHome(JFrame frameChiamante, Controller controller) {
        this.controller = controller;
        frame = new JFrame("Home Docente");
        frame.setContentPane(panelDocenteHome);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null); //Questo metodo serve per far avviare la schermata al centro dello schermo.

        aggiungiTirocinioButton.addActionListener(new ActionListener() { // NOSONAR
            @Override
            public void actionPerformed(ActionEvent e) {
                new AggiungiNuovoArgomento(frame,controller);
                frame.setVisible(false);
            }
        });

        visualizzaElencoDelleRichiesteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ElencoRichiesteTirocinio(frame,controller);
                frame.setVisible(false);
            }
        });

        visualizzaTirocininantiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ElencoTirocinanti(frame,controller);
                frame.setVisible(false);
            }
        });
        visualizzaTesiInCorsoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ElencoTesisti(frame,controller);
                frame.setVisible(false);
            }
        });
        indietroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameChiamante.setVisible(true);
                frame.dispose();
            }
        });
    }
}
