package gui;

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


    public ElencoDocenti(JFrame FrameChiamante) {
        frame = new JFrame("Elenco Docenti");
        frame.setContentPane(panelElencoDocenti);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
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
