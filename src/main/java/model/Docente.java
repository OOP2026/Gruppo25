package model;

import java.util.ArrayList;
import java.util.List;

public class Docente extends Utente {

    private List<String> argomentiTirocinio = new ArrayList<>();
    private List<Tirocinio> tirocinio = new ArrayList<>();
    private List<Tesi> tesi = new ArrayList<>();
    private List<RichiestaTirocinio> richiestaTirocinio = new ArrayList<>();

    //costruttore dell'oggetto Docente
    public Docente(String login, String password, String nome, String cognome, String email, String corsoLaurea) {
        super(login, password, nome, cognome, email, corsoLaurea);

    }

    public void addArgomentoTirocinio(String argomento){this.argomentiTirocinio.add(argomento);}

    public List<String> getArgomentiTirocinio(){return this.argomentiTirocinio;}

    public List<Tirocinio> getTirocinio() { return tirocinio; }

    public void setTirocinio(ArrayList<Tirocinio> tirocinio) { this.tirocinio = tirocinio; }

    public void addTirocinio(Tirocinio nuovoTirocinio) {
        if (nuovoTirocinio != null) {
            this.tirocinio.add(nuovoTirocinio);
        }
    }

    public List<Tesi> getTesi() { return tesi; }
    public void addTesi(Tesi nuovaTesi) {
        if (nuovaTesi != null) {
            this.tesi.add(nuovaTesi);
        }
    }

    public List<RichiestaTirocinio> getRichiestaTirocinio() { return richiestaTirocinio; }

    public void setRichiestaTirocinio(ArrayList<RichiestaTirocinio> richiestaTirocinio) { this.richiestaTirocinio = richiestaTirocinio; }

    public Docente getDocente(){return this;}
}



