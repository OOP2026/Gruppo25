package dao;
import java.sql.SQLException;
import java.util.List;

public interface TirocinioDAO {

    // Metodo per aggiungere un tirocinio al db
    void inserisciTirocinio(Integer id_richiesta, Integer id_azienda, String loginDocente, Integer id_argomento) throws SQLException;

    // Metodo per popolare la tabella dei tirocinanti
    List<String []> ottieniCatalogoTirocinanti(String loginDocente) throws SQLException;

    // Metodo per terminare il tirocinio
    void terminaTirocinio(Integer id_richiesta) throws SQLException;

    // Metodo per ottenere il l'id del tirocinio
    Integer getTirocinio(String matricolaStudente) throws SQLException;
}

