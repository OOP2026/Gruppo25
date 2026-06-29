package dao;
import java.sql.SQLException;

public interface AziendaDAO {
    // Metodo per aggiungere una nuova azienda al db
    boolean validaAzienda(String nominativoReferente, String nomeAzienda) throws SQLException;

    // Metodo per restituire l'id dell'azienda
    Integer getIdAzienda(String nominativoReferente, String nomeAzienda) throws SQLException;
}
