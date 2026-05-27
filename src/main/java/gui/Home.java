package gui;

import controller.Controller;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame {
    public static JFrame frame;
    private JButton registratiComeStudenteRButton;
    private JTextField loginTextField;
    private JPasswordField passwordPasswordField;
    private JButton registratiComeDocenteButton;
    private JPanel panelHome;
    private JButton inviaButton;
    private final transient Controller controller;

    public static void main(String[] args) {
       // TRY-CATCH PER SETTARE LA GUI IN BASE AL TEMA DELLA MACCHINA.
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        frame = new JFrame("Home"); // finestra nella quale ci sono gli elementi da visualizzare, qui è incluso anche il JPanel, e attraverso questo possiamo specificare il contenuto delle GUI
        frame.setContentPane(new Home().panelHome);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        //frame.setLocation(300,300); Questo metodo serve per far avviare l'applicazione in un determinato punto dello schermo.
        frame.setLocationRelativeTo(null); //Questo metodo serve per far avviare la schermata al centro dello schermo.
        //frame.setResizable(false); //Questo metodo permetto(o non) di far ingrandire la schermata.


    }

    public Home() {
        controller = new Controller();

        registratiComeStudenteRButton.addActionListener(new ActionListener() { // NOSONAR
            @Override
            public void actionPerformed(ActionEvent e) {
                // LISTENER RIFERITO AL PULSANTE PER REGISTRARSI COME STUDENTE
                new RegistrazioneStudente(frame,controller);
                frame.setVisible(false);
            }
        });
        registratiComeDocenteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // LISTENER RIFERITO AL PULSANTE PER REGISTRARSI COME DOCENTE.
                new RegistrazioneDocente(frame,controller);
                frame.setVisible(false);
            }
        });

        inviaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // LISTENER PER ACCEDERE ALL'ACCOUNT E ANDARE NELLA HOME DOCENTE OPPURE STUDENTE.
                String login = loginTextField.getText().trim();
                String password = new String(passwordPasswordField.getPassword()).trim();
                // CONTROLLO PER CONVALIDARE SE I CAMPI LOGIN E PASSWORD NON SONO VUOTI.
                if(login.isEmpty() || password.isEmpty()){
                    JOptionPane.showMessageDialog(frame,"Ci sono dei campi vuoti.","Errore", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                String ruolo = controller.effettuaLogin(login, password);
                // CONTROLLO PER VERIFICARE SE L'ACCESSO LO FA UNO STUDENTE O UN DOCENTE.
                if (ruolo.equals("STUDENTE")) {
                    JOptionPane.showMessageDialog(frame, "Accesso eseguito come studente.");
                    // ora possiamo aprire la HomeStudente
                    new StudenteHome(frame,controller);
                    frame.setVisible(false);

                } else if (ruolo.equals("DOCENTE")) {
                    JOptionPane.showMessageDialog(frame, "Accesso eseguito come docente.");
                    // ora possiamo aprire la HomeDocente
                    new DocenteHome(frame,controller);
                    frame.setVisible(false);
                }
                else {
                    JOptionPane.showMessageDialog(frame, "Accesso negato. Credenziali errate!", "Errore", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
