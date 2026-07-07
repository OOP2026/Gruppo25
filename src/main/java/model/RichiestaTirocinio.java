package model;

/**
 * Rappresenta la richiesta effettuata da uno Studente,
 * verso un Docente scelto, di iniziare un tirocinio
 * avente un argomento specifico.
 */
public class RichiestaTirocinio {
    private Stato statoRichiesta;
    private Studente studente;
    private Docente docente;
    private Tirocinio tirocinioGenerato;
    private String argomento;
    private String tipologiaTirocinio;

    /**
     * Crea una nuova istanza di RichiestaTirocinio richiamando il costruttore.
     *
     * @param studente  Lo Studente che fa richiesta.
     * @param docente   Il Docente a cui è rivolta la richiesta.
     * @param argomento L'argomento del professore, scelto dallo Studente.
     */
// Costruttore dell'Oggetto RichiestaTirocinio
    public RichiestaTirocinio(Studente studente, Docente docente, String argomento) {
        this.statoRichiesta = Stato.ATTESA;
        this.studente = studente;
        this.docente = docente;
        this.argomento = argomento;
    }

    /**
     * Restituisce lo stato attuale della RichiestaTirocinio.
     *
     * @return Uno Stato che indica l'approvazione, rifiuto, o ancora in attesa di giudizio della RichiestaTirocinio
     */
// Implementazione dei vari metodi get e set di tutti gli attributi della classe
    public Stato getStatoRichiesta() {return this.statoRichiesta;}

    /**
     * Imposta il nuovo stato della Richiesta.
     *
     * @param statoRichiesta UnaIl nuovo stato della richiesta.
     */
    public void setStatoRichiesta(Stato statoRichiesta) {
        this.statoRichiesta = statoRichiesta;
    }

    /**
     * Restituisce lo studente associato alla RichiestaTirocinio.
     *
     * @return L'oggetto Studente associato alla RichiestaTirocinio.
     */
    public Studente getStudente() {return studente;}

    /**
     * Imposta lo Studente associandolo alla RichiestaTirocinio.
     *
     * @param studente Lo Studente che fa la RichiestaTirocinio.
     */
    public void setStudente(Studente studente) {
        this.studente = studente;
    }

    /**
     * Restituisce il Docente asscociato alla RichiestaTirocinio.
     *
     * @return L'oggetto Docente associato alla RichiestaTirocinio.
     */
    public Docente getDocente() {return docente;}

    /**
     * Imposta il Docente scelto dallo Studente, associandolo alla propria RichiestaTirocinio.
     *
     * @param docente L'oggetto Docente scelto dallo Studente.
     */
    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    /**
     * Imposta il tirocinio effettivo generato a partire da questa richiesta o istanza.
     *
     * @param tirocinio Il tirocinio generato da associare.
     */
    public void setTirocinioGenerato(Tirocinio tirocinio) {
        this.tirocinioGenerato = tirocinio;
    }

    /**
     * Restituisce il tirocinio generato associato.
     *
     * @return L'oggetto Tirocinio generato.
     */
    public Tirocinio getTirocinioGenerato() {return tirocinioGenerato;}

    /**
     * Restituisce l'argomento del tirocinio.
     *
     * @return Una stringa contenente l'argomento.
     */
    public String getArgomento(){return argomento;}

    /**
     * Restituisce la tipologia del tirocinio (ad esempio: interno o esterno).
     *
     * @return Una stringa contenente la tipologia del tirocinio.
     */
    public String getTipologiaTirocinio(){
        return this.tipologiaTirocinio;
    }

    /**
     * Imposta la tipologia del tirocinio.
     *
     * @param tipologiaTirocinio La nuova tipologia da assegnare al tirocinio.
     */
    public void setTipologiaTirocinio(String tipologiaTirocinio){
        this.tipologiaTirocinio = tipologiaTirocinio;
    }
}
