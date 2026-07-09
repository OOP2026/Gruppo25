package database_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Gestisce la connessione al database PostgreSQL.
 * Permette di mantenere un'unica istanza di connessione attiva in tutta l'applicazione.
 */
public class ConnessioneDatabase {
    private static ConnessioneDatabase instance;
    private Connection connection = null;
    private static final Logger LOGGER = Logger.getLogger(ConnessioneDatabase.class.getName());

    private String url = "jdbc:postgresql://ep-sweet-sun-ab4tkwsd-pooler.eu-west-2.aws.neon.tech/neondb?sslmode=require&channelBinding=require";
    private String user = "neondb_owner"; // NOSONAR
    private String password = "npg_vxd3IToV0Sup"; // NOSONAR
    private String driver = "org.postgresql.Driver";

    /**
     * Costruttore privato per impedire l'istanza diretta della classe da parte di altri componenti.
     * Carica il driver JDBC e stabilisce la connessione fisica con il database.
     *
     * @throws SQLException Se si verifica un errore durante il tentativo di connessione.
     */
    private ConnessioneDatabase() throws SQLException {
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            LOGGER.log(Level.SEVERE, "Errore di connessione nel costruttore del DAO. ",e);
        }
    }

    /**
     * Restituisce l'unica istanza attiva della classe ConnessioneDatabase.
     * Se l'istanza non esiste o se la connessione è stata chiusa, provvede a crearne una nuova.
     *
     * @return L'istanza corrente della connessione.
     * @throws SQLException Se si verifica un errore durante il tentativo di connessione.
     */
    public static ConnessioneDatabase getInstance() throws SQLException {
        if (instance == null) {
            instance = new ConnessioneDatabase();
        }
        else if(instance.getConnection().isClosed()){
            instance = new ConnessioneDatabase();
        }
        return instance;
    }

    /**
     * Restituisce l'oggetto Connection utile per eseguire query e interagire con il database.
     *
     * @return L'oggetto Connection corrente.
     */
    public Connection getConnection() {
        return connection;
    }
}