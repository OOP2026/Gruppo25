package model;

/**
 * The type Utente.
 */
public class Utente {
    private String login;
    private String password;
    private String nome;
    private String cognome;
    private String email;

    /**
     * Instantiates a new Utente.
     *
     * @param login    the login
     * @param password the password
     * @param nome     the nome
     * @param cognome  the cognome
     * @param email    the email
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
     * Gets login.
     *
     * @return the login
     */
// Implementazione dei vari metodi get e set di tutti gli attributi della classe
    public String getLogin() {return login;}

    /**
     * Sets login.
     *
     * @param login the login
     */
    public void setLogin(String login) {this.login = login;}

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {return password;}

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {this.password = password;}

    /**
     * Gets nome.
     *
     * @return the nome
     */
    public String getNome() {return nome;}

    /**
     * Sets nome.
     *
     * @param nome the nome
     */
    public void setNome(String nome) {this.nome = nome;}

    /**
     * Gets cognome.
     *
     * @return the cognome
     */
    public String getCognome() {return cognome;}

    /**
     * Sets cognome.
     *
     * @param cognome the cognome
     */
    public void setCognome(String cognome) {this.cognome = cognome;}

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {return email;}

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {this.email = email;}
}
