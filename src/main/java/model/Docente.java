package model;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Docente.
 */
public class Docente extends Utente {

    private List<String> argomentiTirocinio = new ArrayList<>();
    private List<Tirocinio> tirocinio = new ArrayList<>();
    private List<Tesi> tesi = new ArrayList<>();
    private List<RichiestaTirocinio> richiestaTirocinio = new ArrayList<>();
    private List<Tirocinio> tirociniProposti = new ArrayList<>();

    /**
     * Instantiates a new Docente.
     *
     * @param login    the login
     * @param password the password
     * @param nome     the nome
     * @param cognome  the cognome
     * @param email    the email
     */
//costruttore dell'oggetto Docente
    public Docente(String login, String password, String nome, String cognome, String email) {
        super(login, password, nome, cognome, email);

    }


    /**
     * Add argomento tirocinio.
     *
     * @param argomento the argomento
     */
    public void addArgomentoTirocinio(String argomento){this.argomentiTirocinio.add(argomento);}

    /**
     * Get argomenti tirocinio list.
     *
     * @return the list
     */
    public List<String> getArgomentiTirocinio(){return this.argomentiTirocinio;}

    /**
     * Gets tirocinio.
     *
     * @return the tirocinio
     */
    public List<Tirocinio> getTirocinio() { return tirocinio; }

    /**
     * Sets tirocinio.
     *
     * @param tirocinio the tirocinio
     */
    public void setTirocinio(ArrayList<Tirocinio> tirocinio) { this.tirocinio = tirocinio; }

    /**
     * Add tirocinio.
     *
     * @param nuovoTirocinio the nuovo tirocinio
     */
    public void addTirocinio(Tirocinio nuovoTirocinio) {
        if (nuovoTirocinio != null) {
            this.tirocinio.add(nuovoTirocinio);
        }
    }

    /**
     * Gets tesi.
     *
     * @return the tesi
     */
    public List<Tesi> getTesi() { return tesi; }

    /**
     * Add tesi.
     *
     * @param nuovaTesi the nuova tesi
     */
    public void addTesi(Tesi nuovaTesi) {
        if (nuovaTesi != null) {
            this.tesi.add(nuovaTesi);
        }
    }

    /**
     * Gets richiesta tirocinio.
     *
     * @return the richiesta tirocinio
     */
    public List<RichiestaTirocinio> getRichiestaTirocinio() { return richiestaTirocinio; }

    /**
     * Sets richiesta tirocinio.
     *
     * @param richiestaTirocinio the richiesta tirocinio
     */
    public void setRichiestaTirocinio(ArrayList<RichiestaTirocinio> richiestaTirocinio) { this.richiestaTirocinio = richiestaTirocinio; }

    /**
     * Get docente docente.
     *
     * @return the docente
     */
    public Docente getDocente(){return this;}

    /**
     * Add tirocinio proposto.
     *
     * @param tirocinio the tirocinio
     */
    public void addTirocinioProposto(Tirocinio tirocinio) {
        this.tirociniProposti.add(tirocinio);
    }

    /**
     * Gets tirocini proposti.
     *
     * @return the tirocini proposti
     */
    public List<Tirocinio> getTirociniProposti() {
        return this.tirociniProposti;
    }

    /**
     * Rimuovi tesi.
     *
     * @param indice the indice
     */
    public void rimuoviTesi(int indice){
        tesi.remove(indice);
    }
}



