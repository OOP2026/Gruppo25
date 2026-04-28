package model;

public class RichiestaTirocinio {
    private Stato statoRichiesta;
    private Studente studente;
    private Docente docente;
    private Tirocinio tirocinioGenerato;

    // costruttore dell'oggetto RichiestaTirocinio
    public RichiestaTirocinio(Stato statoRichiesta,  Studente studente, Docente docente) {
        this.statoRichiesta = statoRichiesta;
        this.studente = studente;
        this.docente = docente;

    }

    public Stato getStatoRichiesta() {
        return statoRichiesta;
    }
    public void setStatoRichiesta(Stato statoRichiesta) {
        this.statoRichiesta = statoRichiesta;
    }

    public Studente getStudente() {
        return studente;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setTirocinioGenerato(Tirocinio tirocinio) {
        this.tirocinioGenerato = tirocinio;
    }
    public Tirocinio getTirocinioGenerato() {
        return tirocinioGenerato;
    }

}
