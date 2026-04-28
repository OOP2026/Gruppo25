package model;

import java.util.ArrayList;

public class Utente {
    private String login;
    private String password;
    private String nome;
    private String cognome;
    private String email;
    private ArrayList<String> corsoLaurea = new ArrayList<>();


    // costruttore dell'oggetto utente
    public Utente(String login, String password, String nome, String cognome, String email, String corsoLaurea) {
        this.login = login;
        this.password = password;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.corsoLaurea.add(corsoLaurea);
    }

    // metodo che verifica che il login e la password inseriti corrispondano a quelli dell'utente
    public boolean login(String login, String password) {
        return ( login.equals(this.login) && password.equals(this.password));
    }
}
