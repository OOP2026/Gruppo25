package dao;
import java.sql.SQLException;
import java.util.List;

public interface TesiDAO {

    // Metodo per inserire una nuova tesi nel DataBase
    void inserisciTesi(String titolo, String contenuto,String data, Integer idTirocinio,String matricola_studente) throws SQLException;

    // Metodo per ottenere l'id della tesi
    Integer getIdTesi(String matricola_studente) throws SQLException;

    // Metodo per collegare la tesi al docente
    void inserisciSupervisione(String loginDocente, Integer id_tesi) throws SQLException;

    // Metodo per popolare la tabella dei tesisti
    List<String[]> ottieniCatalogoTesisti(String loginDocente) throws SQLException;

    // Metodo per leggere il contenuto della tesi
    String leggiContenutoTesi(String matricolaStudente) throws SQLException;

    // Metodo per modificare lo stato della tesi
    void setStatoTesi(String matricolaStudente, String stato) throws SQLException;

    // Metodo per visualizzare lo stato della tesi dallo studente
    List<String[]> ottieniCatalogoStatoTesiStudente(String matricolaStudente) throws SQLException;

    // Metodo per controllare se uno studente ha almeno una tesi
    boolean haTesiDAO(String matricolaStudente) throws SQLException;
}
