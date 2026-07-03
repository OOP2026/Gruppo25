package implementazione.dao;
import dao.UtenteDAO;
import database_connection.ConnessioneDatabase;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * The type Utente implementazione dao.
 */
public class UtenteImplementazioneDao implements UtenteDAO {
    private Connection connection;
    private static final Logger LOGGER = Logger.getLogger(UtenteImplementazioneDao.class.getName());

    /**
     * Instantiates a new Utente implementazione dao.
     *
     * @throws SQLException the sql exception
     */
    public UtenteImplementazioneDao() throws SQLException {
        try{
            this.connection = ConnessioneDatabase.getInstance().getConnection();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Errore di connessione nel costruttore del DAO. ",e);
        }
    }
    @Override
    public boolean controlloLogin(String login) throws SQLException{
        String query = "SELECT login FROM studente WHERE login = ? "
                + "UNION " +
                "SELECT login FROM docente WHERE login = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, login);
            ps.setString(2, login);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    return true;
                }
            }
        }

        return false;
    }

}
