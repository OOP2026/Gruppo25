package model;

import java.util.ArrayList;

public class Tirocinio {
    private String tipologiaTirocinio;
    private String argomento;
    private Boolean completato = false;
    private Azienda azienda;
    private Studente studente;
    private Docente docente;
    private Tesi tesi;

    public Tirocinio(String tipologiaTirocinio, String argomento){
        this.tipologiaTirocinio = tipologiaTirocinio;
        this.argomento = argomento;
    }

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

    // Implementazione dei vari metodi get e set di tutti gli attributi della classe
    public void setTipologiaTirocinio(String tipologiaTirocinio) {
        this.tipologiaTirocinio = tipologiaTirocinio;
    }

    public String getTipologiaTirocinio() {return tipologiaTirocinio;}

    public void setArgomento(String argomento) {
        this.argomento = argomento;
    }

    public String getArgomento() {return argomento;}

    public void setCompletato(Boolean completato) {
        this.completato = completato;
    }

    public Boolean getCompletato() {return completato;}

    public void setAzienda(Azienda azienda) {
                this.azienda = azienda;
            if(this.tipologiaTirocinio.equalsIgnoreCase("ESTERNO") && this.azienda != null){
                this.azienda.addTirocinio(this);
            }
        }

    public Azienda getAzienda() {return azienda;}

    public void setStudente(Studente studente) {
        this.studente = studente;
    }

    public Studente getStudente() {return studente;}

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public Docente getDocente() {return docente;}

    public Tesi getTesi() {
        return tesi;
    }

    public void setTesi(Tesi tesi) {
        this.tesi = tesi;
    }

}

