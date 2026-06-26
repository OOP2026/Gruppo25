package implementazioneDao;

import dao.StudenteDAO;
import database_connection.ConnessioneDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentePostgresDAO implements StudenteDAO {

    @Override
    public void inserisciStudente(String matricola, String nome, String cognome, String email, String login, String password) throws SQLException {

        String query = "INSERT INTO studente (matricola, nome, cognome, email, login, password) VALUES (?, ?, ?, ?, ?, ?)";

        Connection connection = ConnessioneDatabase.getInstance().getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            // Assegniamo direttamente le stringhe passate come parametro
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
}