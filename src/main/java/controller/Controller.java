package controller;


import model.Studente;
import model.Docente;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Controller {

	// Variabili di sessione per ricordare chi sono i docenti/studenti che sono nel sistema
	// Creiamo delle list momentanee per contenere i riferimenti agli studenti e ai docenti
	private List<Studente> studenti;
	private List<Docente> docenti;

	private Docente docenteLoggato;
	private Studente studenteLoggato;


	public Controller() {
		//this.sistema = new SistemaUniversitario();
		this.studenti = new ArrayList<>();
		this.docenti = new ArrayList<>();
		}

	public void setStudente(String login, String password, String nome, String cognome, String email, String corsoLaurea,String matricola){
		Studente studente = new Studente (login, password, nome, cognome, email, corsoLaurea, matricola);
		studenti.add(studente);
	}

	public void setDocente(String login, String password, String nome, String cognome, String email, String corsoLaurea) {
		Docente docente = new Docente (login, password, nome, cognome, email, corsoLaurea);
		docenti.add(docente);
	}

	// Metodo per verificare se la login e la password inseriti corrispondono ad uno Studente, ad un Docente o non esiste
	public String effettuaLogin(String login, String password) {
		// 1. Cerca tra gli studenti
		for (Studente s : studenti) {
			if (s.getLogin().equals(login) && s.getPassword().equals(password)) {
				this.studenteLoggato = s;
				return "STUDENTE";

			}
		}
		// 2. Cerca tra i docenti
		for (Docente d : docenti) {
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
		for (Studente s : studenti) {
			if (s.getLogin().equals(login)) {return true;};
		}
		for(Docente d : docenti) {
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

        return !(matricola.matches("^D[A-Z]\\d{7}|N\\d{8}$"));
    }
	// Metodo per la verifica dell`unicità della matricola
	public boolean controlloMatricola(String matricola) {
		for(Studente s : studenti) {
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

		for (Docente d : docenti) {
			// Per ogni argomento che il docente ha, aggiungiamo il suo nome nella lista
			for (String arg : d.getArgomentiTirocinio()) {
				nomi.add("Prof. " + d.getCognome() + " " + d.getNome());
			}
		}
		return nomi;
	}

	// Restituisce la colonna degli argomenti (sincronizzata con i nomi)
	public ArrayList<String> getArgomentiPerTabella() {
		ArrayList<String> argomenti = new ArrayList<>();

		for (Docente d : docenti) {
			// Aggiungiamo tutti gli argomenti di questo docente
			for (String arg : d.getArgomentiTirocinio()) {
				argomenti.add(arg);
			}
		}
		return argomenti;
	}

	// Metodo per restituire la lista di nomi di tutti i prof che servono nella Tendina di MandaRichiestTirocinio.
	public ArrayList<String> getNomiUnaVolta() {
		ArrayList<String> nomiDocentiSingoli = new ArrayList<>();
		for (Docente d : docenti){
			String nomeDocente = (d.getNome() + " " + d.getCognome());
			nomiDocentiSingoli.add(nomeDocente);
		}
		return nomiDocentiSingoli;
	}

	// Metodo che controlla l'inserimento del docente e del relativo argomento nella richiesta di tirocinio
	public boolean controllaRichiestaTirocinio(String nomeProf, String nomeArgomento){
		ArrayList<String> argomenti = new ArrayList<>();
		List<String> nomiProf = new ArrayList<>();
		// Questo for inserisce i nomi di tutti i docenti
		for (Docente d : docenti) {
			nomiProf.add(d.getNome() + " " + d.getCognome());
		}
		// Controlliamo se il nome esiste
		if((nomeProf.isEmpty()) || !(nomiProf.contains(nomeProf))){return true;}
		// Inseriamo tutti gli argomenti relativi al professore selezionato
		for(Docente d : docenti){
			if(d.getNome().equals(nomeProf)){
				for (String arg : d.getArgomentiTirocinio()) {
				argomenti.add(arg);}
			}
		}
		// Controlliamo che l'argomento sia stato inserito dal prof
        return !(argomenti.contains(nomeArgomento));
    }
}
