package model;

/**
 * The type Tesi.
 */
public class Tesi {
    private Stato statoTesi;
    private Studente studente;
    private Docente docente;
    private String titolo;
    private String contenuto;
    private String sedutaDiLaurea;

    /**
     * Instantiates a new Tesi.
     *
     * @param studente       the studente
     * @param docente        the docente
     * @param titolo         the titolo
     * @param contenuto      the contenuto
     * @param sedutaDiLaurea the seduta di laurea
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
     * Gets stato tesi.
     *
     * @return the stato tesi
     */
// Implementazione dei vari metodi get e set di tutti gli attributi della classe
    public Stato getStatoTesi() {return statoTesi;}

    /**
     * Sets stato tesi.
     *
     * @param statoTesi the stato tesi
     */
    public void setStatoTesi(Stato statoTesi) {this.statoTesi = statoTesi;}

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
    public void setStudente(Studente studente) {this.studente = studente;}

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
    public void setDocente(Docente docente) {this.docente = docente;}

    /**
     * Gets titolo.
     *
     * @return the titolo
     */
    public String getTitolo() {return titolo;}

    /**
     * Gets contenuto.
     *
     * @return the contenuto
     */
    public String getContenuto() {return contenuto;}

    /**
     * Gets seduta di laurea.
     *
     * @return the seduta di laurea
     */
    public String getSedutaDiLaurea() {return sedutaDiLaurea;}

}
