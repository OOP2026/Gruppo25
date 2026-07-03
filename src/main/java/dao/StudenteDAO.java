package dao;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * The interface Studente dao.
 */
public interface StudenteDAO {

    /**
     * Inserisci studente.
     *
     * @param matricola the matricola
     * @param nome      the nome
     * @param cognome   the cognome
     * @param email     the email
     * @param login     the login
     * @param password  the password
     * @throws SQLException the sql exception
     */
// Metodo per inserire studenti nel db
    void inserisciStudente(String matricola, String nome, String cognome, String email, String login, String password) throws SQLException;

    /**
     * Verifica credenziali boolean.
     *
     * @param login        the login
     * @param password     the password
     * @param datiStudente the dati studente
     * @return the boolean
     * @throws SQLException the sql exception
     */
// Metodo per verificare l'esistenza
    boolean verificaCredenziali(String login, String password,ArrayList<String> datiStudente) throws SQLException;

    /**
     * Verifica matricola boolean.
     *
     * @param matricola the matricola
     * @return the boolean
     * @throws SQLException the sql exception
     */
// Metodo per verificare l'unicità della matricola
    boolean verificaMatricola(String matricola) throws SQLException;

}
