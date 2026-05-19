package controller;

import model.Studente;
import model.Docente;
import java.util.ArrayList;
import java.util.List;

public class Controller {

	private Studente studente;
	private Docente docente;
	private final static List<Studente> fintoDatabaseStudenti = new ArrayList<>();
	private final static List<Docente> fintoDatabaseDocenti = new ArrayList<>();

	public Controller() {
		}

	public void setStudente(String login, String password, String nome, String cognome, String email, String corsoLaurea,String matricola){
		studente = new Studente (login, password, nome, cognome, email, corsoLaurea, matricola);
		fintoDatabaseStudenti.add(studente);
	}

	public void setDocente(String login, String password, String nome, String cognome, String email, String corsoLaurea) {
		docente = new Docente (login, password, nome, cognome, email, corsoLaurea);
		fintoDatabaseDocenti.add(docente);
	}

	// Metodo per verificare se la login e la password inseriti corrispondono ad uno Studente, ad un Docente o non esiste
	public String effettuaLogin(String login, String password) {
		// 1. Cerca tra gli studenti
		for (Studente s : fintoDatabaseStudenti) {
			if (s.getLogin().equals(login) && s.getPassword().equals(password)) {
				return "STUDENTE"; // Trovato uno studente!
			}
		}
		// 2. Cerca tra i docenti
		for (Docente d : fintoDatabaseDocenti) {
			if (d.getLogin().equals(login) && d.getPassword().equals(password)) {
				// Cerca tra i docenti
				return "DOCENTE";
			}
		}
		// 3. Se non trova nessuno
		return "NON_TROVATO";
	}

	// Metodo per verificare che la login inserita non esista giá
	public boolean controlloLogin(String login){
		// cerca tra gli Studenti
		for (Studente s : fintoDatabaseStudenti) {
			if (s.getLogin().equals(login)) {return true;};
		}
		for(Docente d : fintoDatabaseDocenti) {
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
		for(Studente s : fintoDatabaseStudenti) {
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



}
