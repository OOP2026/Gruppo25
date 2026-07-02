package gui;

import controller.Controller;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * The type Stato richiesta tirocinio.
 */
public class StatoRichiestaTirocinio {
    private JButton okbutton;
    private JPanel panelStatoRichiestaTirocinio;
    private JTable tableStatoRichiesta;
    private JFrame frame;
    private Controller controller;

    /**
     * Instantiates a new Stato richiesta tirocinio.
     *
     * @param frameChiamante the frame chiamante
     * @param controller     the controller
     */
    public StatoRichiestaTirocinio(JFrame frameChiamante, Controller controller) {
        this.controller = controller;
        frame = new JFrame("Stato Richiesta Tirocinio");
        frame.setContentPane(panelStatoRichiestaTirocinio);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null); //Questo metodo serve per far avviare la schermata al centro dello schermo.

        okbutton.addActionListener(new ActionListener() { // NOSONAR
            @Override
            public void actionPerformed(ActionEvent e) {
                // LISTENER DEL PULSANTE OK DELLA SCHERMATA DELLO STATO DELLA RICHIESTA DI TIROCINIO
                frameChiamante.setVisible(true);
                frame.dispose();
            }
        });

        // Creo la tabella per visualizzare lo stato della richiesta.
        tableStatoRichiesta.setModel(new DefaultTableModel(
                new Object[][] {},
                new String[]{"Docente","Argomento", "Stato Richiesta"}
        ));

        DefaultTableModel model = new DefaultTableModel();
        tableStatoRichiesta.setRowHeight(30);
        tableStatoRichiesta.doLayout();
        model.addColumn("Docente");
        model.addColumn("Argomento");
        model.addColumn("Stato Richiesta");


        //Chiamo il metodo del controller
        List<String[]> righeDalDataBase = controller.getRichiestaTirocinioStudente();
        for(String [] riga : righeDalDataBase) {
            model.addRow(riga);
        }
        tableStatoRichiesta.setModel(model);
    }
}
