package dao;
import java.sql.SQLException;

public interface UtenteDAO {
    // Metodo per la verifica dell'unicità del login
    boolean controlloLogin(String login) throws SQLException;
}