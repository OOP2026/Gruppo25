package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Rappresenta un docente universitario all'interno del sistema.
 * Estende la classe Utente e gestisce le attività relative ai tirocini,
 * alle tesi associate e alle richieste (di tirocinio o di tesi) da parte degli studenti.
 */
public class Docente extends Utente {

    private List<String> argomentiTirocinio = new ArrayList<>();
    private List<Tirocinio> tirocinio = new ArrayList<>();
    private List<Tesi> tesi = new ArrayList<>();
    private List<RichiestaTirocinio> richiestaTirocinio = new ArrayList<>();
    private List<Tirocinio> tirociniProposti = new ArrayList<>();

    /**
     * Crea una nuova istanza di Docente richiamando il costruttore della superclasse Utente.
     *
     * @param login    L'username per l'accesso.
     * @param password La password per l'autenticazione dell'account.
     * @param nome     Il nome del docente.
     * @param cognome  Il cognome del docente.
     * @param email    L'indirizzo email istituzionale del docente avente dominio "@docenti.unina.it".
     */
//costruttore dell'oggetto Docente
    public Docente(String login, String password, String nome, String cognome, String email) {
        super(login, password, nome, cognome, email);
    }

    /**
     * Aggiunge un nuovo argomento di interesse per i tirocini alla lista del docente.
     *
     * @param argomento Il testo o il tema dell'argomento da aggiungere.
     */
    public void addArgomentoTirocinio(String argomento){this.argomentiTirocinio.add(argomento);}

    /**
     * Restituisce la lista degli argomenti di tirocinio trattati dal docente.
     *
     * @return Una lista di stringhe contenente gli argomenti di tirocinio per docente.
     */
    public List<String> getArgomentiTirocinio(){return this.argomentiTirocinio;}

    /**
     * Restituisce la lista dei tirocini associati al docente.
     *
     * @return Una lista di oggetti Tirocinio.
     */
    public List<Tirocinio> getTirocinio() { return tirocinio; }

    /**
     * Imposta la lista dei tirocini associati al docente.
     *
     * @param tirocinio La nuova lista di tirocini da assegnare.
     */
    public void setTirocinio(ArrayList<Tirocinio> tirocinio) { this.tirocinio = tirocinio; }

    /**
     * Aggiunge un oggetto Tirocinio alla lista del docente, previa verifica che non sia nullo.
     *
     * @param nuovoTirocinio Il nuovo tirocinio da aggiungere.
     */
    public void addTirocinio(Tirocinio nuovoTirocinio) {
        if (nuovoTirocinio != null) {
            this.tirocinio.add(nuovoTirocinio);
        }
    }

    /**
     * Restituisce la lista delle tesi seguite dal docente.
     *
     * @return Una lista di oggetti Tesi.
     */
    public List<Tesi> getTesi() { return tesi; }

    /**
     * Aggiunge una nuova tesi alla lista del docente, previa verifica che non sia nulla.
     *
     * @param nuovaTesi La nuova tesi da aggiungere.
     */
    public void addTesi(Tesi nuovaTesi) {
        if (nuovaTesi != null) {
            this.tesi.add(nuovaTesi);
        }
    }

    /**
     * Restituisce la lista delle richieste di tirocinio ricevute dal docente.
     *
     * @return Una lista di oggetti RichiestaTirocinio.
     */
    public List<RichiestaTirocinio> getRichiestaTirocinio() { return richiestaTirocinio; }

    /**
     * Imposta la lista delle richieste di tirocinio del docente.
     *
     * @param richiestaTirocinio La nuova lista di richieste da assegnare.
     */
    public void setRichiestaTirocinio(ArrayList<RichiestaTirocinio> richiestaTirocinio) { this.richiestaTirocinio = richiestaTirocinio; }

    /**
     * Restituisce l'istanza corrente del docente.
     *
     * @return L'oggetto Docente corrente (this).
     */
    public Docente getDocente(){return this;}

    /**
     * Aggiunge un tirocinio all'elenco dei tirocini proposti dal docente.
     *
     * @param tirocinio Il tirocinio proposto da aggiungere alla lista.
     */
    public void addTirocinioProposto(Tirocinio tirocinio) {
        this.tirociniProposti.add(tirocinio);
    }

    /**
     * Restituisce la lista di tutti i tirocini proposti dal docente.
     *
     * @return Una lista di oggetti Tirocinio rappresentanti le proposte.
     */
    public List<Tirocinio> getTirociniProposti() {
        return this.tirociniProposti;
    }

    /**
     * Rimuove una tesi dalla lista del docente in base alla sua posizione.
     *
     * @param indice La posizione (ID numerico) della tesi da rimuovere all'interno della lista.
     */
    public void rimuoviTesi(int indice){
        tesi.remove(indice);
    }
}



