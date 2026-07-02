package database_connection;

import implementazioneDao.TesiImplementazioneDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnessioneDatabase {
    private static ConnessioneDatabase instance;
    private Connection connection = null;
    private static final Logger LOGGER = Logger.getLogger(ConnessioneDatabase.class.getName());

    private String url = "jdbc:postgresql://ep-sweet-sun-ab4tkwsd-pooler.eu-west-2.aws.neon.tech/neondb?sslmode=require&channelBinding=require";
    private String user = "neondb_owner"; // NOSONAR
    private String password = "npg_vxd3IToV0Sup"; // NOSONAR
    private String driver = "org.postgresql.Driver";

    private ConnessioneDatabase() throws SQLException {
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            LOGGER.log(Level.SEVERE, "Errore di connessione nel costruttore del DAO. ",e);
        }
    }

    public static ConnessioneDatabase getInstance() throws SQLException {
        if (instance == null) {
            instance = new ConnessioneDatabase();
        }
        else if(instance.getConnection().isClosed()){
            instance = new ConnessioneDatabase();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}