package dao;
import java.sql.SQLException;
import java.util.List;

/**
 * The interface Tirocinio dao.
 */
public interface TirocinioDAO {

    /**
     * Inserisci tirocinio.
     *
     * @param idRichiesta  the id richiesta
     * @param idAzienda    the id azienda
     * @param loginDocente the login docente
     * @param idArgomento  the id argomento
     * @throws SQLException the sql exception
     */
// Metodo per aggiungere un tirocinio al db
    void inserisciTirocinio(Integer idRichiesta, Integer idAzienda, String loginDocente, Integer idArgomento) throws SQLException;

    /**
     * Ottieni catalogo tirocinanti list.
     *
     * @param loginDocente the login docente
     * @return the list
     * @throws SQLException the sql exception
     */
// Metodo per popolare la tabella dei tirocinanti
    List<String []> ottieniCatalogoTirocinanti(String loginDocente) throws SQLException;

    /**
     * Termina tirocinio.
     *
     * @param idRichiesta the id richiesta
     * @throws SQLException the sql exception
     */
// Metodo per terminare il tirocinio
    void terminaTirocinio(Integer idRichiesta) throws SQLException;

    /**
     * Gets id tirocinio.
     *
     * @param matricolaStudente the matricola studente
     * @return the id tirocinio
     * @throws SQLException the sql exception
     */
// Metodo per ottenere il l'id del tirocinio
    Integer getIdTirocinio(String matricolaStudente) throws SQLException;

    /**
     * Valida completamento tirocinio boolean.
     *
     * @param matricolaStudente the matricola studente
     * @return the boolean
     * @throws SQLException the sql exception
     */
// Metodo per controllare lo stato del tirocinio
    boolean validaCompletamentoTirocinio(String matricolaStudente) throws SQLException;
}

