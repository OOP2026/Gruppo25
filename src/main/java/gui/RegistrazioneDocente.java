package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrazioneDocente {
    private JButton d_confermaButton;
<<<<<<< Updated upstream
    private JTextField dNomeText;
    private JTextField dCognomeText;
    private JTextField dEmailText;
    private JTextField dLoginText;
    private JTextField dPassowordText;
    private JButton annullaButton;
=======
    private JLabel TitoloRegistraDocente;

    public RegistrazioneDocente() {
        d_confermaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // LISTENER RIFERITO AL PULSANTE PER CONFERMARE LA REGISTRAZIONE DEL DOCENTE
            }
        });
    }
>>>>>>> Stashed changes
}
