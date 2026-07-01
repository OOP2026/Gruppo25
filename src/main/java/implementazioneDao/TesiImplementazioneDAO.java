package implementazioneDao;
import dao.TesiDAO;
import database_connection.ConnessioneDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TesiImplementazioneDAO implements TesiDAO {
    private Connection connection;

    public TesiImplementazioneDAO() {
        try {
            this.connection = ConnessioneDatabase.getInstance().getConnection();
        } catch (SQLException e) {
            System.err.println("Errore di connessione nel costruttore del DAO.");
            e.printStackTrace();
        }
    }

    @Override
    public void inserisciTesi(String titolo, String contenuto, String data, Integer idTirocinio,String matricola_studente) throws SQLException{
        String query = "INSERT INTO tesi(titolo,contenuto,tirocinio,dataseduta,matricola_studente) VALUES (?,?,?,?,?)";
        try(PreparedStatement ps = this.connection.prepareStatement(query)){
            ps.setString(1,titolo);
            ps.setString(2,contenuto);
            ps.setInt(3,idTirocinio);
            ps.setString(4,data);
            ps.setString(5,matricola_studente);
            ps.executeUpdate();

            System.out.println("Inserimento tesi riuscito.");
        }

    }
}
