package gui;

import controller.Controller;
import model.Stato;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ElencoTesisti {
    private JButton ritornaAllaHomeButton;
    private JPanel panelElencoTesisti;
    private JScrollBar scrollBar1;
    private JTable table1;
    private JButton approvaButton;
    private JButton rifiutaButton;
    private JButton leggiTesiButton;
    private JFrame frame;
    private Controller controller;

    public ElencoTesisti(JFrame frameChiamante, Controller controller) {
        this.controller = controller;
        frame = new JFrame("Elenco Tesisti");
        frame.setContentPane(panelElencoTesisti);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null); //Questo metodo serve per far avviare la schermata al centro dello schermo.
        ritornaAllaHomeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameChiamante.setVisible(true);
                frame.dispose();
            }
        });

        // Creo la tabella per visualizzare i Tesisti
        table1.setModel(new DefaultTableModel(
                new Object[][] {},
                new String[] {"Studente", "Matricola", "Titolo", "Contenuto"}
        ));
        DefaultTableModel model = (DefaultTableModel) table1.getModel();

        ArrayList<String> listaNomiStudenti = controller.getStudentiTesi();
        ArrayList<String> listaMatricole = controller.getMatricoleTesi();
        ArrayList<String> listaTitoli = controller.getTitoliTesi();
        ArrayList<String> listaContenuti = controller.getContenutoTesi();
        if (listaNomiStudenti != null) {
            for (int i = 0; i < listaNomiStudenti.size(); i++) {
                model.addRow(new Object[]{ listaNomiStudenti.get(i), listaMatricole.get(i), listaTitoli.get(i), listaContenuti.get(i) });
            }
        }

        leggiTesiButton.addActionListener(e -> {
            int riga = table1.getSelectedRow();
            if(riga >= 0) {
                String contenutoTesi = controller.getContenutoTesiSingola(listaMatricole.get(riga));

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
                if (rigaSelezionata < 0) {
                    JOptionPane.showMessageDialog(frame,"Selezionare prima una richiesta dalla tabella.","Errore",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                // Il controller aggiorna lo stato in base alla riga cliccata
                controller.modificaStatoTesi(rigaSelezionata,Stato.APPROVATA, listaMatricole.get(rigaSelezionata));
                model.removeRow(rigaSelezionata);
                JOptionPane.showMessageDialog(frame,"Tesi approvata con successo.");
            }
        });

        rifiutaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rigaSelezionata = table1.getSelectedRow();
                if (rigaSelezionata < 0) {
                    JOptionPane.showMessageDialog(frame,"Selezionare prima una richiesta dalla tabella.","Errore",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                // Il controller aggiorna lo stato in base alla riga cliccata
                controller.modificaStatoTesi(rigaSelezionata,Stato.RIFIUTATA,listaMatricole.get(rigaSelezionata));
                model.removeRow(rigaSelezionata);
                JOptionPane.showMessageDialog(frame,"Tesi non approvata.");
            }
        });
    }
}
