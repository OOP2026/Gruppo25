package dao;
import java.sql.SQLException;
import java.util.List;

/**
 * The interface Richiesta tirocinio dao.
 */
public interface RichiestaTirocinioDAO {

    /**
     * Inserisci richiesta.
     *
     * @param matricolaStudente the matricola studente
     * @param loginDocente      the login docente
     * @param idArgomento       the id argomento
     * @throws SQLException the sql exception
     */
// Metodo per creare una nuova richiesta di tirocinio nel db
    void inserisciRichiesta(String matricolaStudente,String loginDocente,Integer idArgomento) throws SQLException;

    /**
     * Ottieni catalogo richieste list.
     *
     * @param login the login
     * @return the list
     * @throws SQLException the sql exception
     */
// Metodo per visualizzare la tabella delle richieste del docente
    List<String[]> ottieniCatalogoRichieste(String login) throws SQLException;

    /**
     * Sets stato richiesta dao.
     *
     * @param matricolaStudente the matricola studente
     * @param loginDocente      the login docente
     * @param stato             the stato
     * @throws SQLException the sql exception
     */
// Metodo per modificare lo stato della richiesta del tirocinio
    void setStatoRichiestaDAO(String matricolaStudente,String loginDocente, String stato) throws SQLException;

    /**
     * Gets id richiesta.
     *
     * @param matricolaStudente the matricola studente
     * @param loginDocente      the login docente
     * @return the id richiesta
     * @throws SQLException the sql exception
     */
// Metodo per ottenere l'id della richiesta
    Integer getIdRichiesta(String matricolaStudente, String loginDocente) throws SQLException;

    /**
     * Controllo stato richiesta boolean.
     *
     * @param matricolaStudente the matricola studente
     * @return the boolean
     * @throws SQLException the sql exception
     */
// Metodo per verificare lo stato della richiesta del tirocinio
    boolean controlloStatoRichiesta(String matricolaStudente) throws  SQLException;

    /**
     * Gets login docente.
     *
     * @param matricola the matricola
     * @return the login docente
     * @throws SQLException the sql exception
     */
// Metodo per ottenere la login di un docente data la matricola
    String getLoginDocente(String matricola) throws SQLException;

    /**
     * Ottieni catalogo richieste studente list.
     *
     * @param matricolaStudente the matricola studente
     * @return the list
     * @throws SQLException the sql exception
     */
// Metodo per visualizzare lo stato delle richieste dello studente
    List<String[]> ottieniCatalogoRichiesteStudente(String matricolaStudente) throws SQLException;
}
