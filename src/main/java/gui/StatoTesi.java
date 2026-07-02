package gui;
import controller.Controller;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class StatoTesi {
    private JTable table1;
    private JButton ritornaAllaHomeButton;
    private JPanel panelTesi;
    private JFrame frame;
    private Controller controller;

    public  StatoTesi(JFrame frameChiamante,Controller controller) {
        this.controller = controller;
        frame = new JFrame("Stato Tesi");
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
                new String[]{"Titolo", "Contenuto","Data Seduta" , "Docente", "Stato Tesi"}
        ));
        DefaultTableModel model = new  DefaultTableModel();
        table1.setRowHeight(30);
        model.addColumn("Titolo");
        model.addColumn("Contenuto");
        model.addColumn("Docente");
        model.addColumn("Data Seduta");
        model.addColumn("Stato Tesi");


        // Chiamiamo il metodo del controller
        List<String[]> righeDalDataBase = controller.getStatoTesiStudente();
        for(String [] riga : righeDalDataBase) {
            model.addRow(riga);
        }
        table1.setModel(model);
        }
}
