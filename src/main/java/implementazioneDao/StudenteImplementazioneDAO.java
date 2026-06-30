package implementazioneDao;

import dao.StudenteDAO;
import database_connection.ConnessioneDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudenteImplementazioneDAO implements StudenteDAO {

    private Connection connection;

    public StudenteImplementazioneDAO() {
        try {
            // Otteniamo la connessione dal Singleton una sola volta quando il DAO viene "creato" (new)
            this.connection = ConnessioneDatabase.getInstance().getConnection();
        } catch (SQLException e) {
            System.err.println("Errore di connessione nel costruttore del DAO.");
            e.printStackTrace();
        }
    }

    @Override
    public void inserisciStudente(String matricola, String nome, String cognome, String email, String login, String password) throws SQLException {

        String query = "INSERT INTO studente (matricola, nome, cognome, email, login, password) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, matricola);
            preparedStatement.setString(2, nome);
            preparedStatement.setString(3, cognome);
            preparedStatement.setString(4, email);
            preparedStatement.setString(5, login);
            preparedStatement.setString(6, password);

            preparedStatement.executeUpdate();

            System.out.println("SUCCESSO! Lo studente è stato salvato nel database.");
        }
    }

    @Override
    public boolean verificaCredenziali(String login, String password,ArrayList<String> datiStudente) throws SQLException{
        String sql = "SELECT nome,cognome,email,matricola FROM studente WHERE login = ? AND password = ?";

        try(PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1, login);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                datiStudente.add(rs.getString("nome"));
                datiStudente.add(rs.getString("cognome"));
                datiStudente.add(rs.getString("email"));
                datiStudente.add(rs.getString("matricola"));
                return true;
            }

            return false;
        }
    }

    @Override
    public boolean verificaMatricola(String matricola) throws SQLException {

        String query = "SELECT matricola FROM studente WHERE matricola = ?";
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.setString(1, matricola);
            try (ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    return true;
                }
            }
        }
        return false;
    }


}