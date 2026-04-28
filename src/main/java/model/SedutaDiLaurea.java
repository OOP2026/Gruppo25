package model;

import java.time.LocalTime;
import java.util.Date;

public class SedutaDiLaurea {
    protected Date data;
    protected LocalTime ora;
    protected String aula;
    private Studente studente;

    // costruttore oggetto SedutaDiLaurea
    public SedutaDiLaurea(Date data, LocalTime ora, String aula, Studente studente) {
        this.data = data;
        this.ora = ora;
        this.aula = aula;
        this.studente = studente;
        studente.setSedutaDiLaurea(this);
    }
}
