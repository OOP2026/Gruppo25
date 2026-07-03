package dao;
import java.sql.SQLException;

/**
 * The interface Utente dao.
 */
public interface UtenteDAO {
    /**
     * Controllo login boolean.
     *
     * @param login the login
     * @return the boolean
     * @throws SQLException the sql exception
     */
// Metodo per la verifica dell'unicità del login
    boolean controlloLogin(String login) throws SQLException;
}