package controller;


import model.*;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    // Variabili di sessione per ricordare chi sono i docenti/studenti che sono nel sistema
    // Creiamo delle list momentanee per contenere i riferimenti agli studenti e ai docenti
    private List<Studente>  studenti;
    private List<Docente> docenti;
    private List<RichiestaTirocinio> richiesteTirocinio;
    private List<Azienda> listaAziende;
    private Docente docenteLoggato;
    private Studente studenteLoggato;
    private static final String TIPO_ESTERNO = "ESTERNO";
    private static final String TIPO_INTERNO = "INTERNO";

    public Controller() {

        this.studenti = new ArrayList<>();
        this.docenti = new ArrayList<>();
        this.richiesteTirocinio = new ArrayList<>();
        this.listaAziende = new ArrayList<>();
    }

    public void setStudente(String login, String password, String nome, String cognome, String email, String matricola) {
        Studente studente = new Studente(login, password, nome, cognome, email, matricola);
        studenti.add(studente);
    }

    public void setDocente(String login, String password, String nome, String cognome, String email) {
        Docente docente = new Docente(login, password, nome, cognome, email);
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
    public boolean controlloLogin(String login) {
        // cerca tra gli Studenti
        for (Studente s : studenti) {
            if (s.getLogin().equals(login)) {
                return true;
            }

        }
        for (Docente d : docenti) {
            if (d.getLogin().equals(login)) {
                return true;
            }

        }
        return false;
    }

    // Metodo per la verifica degli input di nome e cognome
    public boolean controlloNomeCognome(String stringa) {
        for (int i = 0; i < stringa.length(); i++) {
            if (!(Character.isLetter(stringa.charAt(i))) && (stringa.charAt(i) != ' ')) {
                return true;
            }
        }
        return false;
    }

    // Metodo per la verifica del formato della matricola
    public boolean controlloFormatoMatricola(String matricola) {
        if (matricola.length() != 9) {
            return true;
        }

        return !(matricola.matches("^(D[A-Z]\\d{7}|N\\d{8})$"));
    }

    // Metodo per la verifica dell`unicità della matricola
    public boolean controlloMatricola(String matricola) {
        for (Studente s : studenti) {
            if (s.getMatricola().equals(matricola)) {
                return true;
            }
        }
        return false;
    }

    // Metodo per la verifica del formato della mail di studente
    public boolean controlloEmailStudente(String email) {
        return !(email.matches("^[\\w\\.-]+@studenti\\.unina\\.it$"));
    }

    // Metodo per la verifica del formato della mail di docente
    public boolean controlloEmailDocente(String email) {
        return !(email.matches("^[\\w\\.-]+@docenti\\.unina\\.it$"));
    }

    // Metodo per la verifica minima della sicurezza sulla password
    public boolean controlloPassoword(String pass) {
        return pass.length() < 8;
    }

    // Metodo per aggiungere un argomento alla lista di argomenti del docente loggato.
    public void aggiungiNuovoArgomento(String argomento, String tipologiaTirocinio, String nomeAz, String refAz) {
        if (this.docenteLoggato != null) {
            Tirocinio tirocinio = new Tirocinio(tipologiaTirocinio, argomento);

            // Se è esterno, creiamo l'azienda e la incolliamo al tirocinio!
            if (tipologiaTirocinio.equalsIgnoreCase(TIPO_ESTERNO)) {
                Azienda nuovaAzienda = new Azienda(nomeAz, refAz);
                this.listaAziende.add(nuovaAzienda);
                tirocinio.setAzienda(nuovaAzienda);
            }

            this.docenteLoggato.addTirocinioProposto(tirocinio);
            this.docenteLoggato.addArgomentoTirocinio(argomento);
        }
    }

    // Restituisce la colonna dei nomi dei docenti
    public List<String> getNomiDocentiPerTabella() {
        ArrayList<String> nomi = new ArrayList<>();
        for (Docente d : docenti) {
            for (Tirocinio t : d.getTirociniProposti()) { // Scorri la lista degli oggetti!
                nomi.add("Prof. " + d.getCognome() + " " + d.getNome());
            }
        }
        return nomi;
    }

    // Restituisce la colonna degli argomenti (sincronizzata con i nomi)
    public List<String> getArgomentiPerTabella() {
        ArrayList<String> argomenti = new ArrayList<>();
        for (Docente d : docenti) {
            for (Tirocinio t : d.getTirociniProposti()) {
                argomenti.add(t.getArgomento()); // Estrai l'argomento dall'oggetto
            }
        }
        return argomenti;
    }

    // Metodo che restituisce la colonna della tipologia del tirocinio
    public List<String> getTipologiePerTabella() {
        ArrayList<String> tipologie = new ArrayList<>();
        for (Docente d : docenti) {
            for (Tirocinio t : d.getTirociniProposti()) {
                tipologie.add(t.getTipologiaTirocinio());
            }
        }
        return tipologie;
    }

    // Metodo che restituisce la colonna dei referenti delle aziende
    public List<String> getReferentePerTabella() {
        ArrayList<String> referenti = new ArrayList<>();
        for (Docente d : docenti) {
            for (Tirocinio t : d.getTirociniProposti()) {
                if (t.getTipologiaTirocinio().equalsIgnoreCase(TIPO_ESTERNO) && t.getAzienda() != null) {
                    referenti.add(t.getAzienda().getNominativoReferente());
                } else {
                    referenti.add("N.D."); // Questo scatta per gli interni, salvando l'allineamento!
                }
            }
        }
        return referenti;
    }

    // Metodo che restituisce la colonna dei nomi delle aziende
    public List<String> getNomiAziendaPerTabella() {
        ArrayList<String> nomiAzienda = new ArrayList<>();
        for (Docente d : docenti) {
            for (Tirocinio t : d.getTirociniProposti()) {
                if (t.getTipologiaTirocinio().equalsIgnoreCase(TIPO_ESTERNO) && t.getAzienda() != null) {
                    nomiAzienda.add(t.getAzienda().getNomeAzienda());
                } else {
                    nomiAzienda.add("N.D."); // Questo scatta per gli interni, salvando l'allineamento!
                }
            }
        }
        return nomiAzienda;
    }

    // Metodo che controlla l'inserimento del docente e del relativo argomento nella richiesta di tirocinio
    public boolean controllaRichiestaTirocinio(String nomeProf, String cognomeProf, String nomeArgomento) {
        List<String> argomenti = new ArrayList<>();
        List<String> nomiProf = new ArrayList<>();
        List<String> cognomiProf = new ArrayList<>();
        // Questo for inserisce i nomi di tutti i docenti
        for (Docente d : docenti) {
            nomiProf.add(d.getNome());
            cognomiProf.add(d.getCognome());
        }
        // Controlliamo se il nome o il cognome non sono validi o non esistono
        if (nomeProf.isEmpty() || cognomeProf.isEmpty() || !nomiProf.contains(nomeProf) || !cognomiProf.contains(cognomeProf)) {
            return true;
        }
        // Inseriamo tutti gli argomenti relativi al professore selezionato
        for (Docente d : docenti) {
            if (d.getNome().equalsIgnoreCase(nomeProf) && d.getCognome().equalsIgnoreCase(cognomeProf)) {
                for (String arg : d.getArgomentiTirocinio()) {
                    argomenti.add(arg);
                }
            }
        }
        // Controlliamo che l'argomento sia stato inserito dal prof
        return !(argomenti.contains(nomeArgomento));
    }

    // Metodo per cercare il docente e inserire la nuova richiesta di tirocinio
    public void aggiungiRichiestaTirocinio(String nomeProf, String cognomeProf, String argomento) {
        Docente docenteTrovato = null;

        // Scorriamo la lista dei docenti per trovare l'oggetto che corrisponde al testo inserito
        for (Docente d : docenti) {
            if (d.getNome().equalsIgnoreCase(nomeProf) && d.getCognome().equalsIgnoreCase(cognomeProf)) {
                docenteTrovato = d;
                break; // Lo abbiamo trovato, possiamo fermare il ciclo for
            }
        }
        // Se abbiamo trovato il docente e lo studente è regolarmente loggato
        if (docenteTrovato != null && this.studenteLoggato != null) {
            // Chiamiamo il costruttore di RichiestaTirocinio passandogli lo Stato iniziale
            RichiestaTirocinio nuovaRichiesta = new RichiestaTirocinio(this.studenteLoggato, docenteTrovato, argomento);
            // Aggiungiamo la richiesta alla lista del controller
            richiesteTirocinio.add(nuovaRichiesta);

        }
    }

    // Metodo per aggiungere l'argomento del tirocinio allo studente
    public void setArgomentoStudente(String argomentoStudente) {
        this.studenteLoggato.setArgomentoTirocinio(argomentoStudente);
    }

    // Metodi per riempire la tabella delle richieste del tirocinio per il docente
    // Restituisce la colonna dei nomi e cognomi
    public List<String> getNomiStudentiPerTabella() {
        ArrayList<String> nomi = new ArrayList<>();

        for (RichiestaTirocinio r : richiesteTirocinio) {
            if (r.getDocente().equals(docenteLoggato) && r.getStatoRichiesta() == Stato.ATTESA) {
                String nomeS = r.getStudente().getNome() + " " + r.getStudente().getCognome();
                nomi.add(nomeS);
            }
        }
        return nomi;
    }

    // Restituisce la colonna delle matricole
    public List<String> getMatricolaStudentiPerTabella() {
        ArrayList<String> matricole = new ArrayList<>();
        for (RichiestaTirocinio r : richiesteTirocinio) {
            if (r.getDocente().equals(docenteLoggato) && r.getStatoRichiesta() == Stato.ATTESA) {
                String matricolaS = r.getStudente().getMatricola();
                matricole.add(matricolaS);
            }
        }
        return matricole;
    }


    // Restituisce la colonna degli argomenti (sincronizzata con i nomi)
    public List<String> getArgomentiStudentiPerTabella() {
        ArrayList<String> argomenti = new ArrayList<>();

        for (RichiestaTirocinio r : richiesteTirocinio) {
            if (r.getDocente().equals(docenteLoggato) && r.getStatoRichiesta() == Stato.ATTESA) {
                String argomentoS = r.getArgomento();
                argomenti.add(argomentoS);
            }
        }
        return argomenti;
    }

    // Metodo per modificare lo stato della richiesta del tirocinio
    public void modificaStatoRichiesta(int rigaSelezionata, Stato nuovoStato) {
        // 1. Creiamo una lista temporanea con SOLO le richieste del docente loggato
        List<RichiestaTirocinio> richiesteDelDocente = new ArrayList<>();
        for (RichiestaTirocinio r : richiesteTirocinio) {
            if (r.getDocente().equals(this.docenteLoggato) && r.getStatoRichiesta() == Stato.ATTESA) {
                richiesteDelDocente.add(r);
            }
        }

        // 2. Ora la riga selezionata in tabella combacia perfettamente con questa lista corta!
        if (rigaSelezionata >= 0 && rigaSelezionata < richiesteDelDocente.size()) {
            RichiestaTirocinio richiestaEsatta = richiesteDelDocente.get(rigaSelezionata);
            richiestaEsatta.setStatoRichiesta(nuovoStato);
        }
    }

    public List<RichiestaTirocinio> getRichiestaTirocinio() {
        return this.richiesteTirocinio;
    }

    public Studente getStudenteLoggato() {
        return this.studenteLoggato;
    }

    // Metodi per riempire la tabella dei tirocinanti(ovvero studenti la quale richiesta ha stato approvato)
    public List<String> getNomiTirocinantiApprovati() {
        ArrayList<String> nomi = new ArrayList<>();
        for (RichiestaTirocinio r : richiesteTirocinio) {
            Studente s = r.getStudente();
            // Filtriamo per docenteLoggato e per stato della richiesta
            if (r.getDocente().equals(docenteLoggato) &&
                    r.getStatoRichiesta() == Stato.APPROVATA &&
                    s.getTirocinio() != null &&
                    !s.getTirocinio().getCompletato()) {
                nomi.add(r.getStudente().getNome() + " " + r.getStudente().getCognome());
            }
        }
        return nomi;
    }

    public List<String> getMatricoleTirocinantiApprovati() {
        ArrayList<String> matricole = new ArrayList<>();
        for (RichiestaTirocinio r : richiesteTirocinio) {
            Studente s = r.getStudente();
            if (r.getDocente().equals(docenteLoggato) &&
                    r.getStatoRichiesta() == Stato.APPROVATA &&
                    s.getTirocinio() != null &&
                    !s.getTirocinio().getCompletato()) {
                matricole.add(r.getStudente().getMatricola());
            }
        }
        return matricole;
    }

    public List<String> getArgomentiTirocinantiApprovati() {
        ArrayList<String> argomenti = new ArrayList<>();
        for (RichiestaTirocinio r : richiesteTirocinio) {
            Studente s = r.getStudente();
            if (r.getDocente().equals(docenteLoggato) &&
                    r.getStatoRichiesta() == Stato.APPROVATA &&
                    s.getTirocinio() != null &&
                    !s.getTirocinio().getCompletato()) {
                argomenti.add(r.getArgomento());
            }
        }
        return argomenti;
    }

    // Metodo per controllare lo stato della Richiesta del tirocinio.
    public boolean controlloRichiesta() {
        if (docenti.isEmpty()) {
            return false;
        }
        for (Docente d : docenti) {
            if (d.getArgomentiTirocinio().isEmpty()) {
                return false;
            }
        }
        for (RichiestaTirocinio r : richiesteTirocinio) {
            if (r.getStudente().equals(studenteLoggato) &&
                    (r.getStatoRichiesta() == Stato.ATTESA || r.getStatoRichiesta() == Stato.APPROVATA)) {
                return false;
            }
        }
        return true;
    }

    // Metodo per controllare se la tipologia del tirocinio inserita sia giusta.
    public boolean controlloInserimentoTirocinio(String tipologiaTirocinio) {
        return tipologiaTirocinio.equalsIgnoreCase(TIPO_INTERNO) || tipologiaTirocinio.equalsIgnoreCase(TIPO_ESTERNO);
    }

    // Metodo per istanziare una nuova tesi
    public void aggiungiNuovaTesi(String titolo, String contenuto, String data) {
        for (RichiestaTirocinio r : richiesteTirocinio) {
            if (r.getStudente().equals(studenteLoggato) && r.getStatoRichiesta().equals(Stato.APPROVATA)) {
                Docente docente = r.getDocente();
                Tesi nuovatesi = new Tesi(studenteLoggato, docente, titolo, contenuto, data);
                docente.addTesi(nuovatesi);
                studenteLoggato.setTesi(nuovatesi);
                return;
            }
        }

    }

    // Metodi per riempire la tabella dei tesisti
    public List<String> getStudentiTesi() {
        ArrayList<String> nomi = new ArrayList<>();
        for (Studente s : studenti) {
            if (s.getTesi() != null && s.getTesi().getStatoTesi().equals(Stato.ATTESA)) {
                nomi.add(s.getNome() + " " + s.getCognome());
            }
        }
        return nomi;
    }

    public List<String> getMatricoleTesi() {
        ArrayList<String> matricole = new ArrayList<>();
        for (Studente s : studenti) {
            if (s.getTesi() != null && s.getTesi().getStatoTesi().equals(Stato.ATTESA)) {
                matricole.add(s.getMatricola());
            }
        }
        return matricole;
    }

    public List<String> getTitoliTesi() {
        ArrayList<String> titoli = new ArrayList<>();
        for (Studente s : studenti) {
            if (s.getTesi() != null && s.getTesi().getStatoTesi().equals(Stato.ATTESA)) {
                titoli.add(s.getTesi().getTitolo());
            }
        }
        return titoli;
    }

    public List<String> getContenutoTesi() {
        ArrayList<String> contenuti = new ArrayList<>();
        for (Studente s : studenti) {
            if (s.getTesi() != null && s.getTesi().getStatoTesi().equals(Stato.ATTESA)) {
                contenuti.add(s.getTesi().getContenuto());
            }
        }
        return contenuti;
    }

    // Metodo per leggere il contenuto dalla tabella data la riga
    public String getContenutoTesiSingola(String matricola) {
        String contenutoTesiRichiesta = "";
        for (Studente s : studenti) {
            if (s.getMatricola().equals(matricola)) {
                contenutoTesiRichiesta = s.getTesi().getContenuto();
            }
        }
        return contenutoTesiRichiesta;
    }

    // Metodo per impedire agli studenti che non hanno terminato il tirocinio di poter caricare la tesi
    public boolean controlloTesiButton() {
        return !(studenteLoggato.getTirocinio() == null ||
                !studenteLoggato.getTirocinio().getCompletato() ||
                (studenteLoggato.getTesi() != null &&
                        (studenteLoggato.getTesi().getStatoTesi() == Stato.APPROVATA ||
                                studenteLoggato.getTesi().getStatoTesi() == Stato.ATTESA)));
    }

    // Metodo per modificare lo stato della tesi
    public void modificaStatoTesi(int rigaSelezionata, Stato nuovoStato, String matricola) {
        List<Tesi> tesi = new ArrayList<>();
        for (Tesi t : docenteLoggato.getTesi()) {
            if (t.getStudente().getMatricola().equals(matricola) && t.getStatoTesi().equals(Stato.ATTESA)) {
                tesi.add(t);
            }
        }
        if (rigaSelezionata >= 0 && rigaSelezionata < tesi.size()) {
            Tesi tesiEsatta = tesi.get(rigaSelezionata);
            tesiEsatta.setStatoTesi(nuovoStato);
            docenteLoggato.rimuoviTesi(rigaSelezionata);
        }
    }

    // Metodi per la tabella dello stato della tesi
    // Metodo per visualizzare lo stato della tesi
    public String getStatoTesiTabella() {
        return  studenteLoggato.getTesi().getStatoTesi().toString();
    }

    public String getDocenteTesiTabella() {
        String nomeDocenteTesi = studenteLoggato.getTesi().getDocente().getNome();
        String cognomeDocenteTesi = studenteLoggato.getTesi().getDocente().getCognome();
        return (nomeDocenteTesi + " " + cognomeDocenteTesi);
    }

    public String getTitotoTabella() {
        return studenteLoggato.getTesi().getTitolo();
    }

    // Metodo per istanziare il tirocinio quando il docente approva la richiesta
    public void setTirocinio(String matricola) {
        for (RichiestaTirocinio r : richiesteTirocinio) {
            if (r.getStudente().getMatricola().equals(matricola)) {
                Studente studenteCorrente = r.getStudente();
                Tirocinio nuovoTirocinio = new Tirocinio(studenteCorrente, docenteLoggato);
                studenteCorrente.setTirocinio(nuovoTirocinio);
                docenteLoggato.addTirocinio(nuovoTirocinio);
            }
        }
    }

    // Metodo per terminare il tirocinio
    public void setTerminaTirocinio(int rigaSelezionata) {
        List<Tirocinio> tirocinio = this.docenteLoggato.getTirocinio();
        if (rigaSelezionata >= 0 && rigaSelezionata < tirocinio.size()) {
            Tirocinio tirocinioEsatto = tirocinio.get(rigaSelezionata);
            tirocinioEsatto.setCompletato(true);
        }
    }

    // Metodo per verificare che uno studente possa visualizzare lo stato della tesi
    public boolean haTesi() {
        return this.studenteLoggato.getTesi() != null;
    }
}
