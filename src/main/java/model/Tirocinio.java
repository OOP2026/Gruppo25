package model;

/**
 * Rappresenta un tirocinio all'interno del sistema.
 * Gestisce le informazioni sulle caratteristiche del tirocinio (tipologia, argomento, stato),
 * e le relazioni con lo studente, il docente, l'eventuale azienda ospitante e la tesi associata.
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
     * Crea una nuova istanza di Tirocinio definendo la tipologia e l'argomento,
     * e collegando automaticamente il tirocinio allo studente e al docente tutor.
     *
     * @param tipologiaTirocinio La tipologia del tirocinio (es. INTERNO o ESTERNO).
     * @param argomento          L'argomento del tirocinio.
     * @param studente           Lo studente che svolge il tirocinio.
     * @param docente            Il docente che fa da tutor per il tirocinio.
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
     * Crea una nuova istanza di Tirocinio specificando solamente la tipologia e l'argomento.
     *
     * @param tipologiaTirocinio La tipologia del tirocinio (es. INTERNO o ESTERNO).
     * @param argomento          L'argomento o del tirocinio.
     */
// Secondo costruttore dell'Oggetto Tirocinio
    public Tirocinio(String tipologiaTirocinio, String argomento){
        this.tipologiaTirocinio = tipologiaTirocinio;
        this.argomento = argomento;
    }

    /**
     * Crea una nuova istanza di Tirocinio associando solamente lo studente e il docente tutor.
     *
     * @param studente Lo studente che svolge il tirocinio.
     * @param docente  Il docente che fa da tutor per il tirocinio.
     */
// Terzo costruttore dell'Oggetto Tirocinio
    public Tirocinio(Studente studente, Docente docente){
        this.studente = studente;
        this.docente = docente;
    }

    /**
     * Imposta la tipologia del tirocinio.
     *
     * @param tipologiaTirocinio La nuova tipologia da assegnare al tirocinio.
     */
// Implementazione dei vari metodi get e set di tutti gli attributi della classe
    public void setTipologiaTirocinio(String tipologiaTirocinio) {
        this.tipologiaTirocinio = tipologiaTirocinio;
    }

    /**
     * Restituisce la tipologia del tirocinio.
     *
     * @return Una stringa contenente la tipologia del tirocinio.
     */
    public String getTipologiaTirocinio() {return tipologiaTirocinio;}

    /**
     * Imposta l'argomento del tirocinio.
     *
     * @param argomento Il nuovo argomento da assegnare al tirocinio.
     */
    public void setArgomento(String argomento) {
        this.argomento = argomento;
    }

    /**
     * Restituisce l'argomento del tirocinio.
     *
     * @return Una stringa contenente l'argomento del tirocinio.
     */
    public String getArgomento() {return argomento;}

    /**
     * Imposta lo stato di completamento del tirocinio.
     *
     * @param completato Vero se il tirocinio è completato, falso altrimenti.
     */
    public void setCompletato(Boolean completato) {
        this.completato = completato;
    }

    /**
     * Restituisce lo stato di completamento del tirocinio.
     *
     * @return Vero se il tirocinio è stato completato, falso altrimenti.
     */
    public boolean getCompletato() {return this.completato;}

    /**
     * Imposta l'azienda in collaborazione con quel Tirocinio. Se il tirocinio è di tipo ESTERNO,
     * provvede ad aggiungere automaticamente il tirocinio alla lista dell'azienda.
     *
     * @param azienda L'azienda da associare al tirocinio.
     */
    public void setAzienda(Azienda azienda) {
        this.azienda = azienda;
        if(this.tipologiaTirocinio.equalsIgnoreCase("ESTERNO") && this.azienda != null){
            this.azienda.addTirocinio(this);
        }
    }

    /**
     * Restituisce l'azienda associata al tirocinio.
     *
     * @return L'oggetto Azienda associata al Tirocinio. Sarà null se il tirocinio è INTERNO.
     */
    public Azienda getAzienda() {return azienda;}

    /**
     * Imposta lo studente assegnato al tirocinio.
     *
     * @param studente Il nuovo studente da associare.
     */
    public void setStudente(Studente studente) {
        this.studente = studente;
    }

    /**
     * Restituisce lo studente che svolge il tirocinio.
     *
     * @return L'oggetto Studente associato.
     */
    public Studente getStudente() {return studente;}

    /**
     * Imposta il docente tutor per il tirocinio.
     *
     * @param docente Il nuovo docente tutor da associare.
     */
    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    /**
     * Restituisce il docente tutor del tirocinio.
     *
     * @return L'oggetto Docente associato.
     */
    public Docente getDocente() {return docente;}

    /**
     * Restituisce la tesi che segue l'esperienza del tirocinio.
     *
     * @return L'oggetto Tesi associato, o null se non è presente una tesi.
     */
    public Tesi getTesi() {
        return tesi;
    }

    /**
     * Imposta la tesi collegata al tirocinio.
     *
     * @param tesi La nuova tesi da associare al tirocinio.
     */
    public void setTesi(Tesi tesi) {
        this.tesi = tesi;
    }

}

