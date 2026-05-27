package gui;

import controller.Controller;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ElencoDocenti {
    private JScrollBar scrollBar1;
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


        IndietroButton.addActionListener(new ActionListener() { // NOSONAR
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
                new String[] { "Nome Docente", "Argomento Tirocinio", "Tipologia Tirocinio", "Nome Azienda", "Nominativo Referente" } // Intestazioni
        ));

        DefaultTableModel model = (DefaultTableModel) table1.getModel();

        List<String> listaNomi = controller.getNomiDocentiPerTabella();
        List<String> listaArgomenti = controller.getArgomentiPerTabella();
        List<String> listaTipologieTirocinio = controller.getTipologiePerTabella();
        List<String> listaAzienda = controller.getNomiAziendaPerTabella();
        List<String> listaReferenti = controller.getReferentePerTabella();

        if (listaNomi != null) {
            for (int i = 0; i < listaNomi.size(); i++) {
                model.addRow(new Object[]{ listaNomi.get(i), listaArgomenti.get(i), listaTipologieTirocinio.get(i), listaAzienda.get(i), listaReferenti.get(i) });
            }
        }

    }
}
