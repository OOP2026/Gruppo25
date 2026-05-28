package model;

public class RichiestaTirocinio {
    private Stato statoRichiesta;
    private Studente studente;
    private Docente docente;
    private Tirocinio tirocinioGenerato;
    private String argomento;
    private String tipologiaTirocinio;

    // Costruttore dell'Oggetto RichiestaTirocinio
    public RichiestaTirocinio(Studente studente, Docente docente, String argomento) {
        this.statoRichiesta = Stato.ATTESA;
        this.studente = studente;
        this.docente = docente;
        this.argomento = argomento;
    }

    // Implementazione dei vari metodi get e set di tutti gli attributi della classe
    public Stato getStatoRichiesta() {return this.statoRichiesta;}

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

    public String getArgomento(){return argomento;}

    public String getTipologiaTirocinio(){
        return this.tipologiaTirocinio;
    }

    public void setTipologiaTirocinio(String tipologiaTirocinio){
        this.tipologiaTirocinio = tipologiaTirocinio;
    }
}
