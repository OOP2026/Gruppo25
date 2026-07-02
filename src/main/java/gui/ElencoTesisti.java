package gui;

import controller.Controller;
import model.Stato;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

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

        DefaultTableModel model = new DefaultTableModel();
        table1.setRowHeight(30);
        model.addColumn("Nome Studente");
        model.addColumn("Matricola");
        model.addColumn("Titolo");
        model.addColumn("Contenuto");

        // Chiamiamo il metodo del controller
        List<String[]> righeDalDataBase = controller.getDatiTabellaTesisti();
        for(String [] riga : righeDalDataBase) {
            model.addRow(riga);
        }
        table1.setModel(model);


        leggiTesiButton.addActionListener(e -> {
            int riga = table1.getSelectedRow();
            if(riga >= 0) {
                String matricola = table1.getValueAt(riga,1).toString();
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
                    JOptionPane.showMessageDialog(frame,"Selezionare prima una richiesta dalla tabella.","Errore",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                // Il controller aggiorna lo stato in base alla riga cliccata
                if(controller.modificaStatoTesi(Stato.APPROVATA,matricola)){
                    model.removeRow(rigaSelezionata);
                    JOptionPane.showMessageDialog(frame,"Tesi approvata con successo.");
                } else{
                    JOptionPane.showMessageDialog(frame,"Modifica stato tesi fallita.","Errore",JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        rifiutaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rigaSelezionata = table1.getSelectedRow();
                String matricola = table1.getValueAt(rigaSelezionata,1).toString();
                if (rigaSelezionata < 0) {
                    JOptionPane.showMessageDialog(frame,"Selezionare prima una richiesta dalla tabella.","Errore",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                // Il controller aggiorna lo stato in base alla riga cliccata
                if(controller.modificaStatoTesi(Stato.RIFIUTATA,matricola)){
                    model.removeRow(rigaSelezionata);
                    JOptionPane.showMessageDialog(frame,"Tesi rifiutata.");
                } else{
                    JOptionPane.showMessageDialog(frame,"Modifica stato tesi fallita.","Errore",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
