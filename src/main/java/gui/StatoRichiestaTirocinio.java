package gui;

import controller.Controller;
import model.RichiestaTirocinio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class StatoRichiestaTirocinio {
    private JButton OKButton;
    private JPanel panelStatoRichiestaTirocinio;
    private JTable tableStatoRichiesta;
    private JFrame frame;
    private Controller controller;

    public StatoRichiestaTirocinio(JFrame FrameChiamante, Controller controller) {
        this.controller = controller;
        frame = new JFrame("Stato Richiesta Tirocinio");
        frame.setContentPane(panelStatoRichiestaTirocinio);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null); //Questo metodo serve per far avviare la schermata al centro dello schermo.

        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // LISTENER DEL PULSANTE OK DELLA SCHERMATA DELLO STATO DELLA RICHIESTA DI TIROCINIO
                FrameChiamante.setVisible(true);
                frame.dispose();
            }
        });

        // Creo la tabella per visualizzare lo stato della richiesta.
        tableStatoRichiesta.setModel(new DefaultTableModel(
                new Object[][] {},
                new String[]{"Docente", "Stato della Richiesta"}
        ));
        DefaultTableModel model = (DefaultTableModel) tableStatoRichiesta.getModel();

        List<RichiestaTirocinio> richiesteModello = controller.getRichiestaTirocinio();
        for(RichiestaTirocinio r : richiesteModello){
            if(r.getStudente().equals(controller.getStudenteLoggato())){
                model.addRow(new Object[]{
                        r.getDocente().getCognome() + " " + r.getDocente().getNome(),
                        r.getStatoRichiesta()
                });
            }
        }

    }
}
