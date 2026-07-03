package model;

/**
 * The type Tirocinio.
 */
public class Tirocinio {
    private String tipologiaTirocinio;
    private String argomento;
    private boolean completato = false;
    private Azienda azienda;
    private Studente studente;
    private Docente docente;
    private Tesi tesi;


    /**
     * Instantiates a new Tirocinio.
     *
     * @param tipologiaTirocinio the tipologia tirocinio
     * @param argomento          the argomento
     * @param studente           the studente
     * @param docente            the docente
     */
// Costruttore dell'Oggetto Tirocinio
    public Tirocinio(String tipologiaTirocinio, String argomento, Studente studente, Docente docente) {
        this.tipologiaTirocinio = tipologiaTirocinio;
        this.argomento = argomento;
        this.completato = false;
        this.studente = studente;
        studente.setTirocinio(this);
        this.docente = docente;
        docente.addTirocinio(this);
    }

    /**
     * Instantiates a new Tirocinio.
     *
     * @param tipologiaTirocinio the tipologia tirocinio
     * @param argomento          the argomento
     */
// Secondo costruttore dell'Oggetto Tirocinio
    public Tirocinio(String tipologiaTirocinio, String argomento){
        this.tipologiaTirocinio = tipologiaTirocinio;
        this.argomento = argomento;
    }

    /**
     * Instantiates a new Tirocinio.
     *
     * @param studente the studente
     * @param docente  the docente
     */
// Terzo costruttore dell'Oggetto Tirocinio
    public Tirocinio(Studente studente, Docente docente){
        this.studente = studente;
        this.docente = docente;
    }

    /**
     * Sets tipologia tirocinio.
     *
     * @param tipologiaTirocinio the tipologia tirocinio
     */
// Implementazione dei vari metodi get e set di tutti gli attributi della classe
    public void setTipologiaTirocinio(String tipologiaTirocinio) {
        this.tipologiaTirocinio = tipologiaTirocinio;
    }

    /**
     * Gets tipologia tirocinio.
     *
     * @return the tipologia tirocinio
     */
    public String getTipologiaTirocinio() {return tipologiaTirocinio;}

    /**
     * Sets argomento.
     *
     * @param argomento the argomento
     */
    public void setArgomento(String argomento) {
        this.argomento = argomento;
    }

    /**
     * Gets argomento.
     *
     * @return the argomento
     */
    public String getArgomento() {return argomento;}

    /**
     * Sets completato.
     *
     * @param completato the completato
     */
    public void setCompletato(Boolean completato) {
        this.completato = completato;
    }

    /**
     * Gets completato.
     *
     * @return the completato
     */
    public boolean getCompletato() {return this.completato;}

    /**
     * Sets azienda.
     *
     * @param azienda the azienda
     */
    public void setAzienda(Azienda azienda) {
                this.azienda = azienda;
            if(this.tipologiaTirocinio.equalsIgnoreCase("ESTERNO") && this.azienda != null){
                this.azienda.addTirocinio(this);
            }
        }

    /**
     * Gets azienda.
     *
     * @return the azienda
     */
    public Azienda getAzienda() {return azienda;}

    /**
     * Sets studente.
     *
     * @param studente the studente
     */
    public void setStudente(Studente studente) {
        this.studente = studente;
    }

    /**
     * Gets studente.
     *
     * @return the studente
     */
    public Studente getStudente() {return studente;}

    /**
     * Sets docente.
     *
     * @param docente the docente
     */
    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    /**
     * Gets docente.
     *
     * @return the docente
     */
    public Docente getDocente() {return docente;}

    /**
     * Gets tesi.
     *
     * @return the tesi
     */
    public Tesi getTesi() {
        return tesi;
    }

    /**
     * Sets tesi.
     *
     * @param tesi the tesi
     */
    public void setTesi(Tesi tesi) {
        this.tesi = tesi;
    }

}

