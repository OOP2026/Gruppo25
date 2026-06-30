package dao;
import java.sql.SQLException;

public interface RichiestaTirocinioDAO {

    // Metodo per creare una nuova richiesta di tirocinio nel db
    void inserisciRichiesta(String matricola_studente,String login_docente,Integer id_argomento) throws SQLException;


}
