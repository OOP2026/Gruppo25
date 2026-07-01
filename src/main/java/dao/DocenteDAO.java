package dao;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface DocenteDAO {

    // Metodo per inserire il docente nel db
    void inserisciDocente(String login, String password, String nome, String cognome, String email) throws SQLException;

    // Metodo per verificare la presenza di un docente nel db
    boolean verificaCredenziali(String login, String password, ArrayList<String> datiDocente) throws SQLException;

    // Metodo per inserire l'argomento nel db
    void inserisciArgomento(String argomento,String login,Integer id_azienda) throws SQLException;

    // Metodo per popolare le tabelle della gui con la lista dei docenti
    List<String[]> ottieniCatalogoArgomenti() throws SQLException;

    // Metodo per prendere l'id di un argomento
    Integer getIdArgomento(String login, String nomeArgomento) throws SQLException;

    // Metodo per trovare un docente sulla base della mail
    boolean getDocenteDaEmail(String email, ArrayList<String> datidocenteTrovato) throws  SQLException;

    // Metodo per verificare se un docente specifico ha un argomento
    boolean verificaEsistenzaArgomento(String nomeDocente, String cognomeDocente, String nomeArgomento)  throws SQLException;


}
