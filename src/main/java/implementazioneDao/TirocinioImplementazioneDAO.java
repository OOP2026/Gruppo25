package implementazioneDao;
import dao.TirocinioDAO;
import database_connection.ConnessioneDatabase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TirocinioImplementazioneDAO implements TirocinioDAO {
    private Connection connection;

    public TirocinioImplementazioneDAO() {
        try {
            this.connection = ConnessioneDatabase.getInstance().getConnection();
        } catch (SQLException e) {
            System.err.println("Errore di connessione nel costruttore del DAO.");
            e.printStackTrace();
        }
    }

    @Override
    public void inserisciTirocinio(Integer id_richiesta, Integer id_azienda, String loginDocente, Integer id_argomento) throws SQLException {
        String query = "INSERT INTO tirocinio(id_richiesta,azienda,docentesupervisore,argomento) VALUES (?,?,?,?)";
        try(PreparedStatement stmt = this.connection.prepareStatement(query)){
            stmt.setInt(1, id_richiesta);
            // Gestione del caso di tirocinio interno
            if(id_azienda != null) {
                stmt.setInt(2, id_azienda);
            } else{
                stmt.setNull(2,java.sql.Types.INTEGER);
            }
            stmt.setString(3, loginDocente);
            stmt.setInt(4, id_argomento);
            stmt.executeUpdate();

            System.out.println("Tirocinio aggiunto con successo.");
        }
    }

    @Override
    public List<String[]> ottieniCatalogoTirocinanti(String loginDocente) throws SQLException {
        List<String[]> righeTabella = new ArrayList<>();
        String query = "SELECT s.nome,s.cognome,s.matricola,az.nomeazienda,az.nominativoreferente,arg.argomento " +
                "FROM studente s " + "JOIN richiestatirocinio rich ON s.matricola=rich.matricola_studente " +
                "JOIN tirocinio tir ON rich.id_richiestatirocinio = tir.id_richiesta " +
                "JOIN argomentotirocinio arg ON rich.argomento_richiesta = arg.id_argomento " +
                "LEFT JOIN azienda az ON arg.id_azienda=az.id_azienda " +
                "WHERE docentesupervisore = ? AND tir.completato = false";
        try(PreparedStatement ps = this.connection.prepareStatement(query)){
            ps.setString(1, loginDocente);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String nome = rs.getString("nome") + " " + rs.getString("cognome");
                String matricola = rs.getString("matricola");
                String nomeazienda = rs.getString("nomeazienda");
                String nominativoreferente = rs.getString("nominativoreferente");
                if(nomeazienda == null) {
                    nomeazienda = "N.D.";
                    nominativoreferente = "N.D.";
                }
                String argomento = rs.getString("argomento");

                righeTabella.add(new String[]{nome,matricola,nomeazienda,nominativoreferente,argomento});
            }
            return righeTabella;
        }
    }

    @Override
    public void terminaTirocinio(Integer id_richiesta) throws SQLException {
        String query = "UPDATE tirocinio SET completato = true WHERE id_richiesta = ?";
        try(PreparedStatement ps = this.connection.prepareStatement(query)){
            ps.setInt(1, id_richiesta);
            ps.executeUpdate();
        }
    }

    @Override
    public Integer getIdTirocinio(String matricolaStudente) throws SQLException {
        String query = "SELECT tir.id_tirocinio FROM tirocinio tir " +
                "JOIN richiestatirocinio rich ON tir.id_richiesta=rich.id_richiestatirocinio " +
                "WHERE matricola_studente = ? AND rich.statorichiesta = 'APPROVATA'";
        try(PreparedStatement ps = this.connection.prepareStatement(query)){
            ps.setString(1, matricolaStudente);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return rs.getInt("id_tirocinio");
            }
        }
        return null;
    }

    @Override
    public boolean validaCompletamentoTirocinio(String matricolaStudente) throws SQLException {
        // Cerchiamo un tirocinio completato che NON abbia una tesi associata
        String query = "SELECT tir.id_tirocinio FROM tirocinio tir " +
                "JOIN richiestatirocinio rich ON tir.id_richiesta = rich.id_richiestatirocinio " +
                "LEFT JOIN tesi t ON tir.id_tirocinio = t.tirocinio AND t.statotesi != 'RIFIUTATA' " +
                "WHERE rich.matricola_studente = ? " +
                "AND tir.completato = true " +
                "AND t.tirocinio IS NULL";
        try (PreparedStatement ps = this.connection.prepareStatement(query)) {
            ps.setString(1, matricolaStudente);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    return true;
                }
            }
        }

        return false;
    }


}
