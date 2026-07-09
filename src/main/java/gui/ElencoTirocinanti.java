package gui;

import controller.Controller;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * La classe che implementa la GUI riguardo la schermata che mostra l'elenco dei tirocinanti.
 */
public class ElencoTirocinanti {
    private JButton ritornaAllaHomeButton;
    private JTable tabellaStudenteArgomentoTirocinio;
    private JPanel panelElencoTirocinanti;
    private JButton terminaTirocinioButton;
    private JScrollBar scrollBar1; // NOSONAR
    private JFrame frame;
    private Controller controller;

    /**
     * Costruttore di una nuova schermata ElencoTesisti.
     *
     * @param frameChiamante Il frame che chiama la nuova schermata.
     * @param controller     Il controller.
     */
    public ElencoTirocinanti(JFrame frameChiamante, Controller controller) {
        this.controller = controller;
        frame = new JFrame("Elenco Tirocinanti");
        frame.setContentPane(panelElencoTirocinanti);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

        // Creo la tabella per visualizzare gli Studenti con un tirocinio in corso (ovvero la quale richiesta è stata accettata).
        tabellaStudenteArgomentoTirocinio.setModel(new DefaultTableModel(
                new Object[][] {},
                new String[]{"Nome Studente" , "Matricola" , "Nome Azienda", "Referente", "Argomento"}
        ));

        DefaultTableModel model = new DefaultTableModel();
        tabellaStudenteArgomentoTirocinio.setRowHeight(30);
        model.addColumn("Nome Studente");
        model.addColumn("Matricola");
        model.addColumn("Nome Azienda");
        model.addColumn("Referente");
        model.addColumn("Argomento");

        // Chiamiamo il metodo del controller
        List<String[]> righeDalDataBase = controller.getDatiTabellaTirocinanti();
        for(String [] riga : righeDalDataBase) {
            model.addRow(riga);
        }
        tabellaStudenteArgomentoTirocinio.setModel(model);





        terminaTirocinioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rigaSelezionata = tabellaStudenteArgomentoTirocinio.getSelectedRow();
                if (rigaSelezionata < 0) {
                    JOptionPane.showMessageDialog(frame,"Selezionare prima un tirocinio dalla tabella.","Errore",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                String matricola = tabellaStudenteArgomentoTirocinio.getValueAt(rigaSelezionata,1).toString();
                // Il controller aggiorna lo stato in base alla riga cliccata
                if(controller.setTerminaTirocinio(matricola)){
                    model.removeRow(rigaSelezionata);
                    JOptionPane.showMessageDialog(frame,"Tirocinio terminato con successo.");
                } else {
                    JOptionPane.showMessageDialog(frame,"Errore nella connesione con il DataBase.","Errore",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

}
