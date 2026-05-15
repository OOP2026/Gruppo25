package model;

public class Tesi {
    private Stato statoTesi;
    private Studente studente;
    private Docente docente;

    // Costruttore dell'Oggetto Tesi
    public Tesi(Stato statoTesi, Studente studente, Docente docente) {
        this.statoTesi = statoTesi;
        this.studente = studente;
        studente.setTesi(this);
        this.docente = docente;
        docente.addTesi(this);
    }

    // Implementazione dei vari metodi get e set di tutti gli attributi della classe
    public Stato getStatoTesi() {
        return statoTesi;
    }

    public void setStatoTesi(Stato statoTesi) {this.statoTesi = statoTesi;}

    public Studente getStudente() {return studente;}

    public void setStudente(Studente studente) {this.studente = studente;}

    public Docente getDocente() {return docente;}

    public void setDocente(Docente docente) {this.docente = docente;}

}
