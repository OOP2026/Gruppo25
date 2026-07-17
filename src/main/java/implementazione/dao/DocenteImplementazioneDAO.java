package implementazione.dao;
import dao.DocenteDAO;
import database_connection.ConnessioneDatabase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The type Docente implementazione dao.
 */
public class DocenteImplementazioneDAO implements DocenteDAO{

    private static final String COGNOME = "cognome";

    private Connection connection;
    private static final Logger LOGGER = Logger.getLogger(DocenteImplementazioneDAO.class.getName());

    /**
     * Instantiates a new Docente implementazione dao.
     */
    public DocenteImplementazioneDAO() {
        try{
            this.connection = ConnessioneDatabase.getInstance().getConnection();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Errore di connessione nel costruttore del DAO. ",e);
        }
    }

    @Override
    public void inserisciDocente(String login, String password, String nome, String cognome, String email) throws SQLException{

        String query = "INSERT INTO docente(login,password,nome,cognome,email) VALUES (?,?,?,?,?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, nome);
            preparedStatement.setString(4, cognome);
            preparedStatement.setString(5, email);

            preparedStatement.executeUpdate();

            System.out.println("Docente inserito");
        }
    }

    @Override
    public boolean verificaCredenziali(String login, String password, ArrayList<String> datiDocente) throws SQLException{

        String sql = "SELECT nome,cognome,email FROM docente WHERE login = ? AND password = ? ";
        try(PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1, login);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                datiDocente.add(rs.getString("nome"));
                datiDocente.add(rs.getString(COGNOME));
                datiDocente.add(rs.getString("email"));
                return true;
            }

            return false;
        }
    }

    @Override
    public void inserisciArgomento(String argomento,String login, Integer idAzienda) throws SQLException{
        String query = "INSERT INTO argomentotirocinio(argomento,docente,id_azienda) VALUES (?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setString(1, argomento);
            preparedStatement.setString(2, login);
            if (idAzienda != null) {
                // Se c'è un'azienda usiamo setInt
                preparedStatement.setInt(3, idAzienda);
            } else {
                // Se l'azienda non c'è inseriamo esplicitamente un NULL SQL
                preparedStatement.setNull(3, java.sql.Types.INTEGER);
            }

            preparedStatement.executeUpdate();
            System.out.println("Argomento inserito");
        }
    }

    @Override
    public List<String[]> ottieniCatalogoArgomenti() throws SQLException {
        List<String[]> righeTabella = new ArrayList<>();

        // Join per incrociare i dati del docente dell'azienda e l'argomento
        String query = "SELECT d.nome, d.cognome, d.email, a.argomento, az.nomeazienda " +
                "FROM docente d " +
                "JOIN argomentotirocinio a ON d.login = a.docente " +
                "LEFT JOIN azienda az ON a.id_azienda = az.id_azienda ORDER BY d.cognome";

        try (PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                // Estraiamo i dati della riga
                String prof = "Prof. " + rs.getString("nome") + " " + rs.getString(COGNOME);
                String email = rs.getString("email");
                String argomento = rs.getString("argomento");
                String azienda = rs.getString("nomeazienda");

                // Se l'azienda è NULL (perché il tirocinio è INTERNO), mettiamo "N.D."
                if (azienda == null) {
                    azienda = "N.D.";
                }

                // Assembliamo la riga come array di stringhe e la aggiungiamo alla lista
                righeTabella.add(new String[]{prof,email, argomento, azienda});
            }
        }
        return righeTabella;
    }

    @Override
    public Integer getIdArgomento(String login, String nomeArgomento) throws SQLException {

        String query = "SELECT id_argomento FROM argomentotirocinio WHERE LOWER(docente) = LOWER(?) AND LOWER(argomento) = LOWER(?) ";
        try (PreparedStatement ps = connection.prepareStatement(query)){
            ps.setString(1, login);
            ps.setString(2, nomeArgomento);
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    return rs.getInt("id_argomento");
                }
            }
        }
        return null;
    }

    @Override
    public boolean getDocenteDaEmail(String email, ArrayList<String> datiDocenteTrovato) throws SQLException {

        String sql = "SELECT nome,cognome,login,password FROM docente WHERE email = ?";
        try(PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                datiDocenteTrovato.add(rs.getString("nome"));
                datiDocenteTrovato.add(rs.getString(COGNOME));
                datiDocenteTrovato.add(rs.getString("login"));
                datiDocenteTrovato.add(rs.getString("password"));
                return true;
            }

            return false;
        }
    }

    @Override
    public boolean verificaEsistenzaArgomento(String nomeDocente, String cognomeDocente, String nomeArgomento) throws SQLException {
        String query = "SELECT d.nome,d.cognome,arg.argomento FROM docente d JOIN argomentotirocinio arg ON d.login = arg.docente WHERE LOWER(d.nome) = LOWER(?)  AND LOWER(d.cognome) = LOWER(?) AND LOWER(arg.argomento) = LOWER(?)";
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.setString(1, nomeDocente);
            ps.setString(2, cognomeDocente);
            ps.setString(3, nomeArgomento);
            try (ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    return true;
                }
            }
        }
        return false;
    }
}

