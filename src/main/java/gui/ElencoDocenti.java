package gui;

import controller.Controller;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ElencoDocenti {
    private JButton indietroButton;
    private JPanel panelElencoDocenti;
    private JTable table1;
    private JScrollBar scrollBar1; // NOSONAR
    private JFrame frame;
    private Controller controller;

    public ElencoDocenti(JFrame frameChiamante, Controller controller) {
        this.controller = controller;
        frame = new JFrame("Elenco Docenti");
        frame.setContentPane(panelElencoDocenti);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null); //Questo metodo serve per far avviare la schermata al centro dello schermo.


        indietroButton.addActionListener(new ActionListener() { // NOSONAR
            @Override
            public void actionPerformed(ActionEvent e) {
                // LISTENER RIFERITO AL BOTTONE OK DELLA SCHERMATA ELENCO DOCENTI
                frameChiamante.setVisible(true);
                frame.dispose();
            }
        });

        // Creo la tabella per visualizzare docenti e argomenti dei tirocini
        table1.setModel(new DefaultTableModel(
                new Object[][] {}, // Nessun dato iniziale
                new String[] { "Nome Docente", "Argomento Tirocinio", "Nome Azienda", "Nominativo Referente" } // Intestazioni
        ));

        // 1. Crei il modello della tua tabella
        DefaultTableModel model = new DefaultTableModel();
        table1.setRowHeight(30);
        model.addColumn("Docente");
        model.addColumn("Email");
        model.addColumn("Argomento");
        model.addColumn("Azienda");

// 2. Chiami il Controller per farti dare TUTTE le righe già pronte
        List<String[]> righeDalDatabase = controller.getDatiTabellaElencoTirocini();

// 3. Aggiungi le righe al modello
        for (String[] riga : righeDalDatabase) {
            model.addRow(riga);
        }

// 4. Assegni il modello alla tua JTable grafica
        table1.setModel(model);

    }
}
