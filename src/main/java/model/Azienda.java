package model;

import java.util.ArrayList;
import java.util.List;


/**
 * Rappresenta un'azienda partner registrata nel sistema che offre
 * opportunità di tirocinio agli studenti universitari.
 * Mantiene le informazioni anagrafiche e la lista dei tirocini attivi associati.
 */
public class Azienda {
    private String nomeAzienda;
    private String nominativoReferente;
    private List<Tirocinio> tirocinio = new ArrayList<>();

    /**
     * Creazione di una nuova Azienda con le informazioni minime.
     *
     * @param nomeAzienda        La denominazione dell'Azienda.
     * @param nominativoReferente Il nominativo della persona di riferimento.
     */
// Costruttore dell'Oggetto Azienda
    public Azienda(String nomeAzienda,String nominativoReferente ) {
        this.nomeAzienda = nomeAzienda;
        this.nominativoReferente = nominativoReferente;
    }

    /**
     * Restituisce il nome dell'azienda.
     *
     * @return Una stringa contenente il nome dell'azienda.
     */
// Implementazione dei vari metodi get e set di tutti gli attributi della classe
    public String getNomeAzienda() {return nomeAzienda;}

    /**
     * Imposta il nome dell'azienda.
     *
     * @param nomeAzienda Il nuovo nome da assegnare all'azienda.
     */
    public void setNomeAzienda(String nomeAzienda) {this.nomeAzienda = nomeAzienda;}

    /**
     * Restituisce il nominativo del referente dell'azienda.
     *
     * @return  Una stringa contenente il nominativo del referente.
     */
    public String getNominativoReferente() {
        return nominativoReferente;
    }

    /**
     * Imposta il nominativo del referente.
     *
     * @param nominativoReferente Il nuovo nominativo del referente aziendale.
     */
    public void setNominativoReferente(String nominativoReferente) {this.nominativoReferente = nominativoReferente;}

    /**
     * Restituisce la lista di tirocini.
     *
     * @return Un ArrayList di oggetti Tirocinio.
     */
    public List<Tirocinio> getTirocinio() {return tirocinio;}

    /**
     * Imposta la lista di tirocini.
     *
     * @param tirocinio La nuova lista di tirocini da associare all'azienda.
     */
    public void setTirocinio(List<Tirocinio> tirocinio) {this.tirocinio = tirocinio;}

    /**
     * Aggiunge un oggetto Tirocinio alla lista.
     *
     * @param nuovoTirocinio Il nuovo tirocinio da aggiungere alla lista.
     */
    public void addTirocinio(Tirocinio nuovoTirocinio) {
        if (nuovoTirocinio != null) {
            this.tirocinio.add(nuovoTirocinio);
        }
    }
}