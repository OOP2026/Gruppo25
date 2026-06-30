package implementazioneDao;
import dao.RichiestaTirocinioDAO;
import database_connection.ConnessioneDatabase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RichiestaTirocinioImplementazioneDAO implements RichiestaTirocinioDAO {

    private Connection connection;
    public RichiestaTirocinioImplementazioneDAO(){
        try{
            this.connection = ConnessioneDatabase.getInstance().getConnection();
        } catch (SQLException e) {
            System.err.println("Errore di connessione nel costruttore del DAO.");
            e.printStackTrace();
        }
    }

    @Override
    public void inserisciRichiesta(String matricola_studente,String login_docente,Integer id_argomento) throws SQLException{
        String query = "INSERT INTO richiestatirocinio(matricola_studente,docente_richiesta,argomento_richiesta) VALUES(?,?,?)";
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(query)){
            preparedStatement.setString(1, matricola_studente);
            preparedStatement.setString(2, login_docente);
            preparedStatement.setInt(3, id_argomento);
            preparedStatement.executeUpdate();

            System.out.println("Richiesta inserita con successo");
        }

    }

}
