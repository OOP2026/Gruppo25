package dao;
import java.sql.SQLException;

/**
 * The interface Azienda dao.
 */
public interface AziendaDAO {
    /**
     * Valida azienda boolean.
     *
     * @param nominativoReferente the nominativo referente
     * @param nomeAzienda         the nome azienda
     * @return the boolean
     * @throws SQLException the sql exception
     */
// Metodo per aggiungere una nuova azienda al db
    boolean validaAzienda(String nominativoReferente, String nomeAzienda) throws SQLException;

    /**
     * Gets id azienda.
     *
     * @param nominativoReferente the nominativo referente
     * @param nomeAzienda         the nome azienda
     * @return the id azienda
     * @throws SQLException the sql exception
     */
// Metodo per restituire l'id dell'azienda
    Integer getIdAzienda(String nominativoReferente, String nomeAzienda) throws SQLException;
}
