package dao;
import java.sql.SQLException;
import java.util.List;

public interface TesiDAO {

    // Metodo per inserire una nuova tesi nel DataBase
    void inserisciTesi(String titolo, String contenuto,String data, Integer idTirocinio,String matricola_studente) throws SQLException;
}
