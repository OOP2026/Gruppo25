package dao;
import java.sql.SQLException;
import java.util.List;

public interface RichiestaTirocinioDAO {

    // Metodo per creare una nuova richiesta di tirocinio nel db
    void inserisciRichiesta(String matricola_studente,String login_docente,Integer id_argomento) throws SQLException;

    // Metodo per visualizzare la tabella delle richieste del docente
    List<String[]> ottieniCatalogoRichieste(String login) throws SQLException;

    // Metodo per modificare lo stato della richiesta del tirocinio
    void setStatoRichiestaDAO(String matricolaStudente,String loginDocente, String stato) throws SQLException;

    // Metodo per ottenere l'id della richiesta
    Integer getIdRichiesta(String matricolaStudente, String loginDocente) throws SQLException;

    // Metodo per verificare lo stato della richiesta del tirocinio
    boolean controlloStatoRichiesta(String matricolaStudente) throws  SQLException;

    // Metodo per ottenere la login di un docente data la matricola
    String getLoginDocente(String matricola) throws SQLException;

    // Metodo per visualizzare lo stato delle richieste dello studente
    List<String[]> ottieniCatalogoRichiesteStudente(String matricolaStudente) throws SQLException;
}
