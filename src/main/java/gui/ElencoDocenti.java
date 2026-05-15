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

    public ElencoDocenti() {
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // LISTENER RIFERITO AL BOTTONE OK DELLA SCHERMATA ELENCO DOCENTI

            }
        });
        annullaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // PULSANTE DELLA SCHERMATA ELENCO DOCENTI PER RITORNARE INDIETRO
            }
        });
    }
}
