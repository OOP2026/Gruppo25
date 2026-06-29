package implementazioneDao;
import dao.UtenteDAO;
import database_connection.ConnessioneDatabase;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UtenteImplementazioneDao implements UtenteDAO {
    private Connection connection;
    public UtenteImplementazioneDao() throws SQLException {
        try{
            this.connection = ConnessioneDatabase.getInstance().getConnection();
        } catch (SQLException e) {
            System.err.println("Errore di connessione nel costruttore del DAO.");
            e.printStackTrace();
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
