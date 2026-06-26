package dao;

import java.sql.SQLException;

public interface StudenteDAO {
    void inserisciStudente(String matricola, String nome, String cognome, String email, String login, String password) throws SQLException;

}
