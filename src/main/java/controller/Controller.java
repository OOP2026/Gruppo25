package controller;


import dao.*;
import implementazione.dao.*;
import model.*;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 * The type Controller.
 */
public class Controller {

    // Variabili di sessione per ricordare chi sono i docenti/studenti che sono nel sistema
    // Creiamo delle list momentanee per contenere i riferimenti agli studenti e ai docenti
    private List<Studente>  studenti;
    private List<Docente> docenti;
    private List<RichiestaTirocinio> richiesteTirocinio;
    private List<Azienda> listaAziende;
    private Docente docenteLoggato;
    private Studente studenteLoggato;
    private static final String TIPO_ESTERNO = "ESTERNO";
    private static final String TIPO_INTERNO = "INTERNO";
    private static final Logger LOGGER = Logger.getLogger(Controller.class.getName());

    // Variabile da stampare a video in caso di errore nel login.  La Definiamo la costante una volta sola per tutta la classe
    private static final String ERRORE_CONNESSIONE_LOGIN = "Errore durante la connessione al database";

    /**
     * Instantiates a new Controller.
     */
    public Controller() {

        this.studenti = new ArrayList<>();
        this.docenti = new ArrayList<>();
        this.richiesteTirocinio = new ArrayList<>();
        this.listaAziende = new ArrayList<>();
    }

    /**
     * Sets studente.
     *
     * @param login     the login
     * @param password  the password
     * @param nome      the nome
     * @param cognome   the cognome
     * @param email     the email
     * @param matricola the matricola
     */
    public void setStudente(String login, String password, String nome, String cognome, String email, String matricola) {
        Studente studente = new Studente(login, password, nome, cognome, email, matricola);
        studenti.add(studente);
        StudenteDAO studenteDAO = new StudenteImplementazioneDAO();
        try {

            studenteDAO.inserisciStudente(matricola, nome, cognome, email, login, password);
            LOGGER.log(Level.INFO, "Studente inserito");

        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Errore durante il salvataggio dello studente nel database",e);
            studenti.remove(studente);
        }
    }

    /**
     * Sets docente.
     *
     * @param login    the login
     * @param password the password
     * @param nome     the nome
     * @param cognome  the cognome
     * @param email    the email
     */
    public void setDocente(String login, String password, String nome, String cognome, String email) {
        Docente docente = new Docente(login, password, nome, cognome, email);
        docenti.add(docente);
        DocenteDAO docenteDAO = new DocenteImplementazioneDAO();
        try{
            docenteDAO.inserisciDocente(login,password,nome,cognome,email);
            LOGGER.log(Level.INFO, "Docente inserito");
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Errore durante il salvataggio del docente  nel database",e);
            docenti.remove(docente);
        }
    }

    /**
     * Effettua login string.
     *
     * @param login    the login
     * @param password the password
     * @return the string
     */
// Metodo per verificare se la login e la password inseriti corrispondono ad uno Studente, ad un Docente o non esiste
    public String effettuaLogin(String login, String password) {
        // 1. Cerca tra gli studenti
        StudenteDAO studenteDAO = new StudenteImplementazioneDAO();
        ArrayList<String> datiStudente = new ArrayList<>();

        try{
            boolean loginStudenteRiuscito = studenteDAO.verificaCredenziali(login,password,datiStudente);
            if(loginStudenteRiuscito){
                String nome = datiStudente.get(0);
                String cognome = datiStudente.get(1);
                String email = datiStudente.get(2);
                String matricola = datiStudente.get(3);

                this.studenteLoggato = new Studente(login,password,nome,cognome,email,matricola);
                return "STUDENTE";
            }
        } catch (SQLException e){

            LOGGER.log(Level.SEVERE, ERRORE_CONNESSIONE_LOGIN,e);

        }

        // 2. Cerca tra i docenti
        DocenteDAO docenteDAO = new DocenteImplementazioneDAO();
        ArrayList<String> datiDocente = new ArrayList<>();

        try{
            boolean loginDocenteRiuscito = docenteDAO.verificaCredenziali(login,password,datiDocente);
            if(loginDocenteRiuscito){
                String nome = datiDocente.get(0);
                String cognome = datiDocente.get(1);
                String email = datiDocente.get(2);

                this.docenteLoggato = new Docente(login,password,nome,cognome,email);
                return "DOCENTE";
            }
        } catch (SQLException e){
            LOGGER.log(Level.SEVERE, ERRORE_CONNESSIONE_LOGIN,e);
        }
        // 3. Se non trova nessuno
        return "NON_TROVATO";
    }

    /**
     * Controllo login boolean.
     *
     * @param login the login
     * @return the boolean
     * @throws SQLException the sql exception
     */
// Metodo per verificare che la login inserita non esista giá
    public boolean controlloLogin(String login) throws SQLException {
        UtenteDAO utenteDAO = new UtenteImplementazioneDao();
        try {
            return utenteDAO.controlloLogin(login);
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, ERRORE_CONNESSIONE_LOGIN,e);
            return true;
        }
    }

    /**
     * Controllo nome cognome boolean.
     *
     * @param stringa the stringa
     * @return the boolean
     */
// Metodo per la verifica degli input di nome e cognome
    public boolean controlloNomeCognome(String stringa) {
        for (int i = 0; i < stringa.length(); i++) {
            if (!(Character.isLetter(stringa.charAt(i))) && (stringa.charAt(i) != ' ')) {
                return true;
            }
        }
        return false;
    }

    /**
     * Controllo formato matricola boolean.
     *
     * @param matricola the matricola
     * @return the boolean
     */
// Metodo per la verifica del formato della matricola
    public boolean controlloFormatoMatricola(String matricola) {
        if (matricola.length() != 9) {
            return true;
        }

        return !(matricola.matches("^(D[A-Z]\\d{7}|N\\d{8})$"));
    }

    /**
     * Controllo matricola boolean.
     *
     * @param matricola the matricola
     * @return the boolean
     */
// Metodo per la verifica dell`unicità della matricola
    public boolean controlloMatricola(String matricola) {
        StudenteDAO studenteDAO =  new StudenteImplementazioneDAO();
        try {
            return studenteDAO.verificaMatricola(matricola);
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Errore durante la ricerca della matricola al database",e);
            return true;
        }
    }

    /**
     * Controllo email studente boolean.
     *
     * @param email the email
     * @return the boolean
     */
// Metodo per la verifica del formato della mail di studente
    public boolean controlloEmailStudente(String email) {
        return !(email.matches("^[\\w\\.-]+@studenti\\.unina\\.it$"));
    }

    /**
     * Controllo email docente boolean.
     *
     * @param email the email
     * @return the boolean
     */
// Metodo per la verifica del formato della mail di docente
    public boolean controlloEmailDocente(String email) {
        return !(email.matches("^[\\w\\.-]+@docenti\\.unina\\.it$"));
    }

    /**
     * Controllo passoword boolean.
     *
     * @param pass the pass
     * @return the boolean
     */
// Metodo per la verifica minima della sicurezza sulla password
    public boolean controlloPassoword(String pass) {
        return pass.length() < 8;
    }

    /**
     * Aggiungi nuovo argomento boolean.
     *
     * @param argomento          the argomento
     * @param tipologiaTirocinio the tipologia tirocinio
     * @param nomeAz             the nome az
     * @param refAz              the ref az
     * @return the boolean
     */
// Metodo per aggiungere un argomento alla lista di argomenti del docente loggato.
    public boolean aggiungiNuovoArgomento(String argomento, String tipologiaTirocinio, String nomeAz, String refAz) {
        if (this.docenteLoggato == null) {
            return false;
        }

        try {

            // Costruiamo gli oggetti del model
            Azienda nuovaAzienda = null;
            Integer idAzienda = null;
            // Controlliamo se l'azienda è esterna
            if (tipologiaTirocinio.equalsIgnoreCase(TIPO_ESTERNO)) {
                AziendaDAO aziendaDAO = new AziendaImplementazioneDAO();
                // se esiste nel db la creiamo anche nel Model
                if (aziendaDAO.validaAzienda(refAz, nomeAz)) {
                    nuovaAzienda = new Azienda(nomeAz, refAz);
                    idAzienda = aziendaDAO.getIdAzienda(refAz,nomeAz);
                } else {
                    return false; // Blocco l'operazione se l'azienda non è valida
                }
            }
            // Salviamo l'argomento nel DB
            DocenteDAO docenteDAO = new DocenteImplementazioneDAO();

            docenteDAO.inserisciArgomento(argomento, docenteLoggato.getLogin(),idAzienda);
            if (nuovaAzienda != null) {
                this.listaAziende.add(nuovaAzienda);
            }
            this.docenteLoggato.addArgomentoTirocinio(argomento);

            LOGGER.log(Level.INFO, "Argomento inserito.");
            return true;

        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Errore durante il salvataggio dell'argomento nel database",e);
            return false;
        }
    }


    /**
     * Gets dati tabella elenco tirocini.
     *
     * @return the dati tabella elenco tirocini
     */
    public List<String[]> getDatiTabellaElencoTirocini() {
        DocenteDAO docenteDAO = new DocenteImplementazioneDAO();
        try {
            // Chiede i dati al DB e li restituisce dritti alla GUI
            return docenteDAO.ottieniCatalogoArgomenti();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Errore durante il caricamento del catalogo dei tirocini dal database",e);
            return new ArrayList<>(); // Restituisce lista vuota in caso di errore
        }
    }

    /**
     * Controlla richiesta tirocinio boolean.
     *
     * @param nomeProf      the nome prof
     * @param cognomeProf   the cognome prof
     * @param nomeArgomento the nome argomento
     * @return the boolean
     */
// Metodo che controlla l'inserimento del docente e del relativo argomento nella richiesta di tirocinio
    public boolean controllaRichiestaTirocinio(String nomeProf, String cognomeProf, String nomeArgomento) {

        DocenteDAO docenteDAO = new DocenteImplementazioneDAO();
       try {
           return docenteDAO.verificaEsistenzaArgomento(nomeProf, cognomeProf, nomeArgomento);
       } catch (SQLException e) {
           LOGGER.log(Level.SEVERE, "Errore durante la ricerca nel database",e);
           return false;
       }
    }

    /**
     * Aggiungi richiesta tirocinio boolean.
     *
     * @param email     the email
     * @param argomento the argomento
     * @return the boolean
     */
// Metodo per cercare il docente e inserire la nuova richiesta di tirocinio
    public boolean aggiungiRichiestaTirocinio(String email, String argomento) {
        ArrayList<String> datiDocenteTrovato = new ArrayList<>();
        DocenteDAO docenteDAO = new DocenteImplementazioneDAO();
        RichiestaTirocinioDAO richiestaTirocinioDAO = new RichiestaTirocinioImplementazioneDAO();

        try {
            // Cerchiamo tra i docenti quello con la email corrispondente a quella inserita, per evitare problemi relativi a docenti omonimi
            boolean trovaDocente = docenteDAO.getDocenteDaEmail(email, datiDocenteTrovato);

            if(trovaDocente) {
                String nome = datiDocenteTrovato.get(0);
                String cognome = datiDocenteTrovato.get(1);
                String login = datiDocenteTrovato.get(2);
                String password = datiDocenteTrovato.get(3);


                // Se esiste un docente con i dati inseriti dallo studente al momento della compilazione creiamo un nuovo oggetto docente, e la richiesta del tirocinio con quei dati
                Integer idArgomento = docenteDAO.getIdArgomento(login, argomento);
                if(idArgomento == null) {
                    System.err.println("Impossibile trovare l'argomento");
                    return false;
                }

                richiestaTirocinioDAO.inserisciRichiesta(this.studenteLoggato.getMatricola(), login, idArgomento);

                Docente docenteTrovato = new Docente(login,password,nome,cognome,email);
                RichiestaTirocinio nuovaRichiesta = new RichiestaTirocinio(this.studenteLoggato, docenteTrovato, argomento);

                // Aggiungiamo la richiesta alla lista del controller
                this.richiesteTirocinio.add(nuovaRichiesta);
                return true;
            }
            LOGGER.log(Level.SEVERE, "Errore durante la ricerca della email nel database");
            return false;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Errore durante il salvataggio della richiesta nel database",e);
            return false;
        }
    }

    /**
     * Sets argomento studente.
     *
     * @param argomentoStudente the argomento studente
     */
// Metodo per aggiungere l'argomento del tirocinio allo studente
    public void setArgomentoStudente(String argomentoStudente) {
        this.studenteLoggato.setArgomentoTirocinio(argomentoStudente);

    }

    /**
     * Get dati tabella richieste tirocinio list.
     *
     * @return the list
     */
// Metodi per riempire la tabella delle richieste del tirocinio per il docente
    public List<String[]> getDatiTabellaRichiesteTirocinio(){

        RichiestaTirocinioDAO richiestaTirocinioDAO = new RichiestaTirocinioImplementazioneDAO();
        try{
            return richiestaTirocinioDAO.ottieniCatalogoRichieste(docenteLoggato.getLogin());
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Errore durante il caricamento del catalogo delle richieste di tirocinio del docente dal database",e);
            return new ArrayList<>();
        }

    }

    /**
     * Modifica stato richiesta boolean.
     *
     * @param matricola  the matricola
     * @param nuovoStato the nuovo stato
     * @return the boolean
     */
// Metodo per modificare lo stato della richiesta del tirocinio
    public boolean modificaStatoRichiesta(String matricola, Stato nuovoStato) {
        RichiestaTirocinioDAO richiestaTirocinioDAO  = new RichiestaTirocinioImplementazioneDAO();

        try{
            richiestaTirocinioDAO.setStatoRichiestaDAO(matricola,this.docenteLoggato.getLogin(),nuovoStato.toString());
            return true;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Errore durante la modifica nel database",e);
            return false;
        }
    }

    /**
     * Gets richiesta tirocinio studente.
     *
     * @return the richiesta tirocinio studente
     */
// Metodo per visualizzare le richieste di tirocinio inviate dallo studente
    public List<String[]> getRichiestaTirocinioStudente() {
        RichiestaTirocinioDAO richiestaTirocinioDAO = new RichiestaTirocinioImplementazioneDAO();
        try{
            return richiestaTirocinioDAO.ottieniCatalogoRichiesteStudente(studenteLoggato.getMatricola());
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Errore durante il caricamento del catalogo delle richieste di tirocinio dello studente nel database",e);
            return new ArrayList<>();
        }
    }


    /**
     * Gets studente loggato.
     *
     * @return the studente loggato
     */
    public Studente getStudenteLoggato() {
        return this.studenteLoggato;
    }

    /**
     * Gets dati tabella tirocinanti.
     *
     * @return the dati tabella tirocinanti
     */
// Metodo per riempire la tabella dei tirocinanti(ovvero studenti la quale richiesta ha stato approvato)
    public List<String[]> getDatiTabellaTirocinanti() {
        TirocinioDAO tirocinioDAO = new TirocinioImplementazioneDAO();
        try{
            return tirocinioDAO.ottieniCatalogoTirocinanti(docenteLoggato.getLogin());
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Errore durante il caricamento del catalogo nel database",e);
            return new ArrayList<>();
        }
    }


    /**
     * Controllo richiesta boolean.
     *
     * @return the boolean
     */
// Metodo per controllare lo stato della Richiesta del tirocinio.
    public boolean controlloRichiesta() {
        RichiestaTirocinioDAO richiestaTirocinioDAO =  new RichiestaTirocinioImplementazioneDAO();
        try{
            return richiestaTirocinioDAO.controlloStatoRichiesta(studenteLoggato.getMatricola());
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Errore durante il controllo delle richieste nel database",e);
            return false;
        }
    }

    /**
     * Controllo inserimento tirocinio boolean.
     *
     * @param tipologiaTirocinio the tipologia tirocinio
     * @return the boolean
     */
// Metodo per controllare se la tipologia del tirocinio inserita sia giusta.
    public boolean controlloInserimentoTirocinio(String tipologiaTirocinio) {
        return tipologiaTirocinio.equalsIgnoreCase(TIPO_INTERNO) || tipologiaTirocinio.equalsIgnoreCase(TIPO_ESTERNO);
    }

    /**
     * Aggiungi nuova tesi boolean.
     *
     * @param titolo    the titolo
     * @param contenuto the contenuto
     * @param data      the data
     * @return the boolean
     */
// Metodo per istanziare una nuova tesi
    public boolean aggiungiNuovaTesi(String titolo, String contenuto, String data) {
        TirocinioDAO tirocinioDAO = new TirocinioImplementazioneDAO();
        TesiDAO tesiDAO = new TesiImplementazioneDAO();
        RichiestaTirocinioDAO richiestaTirocinioDAO = new RichiestaTirocinioImplementazioneDAO();
        try {
            // Inseriamo la tesi nel db
            Integer idTirocinio = tirocinioDAO.getIdTirocinio(studenteLoggato.getMatricola());
            tesiDAO.inserisciTesi(titolo,contenuto,data,idTirocinio,studenteLoggato.getMatricola());
            // Inseriamo nella tabella ponte i dati della tesi e del docente
            Integer idTesi =  tesiDAO.getIdTesi(studenteLoggato.getMatricola());
            String loginDocente = richiestaTirocinioDAO.getLoginDocente(studenteLoggato.getMatricola());
            tesiDAO.inserisciSupervisione(loginDocente,idTesi);
            // Successivamente la inseriamo nel Model
            for (RichiestaTirocinio r : richiesteTirocinio) {
                if (r.getStudente().equals(studenteLoggato) && r.getStatoRichiesta().equals(Stato.APPROVATA)) {
                    Docente docente = r.getDocente();
                    Tesi nuovatesi = new Tesi(studenteLoggato, docente, titolo, contenuto, data);
                    docente.addTesi(nuovatesi);
                    studenteLoggato.setTesi(nuovatesi);
                }
            }
            return true;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Errore durante il salvataggio della tesi nel database",e);
            return false;
        }

    }

    /**
     * Gets dati tabella tesisti.
     *
     * @return the dati tabella tesisti
     */
// Metodi per riempire la tabella dei tesisti
    public List<String []> getDatiTabellaTesisti() {
        TesiDAO tesiDAO = new TesiImplementazioneDAO();
        try{
           return tesiDAO.ottieniCatalogoTesisti(docenteLoggato.getLogin());
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Errore durante il caricamento del catalogo dal database",e);
            return new ArrayList<>();
        }
    }

    /**
     * Gets contenuto tesi singola.
     *
     * @param matricola the matricola
     * @return the contenuto tesi singola
     */
// Metodo per leggere il contenuto dalla tabella data la riga
    public String getContenutoTesiSingola(String matricola) {
        TesiDAO tesiDAO = new TesiImplementazioneDAO();
        try{
            return tesiDAO.leggiContenutoTesi(matricola);
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Errore durante il caricamento della tesi dal database",e);
            return "";
        }
    }

    /**
     * Controllo tesi button boolean.
     *
     * @return the boolean
     */
// Metodo per impedire agli studenti che non hanno terminato il tirocinio di poter caricare la tesi
    public boolean controlloTesiButton() {
        TirocinioDAO tirocinioDAO = new TirocinioImplementazioneDAO();
        try {
            return tirocinioDAO.validaCompletamentoTirocinio(studenteLoggato.getMatricola());
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Errore durante il controllo dell'attributo dal database",e);
            return false;
        }

    }

    /**
     * Modifica stato tesi boolean.
     *
     * @param nuovoStato the nuovo stato
     * @param matricola  the matricola
     * @return the boolean
     */
// Metodo per modificare lo stato della tesi
    public boolean modificaStatoTesi(Stato nuovoStato, String matricola) {
        TesiDAO tesiDAO = new TesiImplementazioneDAO();
        try{
            tesiDAO.setStatoTesi(matricola,nuovoStato.toString());
            return true;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Errore durante la modifica dello stato nel database",e);
            return false;
        }
    }

    /**
     * Get stato tesi studente list.
     *
     * @return the list
     */
// Metodo per la tabella dello stato della tesi dello studente
    public List<String[]> getStatoTesiStudente(){
        TesiDAO tesiDAO = new TesiImplementazioneDAO();
        try{
             return tesiDAO.ottieniCatalogoStatoTesiStudente(studenteLoggato.getMatricola());

        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Errore durante il caricamento dello stato dal database",e);
            return new ArrayList<>();
        }
    }


    /**
     * Sets tirocinio.
     *
     * @param nomeAzienda         the nome azienda
     * @param nominativoReferente the nominativo referente
     * @param argomentoTirocinio  the argomento tirocinio
     * @param matricola           the matricola
     * @return the tirocinio
     */
// Metodo per istanziare il tirocinio quando il docente approva la richiesta
    public boolean setTirocinio(String nomeAzienda,String nominativoReferente,String argomentoTirocinio,String matricola) {
        TirocinioDAO tirocinioDAO = new TirocinioImplementazioneDAO();
        RichiestaTirocinioDAO richiestaTirocinioDAO = new RichiestaTirocinioImplementazioneDAO();
        AziendaDAO aziendaDAO = new  AziendaImplementazioneDAO();
        DocenteDAO docenteDAO = new DocenteImplementazioneDAO();

        try{
            // Recupero dei vari id richiesti per la insert del tirocinio del DataBase
            Integer idRichiesta = richiestaTirocinioDAO.getIdRichiesta(matricola,docenteLoggato.getLogin());
            Integer idAzienda = aziendaDAO.getIdAzienda(nominativoReferente,nomeAzienda);
            Integer idArgomento = docenteDAO.getIdArgomento(docenteLoggato.getLogin(),argomentoTirocinio);

            // Una volta recuperati gli id con i dati della tabella possiamo chiamare il metodo che inserisce il tirocinio e contestualmente crearlo nel Model
            tirocinioDAO.inserisciTirocinio(idRichiesta,idAzienda,docenteLoggato.getLogin(),idArgomento);
            for (RichiestaTirocinio r : richiesteTirocinio) {
                if (r.getStudente().getMatricola().equals(matricola)) {
                    Studente studenteCorrente = r.getStudente();
                    Tirocinio nuovoTirocinio = new Tirocinio(studenteCorrente, docenteLoggato);
                    studenteCorrente.setTirocinio(nuovoTirocinio);
                    docenteLoggato.addTirocinio(nuovoTirocinio);
                }
            }
            return true;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Errore durante il salvataggio del tirocinio nel database",e);
            return false;
        }
    }

    /**
     * Sets termina tirocinio.
     *
     * @param matricolaStudente the matricola studente
     * @return the termina tirocinio
     */
// Metodo per terminare il tirocinio
    public boolean setTerminaTirocinio(String matricolaStudente) {
        RichiestaTirocinioDAO richiestaTirocinioDAO = new RichiestaTirocinioImplementazioneDAO();
        TirocinioDAO tirocinioDAO = new TirocinioImplementazioneDAO();
        try{
            Integer idRichiesta = richiestaTirocinioDAO.getIdRichiesta(matricolaStudente,docenteLoggato.getLogin());
            tirocinioDAO.terminaTirocinio(idRichiesta);
            return true;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Errore durante la modifica dello stato nel database",e);
            return false;
        }
    }

    /**
     * Ha tesi boolean.
     *
     * @return the boolean
     */
// Metodo per verificare che uno studente possa visualizzare lo stato della tesi
    public boolean haTesi() {

        TesiDAO tesiDAO = new TesiImplementazioneDAO();
        try{
            return tesiDAO.haTesiDAO(studenteLoggato.getMatricola());

        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Errore durante il controllo dell'attributo nel database",e);
            return false;
        }
    }
}
