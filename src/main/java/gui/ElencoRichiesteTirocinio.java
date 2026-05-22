package gui;

import controller.Controller;
import model.Stato;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ElencoRichiesteTirocinio {
    private JButton ritornaAllaHomeButton;
    private JPanel panelElencoRichiesteTirocinio;
    private JTable table1;
    private JButton accettaButton;
    private JButton rifiutaButton;
    private JScrollBar scrollBar1;
    private JFrame frame;
    private Controller controller;

    public ElencoRichiesteTirocinio(JFrame FrameChiamante, Controller controller) {
        this.controller = controller;
        frame = new JFrame("Elenco Richieste di Tirocinio");
        frame.setContentPane(panelElencoRichiesteTirocinio);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null); //Questo metodo serve per far avviare la schermata al centro dello schermo.

        ritornaAllaHomeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrameChiamante.setVisible(true);
                frame.dispose();
            }
        });

        // Creo la tabella per visualizzare le richieste dei tirocini
        table1.setModel(new DefaultTableModel(
                new Object[][] {},
                new String[]{"Nome Studente", "Matricola", "Argomento Tirocinio"}
        ));

        DefaultTableModel model = (DefaultTableModel) table1.getModel();

        ArrayList<String> listaNomi = controller.getNomiStudentiPerTabella();
        ArrayList<String> listaMatricole = controller.getMatricolaStudentiPerTabella();
        ArrayList<String> listaArgomenti = controller.getArgomentiStudentiPerTabella();

        if (listaNomi != null) {
            for (int i = 0; i < listaNomi.size(); i++) {
                model.addRow(new Object[]{ listaNomi.get(i), listaMatricole.get(i), listaArgomenti.get(i) });
            }
        }

        accettaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rigaSelezionata = table1.getSelectedRow();
                if (rigaSelezionata < 0) {
                    JOptionPane.showMessageDialog(frame,"Selezionare prima una richiesta dalla tabella.");
                    return;
                }
                // Il controller aggiorna lo stato in base alla riga cliccata
                controller.modificaStatoRichiesta(rigaSelezionata, Stato.APPROVATA);
                model.removeRow(rigaSelezionata);
                JOptionPane.showMessageDialog(frame,"Richiesta approvata con successo.");
            }
        });

        rifiutaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rigaSelezionata = table1.getSelectedRow();
                if (rigaSelezionata < 0) {
                    JOptionPane.showMessageDialog(frame,"Selezionare prima una richiesta dalla tabella");
                    return;
                }
                // Il controller aggiorna lo stato in base alla riga cliccata
                controller.modificaStatoRichiesta(rigaSelezionata, Stato.RIFIUTATA);
                model.removeRow(rigaSelezionata);
                JOptionPane.showMessageDialog(frame,"Richiesta rifiutata con successo.");
            }
        });
    }
}
