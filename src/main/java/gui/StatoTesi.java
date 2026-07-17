package gui;
import controller.Controller;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * La classe che implementa la GUI riguardo la schermata per controllare lo Stato della Tesi.
 */
public class StatoTesi {
    private JTable table1;
    private JButton ritornaAllaHomeButton;
    private JPanel panelTesi;
    private JFrame frame;
    private Controller controller;

    private static final String STATO_TESI = "Stato Tesi";

    /**
     * Costruttore di una nuova schermata StatoTesi.
     *
     * @param frameChiamante Il frame che chiama la nuova schermata.
     * @param controller     Il controller.
     */
    public StatoTesi(JFrame frameChiamante,Controller controller) {
        this.controller = controller;
        frame = new JFrame(STATO_TESI);
        frame.setContentPane(panelTesi);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        ritornaAllaHomeButton.addActionListener(new ActionListener() { // NOSONAR
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                frameChiamante.setVisible(true);
                frame.dispose();
            }
        });

        // Creo la tabella per visualizzare lo stato della tesi.
        table1.setModel(new DefaultTableModel(
                new Object[][] {},
                new String[]{"Titolo", "Contenuto","Data Seduta" , "Docente", STATO_TESI}
        ));
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Rende tutte le celle non modificabili graficamente
            }
        };
        table1.setRowHeight(30);
        model.addColumn("Titolo");
        model.addColumn("Contenuto");
        model.addColumn("Docente");
        model.addColumn("Data Seduta");
        model.addColumn(STATO_TESI);


        // Chiamiamo il metodo del controller
        List<String[]> righeDalDataBase = controller.getStatoTesiStudente();
        for(String [] riga : righeDalDataBase) {
            model.addRow(riga);
        }
        table1.setModel(model);
        }
}
