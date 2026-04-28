package model;

import java.util.ArrayList;

public class Tirocinio {
    protected TipologiaTirocinio tipologiaTirocinio;
    protected String argomento;
    protected Boolean completato = false;
    protected Azienda azienda;
    private Studente studente;
    private Docente docente;
    private Tesi tesi;


    // Costruttore Oggetto Tirocinio
    public Tirocinio(TipologiaTirocinio tipologiaTirocinio, String argomento, Boolean completato, Studente studente, Docente docente) {
        this.tipologiaTirocinio = tipologiaTirocinio;
        this.argomento = argomento;
        this.completato = completato;
        this.studente = studente;
        studente.setTirocinio(this);
        this.docente = docente;
        docente.addTirocinio(this);
    }

    public void setTipologiaTirocinio(TipologiaTirocinio tipologiaTirocinio) {
        this.tipologiaTirocinio = tipologiaTirocinio;

    }

    public void setCompletato(Boolean completato) {
        this.completato = completato;
    }

    public void setAzienda(Azienda azienda) {
                this.azienda = azienda;
            if(this.tipologiaTirocinio == TipologiaTirocinio.ESTERNO && this.azienda != null) {
                this.azienda.addTirocinio(this);
            }
        }

        public Tesi getTesi() {
            return tesi;
        }
        public void setTesi(Tesi tesi) {
        this.tesi = tesi;
        }
    }

