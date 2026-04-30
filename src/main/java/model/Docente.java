package model;

import java.util.ArrayList;
import java.util.List;

public class Docente extends Utente {

    private List<String> argomentiTirocinio = new ArrayList<>();
    private List<Tirocinio> tirocinio = new ArrayList<>();
    private List<Tesi> tesi = new ArrayList<>();
    private List<RichiestaTirocinio> richiestaTirocinio = new ArrayList<>();

    //Costrutture dell'Oggetto Docente
    public Docente(String login, String password, String nome, String cognome, String email, String corsoLaurea,String argomentiTirocinio) {
        super(login, password, nome, cognome, email, corsoLaurea);
        this.argomentiTirocinio.add(argomentiTirocinio);
    }

    // Implementazione dei vari metodi get e set di tutti gli attributi della classe

    public List<String> getArgomentiTirocinio() {return argomentiTirocinio;}

    public void setArgomentiTirocinio(List<String> argomentiTirocinio) {this.argomentiTirocinio = argomentiTirocinio;}

    public List<Tirocinio> getTirocinio() {return tirocinio;}

    public void setTirocinio(List<Tirocinio> tirocinio) {this.tirocinio = tirocinio;}

    public void addTirocinio(Tirocinio nuovoTirocinio) {
        if (nuovoTirocinio != null) {
            this.tirocinio.add(nuovoTirocinio);
        }
    }

    public List<Tesi> getTesi() {return tesi;}

    public void setTesi(List<Tesi> tesi) {this.tesi = tesi;}

    public void addTesi(Tesi nuovaTesi) {
        if (nuovaTesi != null) {
            this.tesi.add(nuovaTesi);
        }
    }

    public List<RichiestaTirocinio> getRichiestaTirocinio() {return richiestaTirocinio;}

    public void setRichiestaTirocinio(List<RichiestaTirocinio> richiestaTirocinio) {this.richiestaTirocinio = richiestaTirocinio;}

}



