package model;

/**
 * Rappresenta un utente generico registrato all'interno del sistema.
 * Questa classe funge da superclasse per le diverse tipologie di utenti (Studente e Docente)
 * e ne gestisce le credenziali di accesso e i dati fondamentali.
 */
public class Utente {
    private String login;
    private String password;
    private String nome;
    private String cognome;
    private String email;

    /**
     * Crea una nuova istanza di Utente inizializzando le credenziali e i dati anagrafici.
     *
     * @param login    L'username per l'accesso.
     * @param password La password per l'autenticazione.
     * @param nome     Il nome dell'utente.
     * @param cognome  Il cognome dell'utente.
     * @param email    L'indirizzo email dell'utente.
     */
// Costruttore dell'Oggetto Utente
    public Utente(String login, String password, String nome, String cognome, String email) {
        this.login = login;
        this.password = password;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
    }

    /**
     * Restituisce l'username (login) dell'utente.
     *
     * @return Una stringa contenente lo username dell'utente.
     */
// Implementazione dei vari metodi get e set di tutti gli attributi della classe
    public String getLogin() {return login;}

    /**
     * Imposta l'username (login) dell'utente.
     *
     * @param login Il nuovo username da assegnare all'utente.
     */
    public void setLogin(String login) {this.login = login;}

    /**
     * Restituisce la password dell'utente.
     *
     * @return Una stringa contenente la password dell'utente.
     */
    public String getPassword() {return password;}

    /**
     * Imposta la password dell'utente.
     *
     * @param password La nuova password da assegnare all'utente.
     */
    public void setPassword(String password) {this.password = password;}

    /**
     * Restituisce il nome dell'utente.
     *
     * @return Una stringa contenente il nome dell'utente.
     */
    public String getNome() {return nome;}

    /**
     * Imposta il nome dell'utente.
     *
     * @param nome Il nuovo nome da assegnare all'utente.
     */
    public void setNome(String nome) {this.nome = nome;}

    /**
     * Restituisce il cognome dell'utente.
     *
     * @return Una stringa contenente il cognome dell'utente.
     */
    public String getCognome() {return cognome;}

    /**
     * Imposta il cognome dell'utente.
     *
     * @param cognome Il nuovo cognome da assegnare all'utente.
     */
    public void setCognome(String cognome) {this.cognome = cognome;}

    /**
     * Restituisce l'indirizzo email dell'utente.
     *
     * @return Una stringa contenente l'email dell'utente.
     */
    public String getEmail() {return email;}

    /**
     * Imposta l'indirizzo email dell'utente.
     *
     * @param email Il nuovo indirizzo email da assegnare all'utente.
     */
    public void setEmail(String email) {this.email = email;}
}
