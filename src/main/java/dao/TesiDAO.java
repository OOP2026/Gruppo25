package dao;
import java.sql.SQLException;
import java.util.List;

/**
 * The interface Tesi dao.
 */
public interface TesiDAO {

    /**
     * Inserisci tesi.
     *
     * @param titolo            the titolo
     * @param contenuto         the contenuto
     * @param data              the data
     * @param idTirocinio       the id tirocinio
     * @param matricolaStudente the matricola studente
     * @throws SQLException the sql exception
     */
// Metodo per inserire una nuova tesi nel DataBase
    void inserisciTesi(String titolo, String contenuto,String data, Integer idTirocinio,String matricolaStudente) throws SQLException;

    /**
     * Gets id tesi.
     *
     * @param matricolaStudente the matricola studente
     * @return the id tesi
     * @throws SQLException the sql exception
     */
// Metodo per ottenere l'id della tesi
    Integer getIdTesi(String matricolaStudente) throws SQLException;

    /**
     * Inserisci supervisione.
     *
     * @param loginDocente the login docente
     * @param idTesi       the id tesi
     * @throws SQLException the sql exception
     */
// Metodo per collegare la tesi al docente
    void inserisciSupervisione(String loginDocente, Integer idTesi) throws SQLException;

    /**
     * Ottieni catalogo tesisti list.
     *
     * @param loginDocente the login docente
     * @return the list
     * @throws SQLException the sql exception
     */
// Metodo per popolare la tabella dei tesisti
    List<String[]> ottieniCatalogoTesisti(String loginDocente) throws SQLException;

    /**
     * Leggi contenuto tesi string.
     *
     * @param matricolaStudente the matricola studente
     * @return the string
     * @throws SQLException the sql exception
     */
// Metodo per leggere il contenuto della tesi
    String leggiContenutoTesi(String matricolaStudente) throws SQLException;

    /**
     * Sets stato tesi.
     *
     * @param matricolaStudente the matricola studente
     * @param stato             the stato
     * @throws SQLException the sql exception
     */
// Metodo per modificare lo stato della tesi
    void setStatoTesi(String matricolaStudente, String stato) throws SQLException;

    /**
     * Ottieni catalogo stato tesi studente list.
     *
     * @param matricolaStudente the matricola studente
     * @return the list
     * @throws SQLException the sql exception
     */
// Metodo per visualizzare lo stato della tesi dallo studente
    List<String[]> ottieniCatalogoStatoTesiStudente(String matricolaStudente) throws SQLException;

    /**
     * Ha tesi dao boolean.
     *
     * @param matricolaStudente the matricola studente
     * @return the boolean
     * @throws SQLException the sql exception
     */
// Metodo per controllare se uno studente ha almeno una tesi
    boolean haTesiDAO(String matricolaStudente) throws SQLException;
}
