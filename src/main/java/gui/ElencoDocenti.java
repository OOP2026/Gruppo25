package gui;

import controller.Controller;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ElencoDocenti {
    private JScrollBar scrollBar1;
    private JList argomentilist2;
    private JButton IndietroButton;
    private JPanel panelElencoDocenti;
    private JTable table1;
    private JFrame frame;
    private Controller controller;

    public ElencoDocenti(JFrame FrameChiamante, Controller controller) {
        this.controller = controller;
        frame = new JFrame("Elenco Docenti");
        frame.setContentPane(panelElencoDocenti);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null); //Questo metodo serve per far avviare la schermata al centro dello schermo.


        IndietroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // LISTENER RIFERITO AL BOTTONE OK DELLA SCHERMATA ELENCO DOCENTI
                FrameChiamante.setVisible(true);
                frame.dispose();
            }
        });

        // Creo la tabella per visualizzare docenti e argomenti dei tirocini
        table1.setModel(new DefaultTableModel(
                new Object[][] {}, // Nessun dato iniziale
                new String[] { "Nome Docente", "Argomento Tirocinio", "Tipologia Tirocinio" } // Intestazioni
        ));

        DefaultTableModel model = (DefaultTableModel) table1.getModel();

        ArrayList<String> listaNomi = controller.getNomiDocentiPerTabella();
        ArrayList<String> listaArgomenti = controller.getArgomentiPerTabella();
        ArrayList<String> listaTipologieTirocinio = controller.getTipologiePerTabella();

        if (listaNomi != null) {
            for (int i = 0; i < listaNomi.size(); i++) {
                model.addRow(new Object[]{ listaNomi.get(i), listaArgomenti.get(i), listaTipologieTirocinio.get(i) });
            }
        }

    }
}
