package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Rappresenta uno studente universitario all'interno del sistema.
 * Estende la classe Utente e gestisce le informazioni relative alla matricola,
 * al tirocinio attivo, alla tesi prodotta dallo stesso e all'elenco delle richieste effettuate.
 */
public class Studente extends Utente{
    private String matricola;
    private Tirocinio tirocinio;
    private Tesi tesi;
    private List<RichiestaTirocinio> richiestaTirocinio = new ArrayList<>();
    private String argomentoTirocinio;

    /**
     * Crea una nuova istanza di Studente richiamando il costruttore della superclasse Utente
     * e inizializzando la matricola e la lista delle richieste.
     *
     * @param login     L'username per l'accesso.
     * @param password  La password per l'autenticazione.
     * @param nome      Il nome dello studente.
     * @param cognome   Il cognome dello studente.
     * @param email     L'indirizzo email istituzionale dello studente, avente dominio "@studenti.unina.it".
     * @param matricola Il codice identificativo (matricola) dello studente.
     */
//Costruttore dell'Oggetto Studente
    public Studente(String login, String password, String nome, String cognome, String email,String matricola) {
        super(login, password, nome, cognome, email);
        this.matricola = matricola;
        this.richiestaTirocinio = new ArrayList<>();
    }

    /**
     * Restituisce il numero di matricola dello studente.
     *
     * @return Una stringa contenente la matricola dello studente.
     */
// Implementazione dei vari metodi get e set di tutti gli attributi della classe
    public String getMatricola() {return matricola;}

    /**
     * Imposta il numero di matricola dello studente.
     *
     * @param matricola La nuova matricola da assegnare allo studente.
     */
    public void  setMatricola(String matricola) {
        this.matricola = matricola;
    }

    /**
     * Restituisce il tirocinio associato allo studente.
     *
     * @return L'oggetto Tirocinio dello studente.
     */
    public Tirocinio getTirocinio() {return this.tirocinio;}

    /**
     * Imposta il tirocinio per lo studente.
     *
     * @param tirocinio Il tirocinio da associare allo studente.
     */
    public void setTirocinio(Tirocinio tirocinio) {this.tirocinio = tirocinio;}

    /**
     * Restituisce la tesi assegnata allo studente.
     *
     * @return L'oggetto Tesi dello studente.
     */
    public Tesi getTesi() {return tesi;}

    /**
     * Imposta la tesi per lo studente.
     *
     * @param tesi La tesi da associare allo studente.
     */
    public void setTesi(Tesi tesi) {this.tesi = tesi;}

    /**
     * Restituisce la lista di tutte le richieste di tirocinio effettuate dallo studente.
     *
     * @return Una lista di oggetti RichiestaTirocinio.
     */
    public List<RichiestaTirocinio> getRichiestaTirocinio() {return richiestaTirocinio;}

    /**
     * Imposta la lista delle richieste di tirocinio dello studente.
     *
     * @param richiestaTirocinio La nuova lista di richieste da assegnare.
     */
    public void setRichiestaTirocinio(List<RichiestaTirocinio> richiestaTirocinio) {this.richiestaTirocinio = richiestaTirocinio;}

    /**
     * Restituisce l'istanza corrente dello studente.
     *
     * @return L'oggetto Studente corrente (this).
     */
    public Studente getStudente(){return this;}

    /**
     * Imposta l'argomento o l'area tematica di interesse per il tirocinio.
     *
     * @param argomentoTirocinio Il nuovo argomento da assegnare.
     */
    public void setArgomentoTirocinio(String argomentoTirocinio) {this.argomentoTirocinio = argomentoTirocinio;}

    /**
     * Restituisce l'argomento o l'area tematica del tirocinio dello studente.
     *
     * @return Una stringa contenente l'argomento del tirocinio.
     */
    public String getArgomentoTirocinio() {return argomentoTirocinio;}
}
