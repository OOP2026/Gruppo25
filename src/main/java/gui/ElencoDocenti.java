package gui;

import controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ElencoDocenti {
    private JScrollBar scrollBar1;
    private JList docentilist1;
    private JList argomentilist2;
    private JButton OKButton;
    private JLabel TitoloListaDocentiJLabel;
    private JLabel TitoloListaArgomentiJLabel;
    private JButton annullaButton;
    private JPanel panelElencoDocenti;
    private JFrame frame;
    private final Controller controller;

    public ElencoDocenti(JFrame FrameChiamante) {
        controller = new Controller();
        argomentilist2.setModel(controller.ottieniModelloArgomenti());
        frame = new JFrame("Elenco Docenti");
        frame.setContentPane(panelElencoDocenti);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null); //Questo metodo serve per far avviare la schermata al centro dello schermo.

        // Aggiorniamo la lista che lo studente può vedere degli argomenti aggiunti dai docenti con il metodo setModel, passandogli
        // la stringa ottenuta ancora dal metodo del controller ottieniModelArgomenti.
        argomentilist2.setModel(controller.ottieniModelloArgomenti());

        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // LISTENER RIFERITO AL BOTTONE OK DELLA SCHERMATA ELENCO DOCENTI
                FrameChiamante.setVisible(true);
                frame.dispose();
            }
        });

    }
}
