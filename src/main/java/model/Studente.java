package model;

import java.util.ArrayList;
import java.util.List;

public class Studente extends Utente{
    private String matricola;
    private SedutaDiLaurea sedutaDiLaurea;
    private Tirocinio tirocinio;
    private Tesi tesi;
    private List<RichiestaTirocinio> richiestaTirocinio = new ArrayList<>();

    //costrutture dell'oggetto Studente
    public Studente(String login, String password, String nome, String cognome, String email, String corsoLaurea,String matricola) {
        super(login, password, nome, cognome, email, corsoLaurea);
        this.matricola = matricola;
        this.richiestaTirocinio = new ArrayList<>();
    }

    public String getMatricola() {
        return matricola;
    }

    public SedutaDiLaurea getSedutaDiLaurea() {
        return sedutaDiLaurea;
    }

    public void setSedutaDiLaurea(SedutaDiLaurea sedutaDiLaurea) {
        this.sedutaDiLaurea = sedutaDiLaurea;
    }

    public Tirocinio getTirocinio() {
        return tirocinio;
    }

    public void setTirocinio(Tirocinio tirocinio) {
        this.tirocinio = tirocinio;
    }

    public Tesi getTesi() {
        return tesi;
    }

    public void setTesi(Tesi tesi) {
        this.tesi = tesi;
    }

    public List<RichiestaTirocinio> getRichiestaTirocinio() {
        return richiestaTirocinio;
    }

    public void setRichiestaTirocinio(List<RichiestaTirocinio> richiestaTirocinio) {
        this.richiestaTirocinio = richiestaTirocinio;
    }

}
