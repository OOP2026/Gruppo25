package gui;

import controller.Controller;
import model.Stato;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ElencoTirocinanti {
    private JButton ritornaAllaHomeButton;
    private JTable tabellaStudenteArgomentoTirocinio;
    private JPanel panelElencoTirocinanti;
    private JScrollBar scrollBar1;
    private JButton terminaTirocinioButton;
    private JFrame frame;
    private Controller controller;

    public ElencoTirocinanti(JFrame FrameChiamante, Controller controller) {
        this.controller = controller;
        frame = new JFrame("Elenco Tirocinanti");
        frame.setContentPane(panelElencoTirocinanti);
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

        // Creo la tabella per visualizzare gli Studenti con un tirocinio in corso (ovvero la quale richiesta è stata accettata).
        tabellaStudenteArgomentoTirocinio.setModel(new DefaultTableModel(
                new Object[][] {},
                new String[]{"Studente" , "Matricola" , "Argomento"}
        ));
        DefaultTableModel model = (DefaultTableModel) tabellaStudenteArgomentoTirocinio.getModel();

        ArrayList<String> listaNomiStudentiApprovati = controller.getNomiTirocinantiApprovati();
        ArrayList<String> listaMatricoleApprovati = controller.getMatricoleTirocinantiApprovati();
        ArrayList<String> listaArgomentiApprovati = controller.getArgomentiTirocinantiApprovati();

        if (listaNomiStudentiApprovati != null) {
            for (int i = 0; i < listaNomiStudentiApprovati.size(); i++) {
                    model.addRow(new Object[]{ listaNomiStudentiApprovati.get(i), listaMatricoleApprovati.get(i), listaArgomentiApprovati.get(i) });
                }
            }


        terminaTirocinioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rigaSelezionata = tabellaStudenteArgomentoTirocinio.getSelectedRow();
                if (rigaSelezionata < 0) {
                    JOptionPane.showMessageDialog(frame,"Selezionare prima un tirocinio dalla tabella.","Errore",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                // Il controller aggiorna lo stato in base alla riga cliccata
                controller.setTerminaTirocinio(rigaSelezionata);
                model.removeRow(rigaSelezionata);
                JOptionPane.showMessageDialog(frame,"Tirocinio terminato con successo.");
            }
        });
    }

}
