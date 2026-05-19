package controller;

import model.SistemaUniversitario;
import model.Studente;
import model.Docente;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Controller {

	private SistemaUniversitario sistema;
	// Variabili di sessione per ricordare chi sono i docenti/studenti che sono nel sistema
	private Docente docenteLoggato;
	private Studente studenteLoggato;


	public Controller() {
		this.sistema = new SistemaUniversitario();
		}

	public void setStudente(String login, String password, String nome, String cognome, String email, String corsoLaurea,String matricola){
		Studente studente = new Studente (login, password, nome, cognome, email, corsoLaurea, matricola);
		sistema.aggiungiStudente(studente);
	}

	public void setDocente(String login, String password, String nome, String cognome, String email, String corsoLaurea) {
		Docente docente = new Docente (login, password, nome, cognome, email, corsoLaurea);
		sistema.aggiungiDocente(docente);
	}

	// Metodo per verificare se la login e la password inseriti corrispondono ad uno Studente, ad un Docente o non esiste
	public String effettuaLogin(String login, String password) {
		// 1. Cerca tra gli studenti
		for (Studente s : sistema.getStudenti()) {
			if (s.getLogin().equals(login) && s.getPassword().equals(password)) {
				this.studenteLoggato = s;
				return "STUDENTE";

			}
		}
		// 2. Cerca tra i docenti
		for (Docente d : sistema.getDocenti()) {
			if (d.getLogin().equals(login) && d.getPassword().equals(password)) {
				this.docenteLoggato = d;
				return "DOCENTE";
			}
		}
		// 3. Se non trova nessuno
		return "NON_TROVATO";
	}

	// Metodo per verificare che la login inserita non esista giá
	public boolean controlloLogin(String login){
		// cerca tra gli Studenti
		for (Studente s : sistema.getStudenti()) {
			if (s.getLogin().equals(login)) {return true;};
		}
		for(Docente d : sistema.getDocenti()) {
			if (d.getLogin().equals(login)) {return true;};
		}
		return false;
	}

	// Metodo per la verifica degli input di nome e cognome
	public boolean controlloNomeCognome(String stringa){
		 for (int i = 0; i < stringa.length(); i++) {
			 if (Character.isDigit(stringa.charAt(i))) {return true;}
		 }
		 return false;
	}

	// Metodo per la verifica del formato della matricola
	public boolean controlloFormatoMatricola(String matricola) {
		 if (matricola.length() != 9) {return true;}
		 if((Character.compare(matricola.charAt(0),'D')!= 0) || (Character.compare(matricola.charAt(1),'E')!=0)){return true;}
		 for (int i = 2; i < matricola.length(); i++) {
			 //Character.toUpperCase(matricola.charAt(0));
			 //Character.toUpperCase(matricola.charAt(1))
			 if(Character.isAlphabetic(matricola.charAt(i))){return true;}
		 }

		 return false;
	}
	// Metodo per la verifica dell`unicità della matricola
	public boolean controlloMatricola(String matricola) {
		for(Studente s : sistema.getStudenti()) {
			if(s.getMatricola().equals(matricola)){return true;}
		}
		return false;
	}

	// Metodo per la verifica del formato della mail di studente
	public boolean controlloEmailStudente(String email){
		if(!(email.matches("^[\\w\\.-]+@studenti\\.unina\\.it$"))) {return true;}
		return false;
	}

	// Metodo per la verifica del formato della mail di docente
	public boolean controlloEmailDocente(String email){
		if(!(email.matches("^[\\w\\.-]+@docenti\\.unina\\.it$"))) {return true;}
		return false;
	}

	// Metodo per la verifica minima della sicurezza sulla password
	public boolean controlloPassoword(String pass){
		if(pass.length()<8){return true;}
		return false;
	}

	// Metodo per aggiungere un argomento alla lista di argomenti del docente loggato.
	public void aggiungiNuovoArgomento(String argomento) {
		if (this.docenteLoggato != null) {
			this.docenteLoggato.addArgomentoTirocinio(argomento);
		}
	}

	// Restituisce la colonna dei nomi dei docenti
	public ArrayList<String> getNomiDocentiPerTabella() {
		ArrayList<String> nomi = new ArrayList<>();

		for (Docente d : sistema.getDocenti()) {
			// Per ogni argomento che il docente ha, aggiungiamo il suo nome nella lista
			for (String arg : d.getArgomentiTirocinio()) { // Assumendo che il metodo si chiami getArgomenti() nel Docente
				nomi.add("Prof. " + d.getCognome() + " " + d.getNome());
			}
		}
		return nomi;
	}

	// Restituisce la colonna degli argomenti (sincronizzata con i nomi)
	public ArrayList<String> getArgomentiPerTabella() {
		ArrayList<String> argomenti = new ArrayList<>();

		for (Docente d : sistema.getDocenti()) {
			// Aggiungiamo tutti gli argomenti di questo docente
			for (String arg : d.getArgomentiTirocinio()) {
				argomenti.add(arg);
			}
		}
		return argomenti;
	}

}
