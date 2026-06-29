package dao;


import java.sql.SQLException;
import java.util.ArrayList;

public interface DocenteDAO {

    // Metodo per inserire il docente nel db
    void inserisciDocente(String login, String password, String nome, String cognome, String email) throws SQLException;

    // Metodo per verificare la presenza di un docente nel db
    boolean verificaCredenziali(String login, String password, ArrayList<String> datiDocente) throws SQLException;

    // Metodo per inserire l'argomento nel db
    void inserisciArgomento(String argomento,String login) throws SQLException;
}
