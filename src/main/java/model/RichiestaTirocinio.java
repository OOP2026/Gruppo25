package model;

/**
 * The type Richiesta tirocinio.
 */
public class RichiestaTirocinio {
    private Stato statoRichiesta;
    private Studente studente;
    private Docente docente;
    private Tirocinio tirocinioGenerato;
    private String argomento;
    private String tipologiaTirocinio;

    /**
     * Instantiates a new Richiesta tirocinio.
     *
     * @param studente  the studente
     * @param docente   the docente
     * @param argomento the argomento
     */
// Costruttore dell'Oggetto RichiestaTirocinio
    public RichiestaTirocinio(Studente studente, Docente docente, String argomento) {
        this.statoRichiesta = Stato.ATTESA;
        this.studente = studente;
        this.docente = docente;
        this.argomento = argomento;
    }

    /**
     * Gets stato richiesta.
     *
     * @return the stato richiesta
     */
// Implementazione dei vari metodi get e set di tutti gli attributi della classe
    public Stato getStatoRichiesta() {return this.statoRichiesta;}

    /**
     * Sets stato richiesta.
     *
     * @param statoRichiesta the stato richiesta
     */
    public void setStatoRichiesta(Stato statoRichiesta) {
        this.statoRichiesta = statoRichiesta;
    }

    /**
     * Gets studente.
     *
     * @return the studente
     */
    public Studente getStudente() {return studente;}

    /**
     * Sets studente.
     *
     * @param studente the studente
     */
    public void setStudente(Studente studente) {
        this.studente = studente;
    }

    /**
     * Gets docente.
     *
     * @return the docente
     */
    public Docente getDocente() {return docente;}

    /**
     * Sets docente.
     *
     * @param docente the docente
     */
    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    /**
     * Sets tirocinio generato.
     *
     * @param tirocinio the tirocinio
     */
    public void setTirocinioGenerato(Tirocinio tirocinio) {
        this.tirocinioGenerato = tirocinio;
    }

    /**
     * Gets tirocinio generato.
     *
     * @return the tirocinio generato
     */
    public Tirocinio getTirocinioGenerato() {return tirocinioGenerato;}

    /**
     * Get argomento string.
     *
     * @return the string
     */
    public String getArgomento(){return argomento;}

    /**
     * Get tipologia tirocinio string.
     *
     * @return the string
     */
    public String getTipologiaTirocinio(){
        return this.tipologiaTirocinio;
    }

    /**
     * Set tipologia tirocinio.
     *
     * @param tipologiaTirocinio the tipologia tirocinio
     */
    public void setTipologiaTirocinio(String tipologiaTirocinio){
        this.tipologiaTirocinio = tipologiaTirocinio;
    }
}
