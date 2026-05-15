package model;

public class RichiestaTirocinio {
    private Stato statoRichiesta;
    private Studente studente;
    private Docente docente;
    private Tirocinio tirocinioGenerato;

    // Costruttore dell'Oggetto RichiestaTirocinio
    public RichiestaTirocinio(Stato statoRichiesta,  Studente studente, Docente docente) {
        this.statoRichiesta = statoRichiesta;
        this.studente = studente;
        this.docente = docente;

    }

    // Implementazione dei vari metodi get e set di tutti gli attributi della classe
    public Stato getStatoRichiesta() {return statoRichiesta;}

    public void setStatoRichiesta(Stato statoRichiesta) {
        this.statoRichiesta = statoRichiesta;
    }

    public Studente getStudente() {return studente;}

    public void setStudente(Studente studente) {
        this.studente = studente;
    }

    public Docente getDocente() {return docente;}

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public void setTirocinioGenerato(Tirocinio tirocinio) {
        this.tirocinioGenerato = tirocinio;
    }

    public Tirocinio getTirocinioGenerato() {return tirocinioGenerato;}

}
