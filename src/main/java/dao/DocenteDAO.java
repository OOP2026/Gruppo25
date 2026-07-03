package dao;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The interface Docente dao.
 */
public interface DocenteDAO {

    /**
     * Inserisci docente.
     *
     * @param login    the login
     * @param password the password
     * @param nome     the nome
     * @param cognome  the cognome
     * @param email    the email
     * @throws SQLException the sql exception
     */
// Metodo per inserire il docente nel db
    void inserisciDocente(String login, String password, String nome, String cognome, String email) throws SQLException;

    /**
     * Verifica credenziali boolean.
     *
     * @param login       the login
     * @param password    the password
     * @param datiDocente the dati docente
     * @return the boolean
     * @throws SQLException the sql exception
     */
// Metodo per verificare la presenza di un docente nel db
    boolean verificaCredenziali(String login, String password, ArrayList<String> datiDocente) throws SQLException;

    /**
     * Inserisci argomento.
     *
     * @param argomento the argomento
     * @param login     the login
     * @param idAzienda the id azienda
     * @throws SQLException the sql exception
     */
// Metodo per inserire l'argomento nel db
    void inserisciArgomento(String argomento,String login,Integer idAzienda) throws SQLException;

    /**
     * Ottieni catalogo argomenti list.
     *
     * @return the list
     * @throws SQLException the sql exception
     */
// Metodo per popolare le tabelle della gui con la lista dei docenti
    List<String[]> ottieniCatalogoArgomenti() throws SQLException;

    /**
     * Gets id argomento.
     *
     * @param login         the login
     * @param nomeArgomento the nome argomento
     * @return the id argomento
     * @throws SQLException the sql exception
     */
// Metodo per prendere l'id di un argomento
    Integer getIdArgomento(String login, String nomeArgomento) throws SQLException;

    /**
     * Gets docente da email.
     *
     * @param email              the email
     * @param datiDocenteTrovato the dati docente trovato
     * @return the docente da email
     * @throws SQLException the sql exception
     */
// Metodo per trovare un docente sulla base della mail
    boolean getDocenteDaEmail(String email, ArrayList<String> datiDocenteTrovato) throws  SQLException;

    /**
     * Verifica esistenza argomento boolean.
     *
     * @param nomeDocente    the nome docente
     * @param cognomeDocente the cognome docente
     * @param nomeArgomento  the nome argomento
     * @return the boolean
     * @throws SQLException the sql exception
     */
// Metodo per verificare se un docente specifico ha un argomento
    boolean verificaEsistenzaArgomento(String nomeDocente, String cognomeDocente, String nomeArgomento)  throws SQLException;


}
