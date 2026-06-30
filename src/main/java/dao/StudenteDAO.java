package dao;

import java.sql.SQLException;
import java.util.ArrayList;

public interface StudenteDAO {

    // Metodo per inserire studenti nel db
    void inserisciStudente(String matricola, String nome, String cognome, String email, String login, String password) throws SQLException;

    // Metodo per verificare l'esistenza
    boolean verificaCredenziali(String login, String password,ArrayList<String> datiStudente) throws SQLException;

    // Metodo per verificare l'unicità della matricola
    boolean verificaMatricola(String matricola) throws SQLException;


}
