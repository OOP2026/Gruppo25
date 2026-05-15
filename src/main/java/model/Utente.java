package model;

import java.util.ArrayList;
import java.util.List;

public class Utente {
    private String login;
    private String password;
    private String nome;
    private String cognome;
    private String email;
    private List<String> corsoLaurea = new ArrayList<>();


    // Costruttore dell'Oggetto Utente
    public Utente(String login, String password, String nome, String cognome, String email, String corsoLaurea) {
        this.login = login;
        this.password = password;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.corsoLaurea.add(corsoLaurea);
    }

    // Implementazione dei vari metodi get e set di tutti gli attributi della classe
    public String getLogin() {return login;}

    public void setLogin(String login) {this.login = login;}

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}

    public String getNome() {return nome;}

    public void setNome(String nome) {this.nome = nome;}

    public String getCognome() {return cognome;}

    public void setCognome(String cognome) {this.cognome = cognome;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    public List<String> getCorsoLaurea() {return corsoLaurea;}

    public void setCorsoLaurea(List<String> corsoLaurea) {this.corsoLaurea = corsoLaurea;}

    // Metodo che verifica che il login e la password inseriti corrispondano a quelli dell'utente
    public boolean login(String login, String password) {
        return ( login.equals(this.login) && password.equals(this.password));
    }

}
