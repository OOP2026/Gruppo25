package gui;

import controller.Controller;
import model.Studente;

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

        ArrayList<String> listaNomiStudenti = controller.getNomiStudentiPerTabella();
        ArrayList<String> listaMatricole = controller.getMatricolaStudentiPerTabella();
        ArrayList<String> listaArgomenti = controller.getArgomentiStudentiPerTabella();

        if (listaNomiStudenti != null) {
            for (int i = 0; i < listaNomiStudenti.size(); i++) {
                String matricola = listaMatricole.get(i);
                if(controller.controlloRichiestaAccettata(matricola)){
                    model.addRow(new Object[]{ listaNomiStudenti.get(i), listaMatricole.get(i), listaArgomenti.get(i) });
                }
            }
        }

    }
}
