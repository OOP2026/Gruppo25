package implementazioneDao;
import dao.RichiestaTirocinioDAO;
import database_connection.ConnessioneDatabase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<String[]> ottieniCatalogoRichieste(String login) throws SQLException {
            List<String[]> righeTabella = new ArrayList<>();

            // Join per incrociare i dati dello studente
        String query = "SELECT s.nome,s.cognome,s.matricola,arg.argomento,az.nomeazienda,az.nominativoreferente " +
                "FROM studente s " +
                "JOIN richiestatirocinio rich ON s.matricola = rich.matricola_studente " +
                "JOIN argomentotirocinio arg ON arg.id_argomento = rich.argomento_richiesta " +
                "LEFT JOIN azienda az ON arg.id_azienda = az.id_azienda " +
                "WHERE rich.docente_richiesta = ? AND rich.statorichiesta = 'ATTESA'";
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(query)){
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String studente = resultSet.getString("nome") + " " + resultSet.getString("cognome");
                String matricola = resultSet.getString("matricola");
                String argomento = resultSet.getString("argomento");
                String nomeazienda = resultSet.getString("nomeazienda");
                String nominativoreferente =  resultSet.getString("nominativoreferente");

                if (nomeazienda == null) {
                    nomeazienda = "N.D.";
                    nominativoreferente = "N.D.";
                }

                righeTabella.add(new String[]{studente,matricola,argomento,nomeazienda,nominativoreferente});
            }
        }
        return righeTabella;
    }

    @Override
    public void setStatoRichiestaDAO(String matricolaStudente, String loginDocente, String stato) throws SQLException {
        String query = "UPDATE richiestatirocinio SET statorichiesta = ? WHERE matricola_studente = ? AND docente_richiesta = ?";

        try(PreparedStatement preparedStatement = this.connection.prepareStatement(query)){
            preparedStatement.setString(1, stato);
            preparedStatement.setString(2, matricolaStudente);
            preparedStatement.setString(3, loginDocente);
            preparedStatement.executeUpdate();

        }

    }

    @Override
    public Integer getIdRichiesta(String matricolaStudente, String loginDocente) throws SQLException {
        String query = "SELECT id_richiestatirocinio FROM richiestatirocinio WHERE matricola_studente = ? AND docente_richiesta = ?";
        try(PreparedStatement preparedStatement = this.connection.prepareStatement(query)){
            preparedStatement.setString(1, matricolaStudente);
            preparedStatement.setString(2, loginDocente);
            try (ResultSet resultSet = preparedStatement.executeQuery()){
                if (resultSet.next()){
                    return resultSet.getInt("id_richiestatirocinio");
                }
            }
        }
        return null;
    }

    @Override
    public boolean controlloStatoRichiesta(String matricolaStudente) throws SQLException {

         String query = "SELECT COUNT(*) AS numero_richiesta_attive FROM richiestatirocinio rich WHERE rich.matricola_studente = ? AND (rich.statorichiesta = 'ATTESA' OR rich.statorichiesta = 'APPROVATA')";
         try(PreparedStatement preparedStatement = this.connection.prepareStatement(query)){
             preparedStatement.setString(1, matricolaStudente);
             ResultSet resultSet = preparedStatement.executeQuery();
             while (resultSet.next()){
                 int conteggio = resultSet.getInt("numero_richiesta_attive");
                 if ( conteggio > 0){
                     return false;
                 }
             }
         }
         return true;
    }

}
