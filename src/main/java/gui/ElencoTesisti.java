package gui;

import controller.Controller;
import model.Stato;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * La classe che implementa la GUI riguardo la schermata che mostra l'elenco dei Tesisti.
 */
public class ElencoTesisti {
    private JButton ritornaAllaHomeButton;
    private JPanel panelElencoTesisti;
    private JTable table1;
    private JButton approvaButton;
    private JButton rifiutaButton;
    private JButton leggiTesiButton;
    private JScrollBar scrollBar1; // NOSONAR
    private JFrame frame;
    private Controller controller;

    private static final String TITOLO_ERRORE = "Errore";
    private static final String MESSAGGIO_RIGA_NON_SELEZIONATA = "Selezionare prima una richiesta dalla tabella.";

    /**
     * Costruttore di una nuova schermata ElencoTesisti.
     *
     * @param frameChiamante Il frame che chiama la nuova schermata.
     * @param controller     Il controller.
     */
    public ElencoTesisti(JFrame frameChiamante, Controller controller) {
        this.controller = controller;
        frame = new JFrame("Elenco Tesisti");
        frame.setContentPane(panelElencoTesisti);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);//Questo metodo serve per far avviare la schermata al centro dello schermo.

        ritornaAllaHomeButton.addActionListener(new ActionListener() { // NOSONAR
            @Override
            public void actionPerformed(ActionEvent e) {
                frameChiamante.setVisible(true);
                frame.dispose();
            }
        });

        // Creo la tabella per visualizzare i Tesisti
        table1.setModel(new DefaultTableModel(
                new Object[][] {},
                new String[] {"Nome Studente", "Matricola", "Titolo", "Contenuto"}
        ));

        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Rende tutte le celle non modificabili graficamente
            }
        };
        table1.setRowHeight(30);
        model.addColumn("Nome Studente");
        model.addColumn("Matricola");
        model.addColumn("Titolo");
        model.addColumn("Contenuto");
        model.addColumn("Data Seduta");

        // Chiamiamo il metodo del controller
        List<String[]> righeDalDataBase = controller.getDatiTabellaTesisti();
        for(String [] riga : righeDalDataBase) {
            model.addRow(riga);
        }
        table1.setModel(model);


        leggiTesiButton.addActionListener(e -> {
            int rigaSelezionata = table1.getSelectedRow();
            if (rigaSelezionata < 0) {
                JOptionPane.showMessageDialog(frame,MESSAGGIO_RIGA_NON_SELEZIONATA,TITOLO_ERRORE,JOptionPane.ERROR_MESSAGE);
                return;
            }
            if(rigaSelezionata >= 0) {
                String matricola = table1.getValueAt(rigaSelezionata,1).toString();
                String contenutoTesi = controller.getContenutoTesiSingola(matricola);

                // Creiamo una JTextArea al volo solo per leggerla
                JTextArea areaTesto = new JTextArea(contenutoTesi);
                areaTesto.setLineWrap(true);
                areaTesto.setWrapStyleWord(true);
                areaTesto.setEditable(false); // Il prof non può modificarla!

                JScrollPane scrollPane = new JScrollPane(areaTesto);
                scrollPane.setPreferredSize(new Dimension(500, 300));

                JOptionPane.showMessageDialog(null, scrollPane, "Lettura Tesi", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        approvaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rigaSelezionata = table1.getSelectedRow();
                String matricola = table1.getValueAt(rigaSelezionata,1).toString();
                if (rigaSelezionata < 0) {
                    JOptionPane.showMessageDialog(frame,MESSAGGIO_RIGA_NON_SELEZIONATA,TITOLO_ERRORE,JOptionPane.ERROR_MESSAGE);
                    return;
                }
                // Il controller aggiorna lo stato in base alla riga cliccata
                if(controller.modificaStatoTesi(Stato.APPROVATA,matricola)){
                    model.removeRow(rigaSelezionata);
                    JOptionPane.showMessageDialog(frame,"Tesi approvata con successo.");
                } else{
                    JOptionPane.showMessageDialog(frame,"Modifica stato tesi fallita.",TITOLO_ERRORE,JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        rifiutaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rigaSelezionata = table1.getSelectedRow();
                String matricola = table1.getValueAt(rigaSelezionata,1).toString();
                if (rigaSelezionata < 0) {
                    JOptionPane.showMessageDialog(frame,MESSAGGIO_RIGA_NON_SELEZIONATA,TITOLO_ERRORE,JOptionPane.ERROR_MESSAGE);
                    return;
                }
                // Il controller aggiorna lo stato in base alla riga cliccata
                if(controller.modificaStatoTesi(Stato.RIFIUTATA,matricola)){
                    model.removeRow(rigaSelezionata);
                    JOptionPane.showMessageDialog(frame,"Tesi rifiutata.");
                } else{
                    JOptionPane.showMessageDialog(frame,MESSAGGIO_RIGA_NON_SELEZIONATA,TITOLO_ERRORE,JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
