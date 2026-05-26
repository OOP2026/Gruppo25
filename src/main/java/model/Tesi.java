package model;

public class Tesi {
    private Stato statoTesi;
    private Studente studente;
    private Docente docente;
    private String titolo;
    private String contenuto;
    private String sedutaDiLaurea;

    // Costruttore dell'Oggetto Tesi
    public Tesi(Stato statoTesi, Studente studente, Docente docente, String titolo, String contenuto, String sedutaDiLaurea ) {
        this.statoTesi = Stato.ATTESA;
        this.studente = studente;
        this.titolo = titolo;
        this.contenuto = contenuto;
        studente.setTesi(this);
        this.docente = docente;
        docente.addTesi(this);
        this.sedutaDiLaurea = sedutaDiLaurea;
    }

    // Implementazione dei vari metodi get e set di tutti gli attributi della classe
    public Stato getStatoTesi() {return statoTesi;}

    public void setStatoTesi(Stato statoTesi) {this.statoTesi = statoTesi;}

    public Studente getStudente() {return studente;}

    public void setStudente(Studente studente) {this.studente = studente;}

    public Docente getDocente() {return docente;}

    public void setDocente(Docente docente) {this.docente = docente;}

    public String getTitolo() {return titolo;}

    public String getContenuto() {return contenuto;}


}
