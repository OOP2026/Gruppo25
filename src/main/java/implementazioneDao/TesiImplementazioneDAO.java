package implementazioneDao;
import dao.TesiDAO;
import database_connection.ConnessioneDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public Integer getIdTesi(String matricola_studente) throws SQLException {
        String query = "SELECT id_tesi FROM tesi WHERE matricola_studente = ?";
        try(PreparedStatement ps = this.connection.prepareStatement(query)){
            ps.setString(1,matricola_studente);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return rs.getInt("id_tesi");
            }
        }
        return null;
    }

    @Override
    public void inserisciSupervisione(String loginDocente, Integer id_tesi) throws SQLException {
        String query = "INSERT INTO supervisione VALUES (?,?)";
        try(PreparedStatement ps = this.connection.prepareStatement(query)){
            ps.setString(1,loginDocente);
            ps.setInt(2,id_tesi);
            ps.executeUpdate();

            System.out.println("Inserimento supervisione riuscito.");
        }
    }

    @Override
    public List<String[]> ottieniCatalogoTesisti(String loginDocente) throws SQLException {
        List<String[]> righeTabella = new ArrayList<>();
        String query = "SELECT s.nome,s.cognome,s.matricola,t.titolo,t.contenuto " +
                "FROM studente s " + "JOIN tesi t ON s.matricola = t.matricola_studente " +
                "JOIN supervisione superv ON t.id_tesi = superv.idtesi " +
                "WHERE t.statotesi = 'ATTESA' AND superv.logindocente = ?";
        try(PreparedStatement ps = this.connection.prepareStatement(query)){
            ps.setString(1,loginDocente);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String nome = rs.getString("nome") +  " " + rs.getString("cognome");
                String matricola = rs.getString("matricola");
                String titolo = rs.getString("titolo");
                String contenuto = rs.getString("contenuto");

                righeTabella.add(new String[]{nome,matricola,titolo,contenuto});
            }

        }
        return righeTabella;
    }

    @Override
    public String leggiContenutoTesi(String matricolaStudente) throws SQLException {
        String query = "SELECT titolo,contenuto FROM tesi WHERE matricola_studente = ? AND statotesi = 'ATTESA'";
        try(PreparedStatement ps = this.connection.prepareStatement(query)){
            ps.setString(1,matricolaStudente);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                String titolo = rs.getString("titolo");
                String contenuto = rs.getString("contenuto");
                return titolo + "\n\n\n" + contenuto;
            }
        }
        return "";
    }
}
