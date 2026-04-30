package model;

import java.time.LocalTime;
import java.util.Date;

public class SedutaDiLaurea {
    private Date data;
    private LocalTime ora;
    private String aula;
    private Studente studente;

    // Costruttore dell'Oggetto SedutaDiLaurea
    public SedutaDiLaurea(Date data, LocalTime ora, String aula, Studente studente) {
        this.data = data;
        this.ora = ora;
        this.aula = aula;
        this.studente = studente;
        studente.setSedutaDiLaurea(this);
    }

    // Implementazione dei vari metodi get e set di tutti gli attributi della classe
    public Date getData() {return data;}

    public void setData(Date data) {this.data = data;}

    public LocalTime getOra() {return ora;}

    public void setOra(LocalTime ora) {this.ora = ora;}

    public String getAula() {return aula;}

    public void setAula(String aula) {this.aula = aula;}

    public Studente getStudente() {return studente;}

    public void setStudente(Studente studente) {this.studente = studente;}

}