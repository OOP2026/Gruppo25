package implementazioneDao;
import dao.DocenteDAO;
import database_connection.ConnessioneDatabase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DocenteImplementazioneDAO implements DocenteDAO{

    private Connection connection;
    public DocenteImplementazioneDAO() {
        try{
            this.connection = ConnessioneDatabase.getInstance().getConnection();
        } catch (SQLException e) {
            System.err.println("Errore di connessione nel costruttore del DAO.");
            e.printStackTrace();
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
                datiDocente.add(rs.getString("cognome"));
                datiDocente.add(rs.getString("email"));
                return true;
            }

            return false;
        }
    }

    @Override
    public void inserisciArgomento(String argomento,String login) throws SQLException{
        String query = "INSERT INTO argomentotirocinio(argomento,docente) VALUES (?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setString(1, argomento);
            preparedStatement.setString(2, login);

            preparedStatement.executeUpdate();
            System.out.println("Argomento inserito");
        }
    }
}

