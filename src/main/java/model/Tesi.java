package model;

public class Tesi {
    protected Stato statoTesi;
    private Studente studente;
    private Docente docente;

    // costruttore oggetto Tesi
    public Tesi(Stato statoTesi, Studente studente, Docente docente) {
        this.statoTesi = statoTesi;
        this.studente = studente;
        studente.setTesi(this);
        this.docente = docente;
        docente.addTesi(this);
    }

    public Stato getStatotesi() {
        return statoTesi;
    }

    public void setStatotesi(Stato statoTesi) {
        this.statoTesi = statoTesi;
    }

}
