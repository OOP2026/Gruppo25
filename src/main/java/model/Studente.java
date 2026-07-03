package model;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Studente.
 */
public class Studente extends Utente{
    private String matricola;
    private Tirocinio tirocinio;
    private Tesi tesi;
    private List<RichiestaTirocinio> richiestaTirocinio = new ArrayList<>();
    private String argomentoTirocinio;

    /**
     * Instantiates a new Studente.
     *
     * @param login     the login
     * @param password  the password
     * @param nome      the nome
     * @param cognome   the cognome
     * @param email     the email
     * @param matricola the matricola
     */
//Costruttore dell'Oggetto Studente
    public Studente(String login, String password, String nome, String cognome, String email,String matricola) {
        super(login, password, nome, cognome, email);
        this.matricola = matricola;
        this.richiestaTirocinio = new ArrayList<>();
    }

    /**
     * Gets matricola.
     *
     * @return the matricola
     */
// Implementazione dei vari metodi get e set di tutti gli attributi della classe
    public String getMatricola() {return matricola;}

    /**
     * Sets matricola.
     *
     * @param matricola the matricola
     */
    public void  setMatricola(String matricola) {
        this.matricola = matricola;
    }

    /**
     * Gets tirocinio.
     *
     * @return the tirocinio
     */
    public Tirocinio getTirocinio() {return this.tirocinio;}

    /**
     * Sets tirocinio.
     *
     * @param tirocinio the tirocinio
     */
    public void setTirocinio(Tirocinio tirocinio) {this.tirocinio = tirocinio;}

    /**
     * Gets tesi.
     *
     * @return the tesi
     */
    public Tesi getTesi() {return tesi;}

    /**
     * Sets tesi.
     *
     * @param tesi the tesi
     */
    public void setTesi(Tesi tesi) {this.tesi = tesi;}

    /**
     * Gets richiesta tirocinio.
     *
     * @return the richiesta tirocinio
     */
    public List<RichiestaTirocinio> getRichiestaTirocinio() {return richiestaTirocinio;}

    /**
     * Sets richiesta tirocinio.
     *
     * @param richiestaTirocinio the richiesta tirocinio
     */
    public void setRichiestaTirocinio(List<RichiestaTirocinio> richiestaTirocinio) {this.richiestaTirocinio = richiestaTirocinio;}

    /**
     * Get studente studente.
     *
     * @return the studente
     */
    public Studente getStudente(){return this;}

    /**
     * Sets argomento tirocinio.
     *
     * @param argomentoTirocinio the argomento tirocinio
     */
    public void setArgomentoTirocinio(String argomentoTirocinio) {this.argomentoTirocinio = argomentoTirocinio;}

    /**
     * Gets argomento tirocinio.
     *
     * @return the argomento tirocinio
     */
    public String getArgomentoTirocinio() {return argomentoTirocinio;}
}
