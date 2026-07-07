package model;

/**
 * L'enumeration Stato serve per dare un dominio ben preciso
 * agli stati della RichiestaTirocinio e della Tesi.
 */
public enum Stato {
    /**
     * Lo Stato APPROVATA, nel caso in cui il Docente Approvi la RichiestaTirocinio
     * oppure la Tesi di uno Studente.
     */
    APPROVATA,
    /**
     * Lo Stato RIFIUTATA, nel caso in cui il Docente Rifiuti la RichiestaTirocinio
     * oppure la Tesi di uno Studente.
     */
    RIFIUTATA,
    /**
     * Lo Stato ATTESA, nel caso in cui il Docente ancora debba giudicare la RichiestaTirocinio
     * oppure la Tesi di uno Studente.
     */
    ATTESA
}
