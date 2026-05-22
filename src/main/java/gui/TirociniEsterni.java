package gui;

import controller.Controller;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TirociniEsterni {
    private Controller controller;
    private JPanel panelInfoTirociniEsterni;
    private JTable table1;
    private JButton OKButton;
    private static JFrame frame;

    public TirociniEsterni(JFrame FrameChiamante, Controller controller){
            this.controller = controller;
            frame = new JFrame("Info Tirocini Esterni");
            frame.setContentPane(panelInfoTirociniEsterni);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
            frame.setLocationRelativeTo(null); //Questo metodo serve per far avviare la schermata al centro dello schermo.

        // Creo la tabella per visualizzare lo stato della richiesta.
        table1.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{"Docente" , "Argomento", "Nome Azienda", "Nominativo Referente"}
        ));
        DefaultTableModel model = (DefaultTableModel) table1.getModel();

        ArrayList<String> listaNomi = controller.getNomiDocentiPerTabella();
        ArrayList<String> listaArgomenti = controller.getArgomentiPerTabella();
        ArrayList<String> listaAzienda = controller.getNomiAziendaPerTabella();
        ArrayList<String> listaReferenti = controller.getReferentePerTabella();

        if (listaNomi != null) {
            for (int i = 0; i < listaNomi.size(); i++) {
                model.addRow(new Object[]{listaNomi.get(i), listaArgomenti.get(i), listaAzienda.get(i), listaReferenti.get(i)});
            }
        }
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // LISTENER DEL PULSANTE OK DELLA SCHERMATA DELLO STATO DELLA RICHIESTA DI TIROCINIO
                FrameChiamante.setVisible(true);
                frame.dispose();
            }
        });
    }

}
