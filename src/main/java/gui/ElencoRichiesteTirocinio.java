package gui;

import controller.Controller;
import model.Stato;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * La classe che implementa la GUI riguardo la schermata che mostra tutte le richieste di Tirocinio ricevute dagli Studenti.
 */
public class ElencoRichiesteTirocinio {
    private JButton ritornaAllaHomeButton;
    private JPanel panelElencoRichiesteTirocinio;
    private JTable table1;
    private JButton accettaButton;
    private JButton rifiutaButton;
    private JScrollBar scrollBar1; // NOSONAR
    private JFrame frame;
    private Controller controller;

    private static final String TITOLO_ERRORE = "Errore";

    /**
     * Costruttore di una nuova schermata ElencoRichiesteTirocinio.
     *
     * @param frameChiamante Il frame che chiama la nuova schermata.
     * @param controller     Il controller.
     */
    public ElencoRichiesteTirocinio(JFrame frameChiamante, Controller controller) {
        this.controller = controller;
        frame = new JFrame("Elenco Richieste di Tirocinio");
        frame.setContentPane(panelElencoRichiesteTirocinio);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null); //Questo metodo serve per far avviare la schermata al centro dello schermo.

        ritornaAllaHomeButton.addActionListener(new ActionListener() { // NOSONAR
            @Override
            public void actionPerformed(ActionEvent e) {
                frameChiamante.setVisible(true);
                frame.dispose();
            }
        });

        // Creo la tabella per visualizzare le richieste dei tirocini
        table1.setModel(new DefaultTableModel(
                new Object[][] {},
                new String[]{"Nome Studente", "Matricola", "Argomento Tirocinio","Nome Azienda", "ID Azienda","Id Richiesta Tirocinio"}
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
        model.addColumn("Argomento Tirocinio");
        model.addColumn("Nome Azienda");
        model.addColumn("Nominativo Referente");



        //Chiamo il controller per farmi dare le righe della tabella
        List<String[]> righeDalDatabase = controller.getDatiTabellaRichiesteTirocinio();
        for (String[] riga : righeDalDatabase) {
            model.addRow(riga);
        }
        table1.setModel(model);

        accettaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rigaSelezionata = table1.getSelectedRow();
                if (rigaSelezionata < 0) {
                    JOptionPane.showMessageDialog(frame,"Selezionare prima una richiesta dalla tabella.",TITOLO_ERRORE,JOptionPane.ERROR_MESSAGE);
                    return;
                }
                String matricolaStudente = (String) table1.getValueAt(rigaSelezionata, 1);
                String argomentoTirocinio = (String) table1.getValueAt(rigaSelezionata, 2);
                String nomeAzienda = (String) table1.getValueAt(rigaSelezionata, 3);
                String nominativoreferente = (String)  table1.getValueAt(rigaSelezionata, 4);
                if((controller.modificaStatoRichiesta(matricolaStudente,Stato.APPROVATA)) && controller.setTirocinio(nomeAzienda,nominativoreferente,argomentoTirocinio,matricolaStudente)){
                    // Il controller aggiorna lo stato in base alla riga cliccata
                    model.removeRow(rigaSelezionata);
                    JOptionPane.showMessageDialog(frame,"Richiesta approvata con successo, tirocinante aggiunto all'elenco.");

                } else{
                    JOptionPane.showMessageDialog(frame,"Errore nella modifica dello stato nel DataBase.",TITOLO_ERRORE,JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        rifiutaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rigaSelezionata = table1.getSelectedRow();
                if (rigaSelezionata < 0) {
                    JOptionPane.showMessageDialog(frame,"Selezionare prima una richiesta dalla tabella.",TITOLO_ERRORE,JOptionPane.ERROR_MESSAGE);
                    return;
                }
                String matricolaStudente = (String) table1.getValueAt(rigaSelezionata, 1);
                if(controller.modificaStatoRichiesta(matricolaStudente,Stato.RIFIUTATA)){
                    // Il controller aggiorna lo stato in base alla riga cliccata
                    model.removeRow(rigaSelezionata);
                    JOptionPane.showMessageDialog(frame,"Richiesta rifiutata.");
                } else{
                    JOptionPane.showMessageDialog(frame,"Errore nella modifica dello stato nel DataBase.",TITOLO_ERRORE,JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
