package model;

import java.util.ArrayList;
import java.util.List;

public class Docente extends Utente {

    private ArrayList<String> argomentiTirocinio = new ArrayList<>();
    private ArrayList<Tirocinio> tirocinio = new ArrayList<>();
    private ArrayList<Tesi> tesi = new ArrayList<>();
    private ArrayList<RichiestaTirocinio> richiestaTirocinio = new ArrayList<>();

    //costrutture dell'oggetto Docente
    public Docente(String login, String password, String nome, String cognome, String email, String corsoLaurea,String argomentiTirocinio) {
        super(login, password, nome, cognome, email, corsoLaurea);
        this.argomentiTirocinio.add(argomentiTirocinio);
    }

    public ArrayList<Tirocinio> getTirocinio() { return tirocinio; }
    public void setTirocinio(ArrayList<Tirocinio> tirocinio) { this.tirocinio = tirocinio; }
    public void addTirocinio(Tirocinio nuovoTirocinio) {
        if (nuovoTirocinio != null) {
            this.tirocinio.add(nuovoTirocinio);
        }
    }

    public ArrayList<Tesi> getTesi() { return tesi; }
    public void addTesi(Tesi nuovaTesi) {
        if (nuovaTesi != null) {
            this.tesi.add(nuovaTesi);
        }
    }

    public ArrayList<RichiestaTirocinio> getRichiestaTirocinio() { return richiestaTirocinio; }
    public void setRichiestaTirocinio(ArrayList<RichiestaTirocinio> richiestaTirocinio) { this.richiestaTirocinio = richiestaTirocinio; }
}



