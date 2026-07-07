package model;

/**
 * Rappresenta una tesi di laurea all'interno del sistema.
 * Gestisce le informazioni relative allo stato della tesi, allo studente associato,
 * al docente relatore, al titolo, al contenuto e alla data della relativa seduta di laurea.
 */
public class Tesi {
    private Stato statoTesi;
    private Studente studente;
    private Docente docente;
    private String titolo;
    private String contenuto;
    private String sedutaDiLaurea;

    /**
     * Crea una nuova istanza di Tesi, impostando lo stato iniziale in ATTESA
     * e collegando automaticamente la tesi sia allo studente che al docente relatore.
     *
     * @param studente       Lo studente proprietario della tesi.
     * @param docente        Il docente che fa da relatore per la tesi.
     * @param titolo         Il titolo della tesi.
     * @param contenuto      Il contenuto della tesi.
     * @param sedutaDiLaurea La data e la sessione della seduta di laurea.
     */
// Costruttore dell'Oggetto Tesi
    public Tesi(Studente studente, Docente docente, String titolo, String contenuto, String sedutaDiLaurea ) {
        this.statoTesi = Stato.ATTESA;
        this.studente = studente;
        this.titolo = titolo;
        this.contenuto = contenuto;
        studente.setTesi(this);
        this.docente = docente;
        docente.addTesi(this);
        this.sedutaDiLaurea = sedutaDiLaurea;
    }

    /**
     * Restituisce lo stato attuale della tesi.
     *
     * @return L'oggetto Stato che rappresenta la fase in cui si trova la tesi.
     */
// Implementazione dei vari metodi get e set di tutti gli attributi della classe
    public Stato getStatoTesi() {return statoTesi;}

    /**
     * Imposta il nuovo stato della tesi.
     *
     * @param statoTesi Il nuovo stato da assegnare alla tesi.
     */
    public void setStatoTesi(Stato statoTesi) {this.statoTesi = statoTesi;}

    /**
     * Restituisce lo studente associato alla tesi.
     *
     * @return L'oggetto Studente autore della tesi.
     */
    public Studente getStudente() {return studente;}

    /**
     * Imposta lo studente associato alla tesi.
     *
     * @param studente Il nuovo studente da associare alla tesi.
     */
    public void setStudente(Studente studente) {this.studente = studente;}

    /**
     * Restituisce il docente relatore della tesi.
     *
     * @return L'oggetto Docente che fa da relatore.
     */
    public Docente getDocente() {return docente;}

    /**
     * Imposta il docente relatore della tesi.
     *
     * @param docente Il nuovo docente relatore da associare.
     */
    public void setDocente(Docente docente) {this.docente = docente;}

    /**
     * Restituisce il titolo della tesi.
     *
     * @return Una stringa contenente il titolo della tesi.
     */
    public String getTitolo() {return titolo;}

    /**
     * Restituisce il contenuto della tesi.
     *
     * @return Una stringa contenente il contenuto informativo della tesi.
     */
    public String getContenuto() {return contenuto;}

    /**
     * Restituisce le informazioni sulla seduta di laurea.
     *
     * @return Una stringa contenente i dettagli della seduta di laurea.
     */
    public String getSedutaDiLaurea() {return sedutaDiLaurea;}

}
