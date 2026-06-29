package implementazioneDao;
import dao.AziendaDAO;
import database_connection.ConnessioneDatabase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AziendaImplementazioneDAO implements AziendaDAO {

    private Connection connection;
    public AziendaImplementazioneDAO() {
        try{
            this.connection = ConnessioneDatabase.getInstance().getConnection();
        } catch (SQLException e) {
            System.err.println("Errore di connessione nel costruttore del DAO.");
            e.printStackTrace();
        }
    }

    @Override
    public boolean validaAzienda(String nominativoReferente, String nomeAzienda) throws SQLException {

        String query = "SELECT id_azienda FROM azienda WHERE nominativoreferente = ? AND nomeazienda = ?";
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(query)) {
            preparedStatement.setString(1, nominativoReferente);
            preparedStatement.setString(2, nomeAzienda);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                if (rs.next()) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Integer getIdAzienda(String nominativoReferente, String nomeAzienda) throws SQLException {

        String query = "SELECT id_azienda FROM azienda WHERE nominativoreferente = ? AND nomeazienda = ?";
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(query)) {
            preparedStatement.setString(1, nominativoReferente);
            preparedStatement.setString(2, nomeAzienda);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("id_azienda");
                }
            }

        }
        return null;
    }
}
