package model;

// Classe temporanea in sostituzione al db
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultListModel;
import java.util.ArrayList;
import java.util.List;

public class SistemaUniversitario {
    private List<Studente> studenti;
    private List<Docente> docenti;

    public  SistemaUniversitario(){
        this.studenti = new ArrayList<>();
        this.docenti = new ArrayList<>();
    }

    //Metodo per aggiungere studenti nella lista
    public void aggiungiStudente(Studente studente){studenti.add(studente);}
    // Metodo per prendere studenti dalla lista
    public List<Studente> getStudenti() {return studenti;}
    // Metodo per aggiungere docenti nella lista
    public void aggiungiDocente(Docente docente){docenti.add(docente);}
    // Metodo per prendere docenti dalla lista
    public List<Docente> getDocenti() {return docenti;}



}

