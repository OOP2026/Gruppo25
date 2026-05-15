package controller;

import model.Utente;
import model.Studente;
import model.Docente;
import java.util.ArrayList;
import java.util.List;

public class Controller {

	private Studente studente;
	private Docente docente;

	public Controller() {

		}

	public void setStudente(String login, String password, String nome, String cognome, String email, String corsoLaurea,String matricola){
		studente = new Studente (login, password, nome, cognome, email, corsoLaurea, matricola);
	}

	public void setDocente(String login, String password, String nome, String cognome, String email, String corsoLaurea) {
		docente = new Docente (login, password, nome, cognome, email, corsoLaurea);
	}
	
}
