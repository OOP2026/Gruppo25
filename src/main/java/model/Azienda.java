package model;

import java.util.ArrayList;
import java.util.List;


/**
 * The type Azienda.
 */
public class Azienda {
    private String nomeAzienda;
    private String nominativoReferente;
    private List<Tirocinio> tirocinio = new ArrayList<>();

    /**
     * Instantiates a new Azienda.
     *
     * @param nomeAzienda         the nome azienda
     * @param nominativoReferente the nominativo referente
     */
// Costruttore dell'Oggetto Azienda
    public Azienda(String nomeAzienda,String nominativoReferente ) {
        this.nomeAzienda = nomeAzienda;
        this.nominativoReferente = nominativoReferente;
    }

    /**
     * Gets nome azienda.
     *
     * @return the nome azienda
     */
// Implementazione dei vari metodi get e set di tutti gli attributi della classe
    public String getNomeAzienda() {return nomeAzienda;}

    /**
     * Sets nome azienda.
     *
     * @param nomeAzienda the nome azienda
     */
    public void setNomeAzienda(String nomeAzienda) {this.nomeAzienda = nomeAzienda;}

    /**
     * Gets nominativo referente.
     *
     * @return the nominativo referente
     */
    public String getNominativoReferente() {
        return nominativoReferente;
    }

    /**
     * Sets nominativo referente.
     *
     * @param nominativoReferente the nominativo referente
     */
    public void setNominativoReferente(String nominativoReferente) {this.nominativoReferente = nominativoReferente;}

    /**
     * Gets tirocinio.
     *
     * @return the tirocinio
     */
    public List<Tirocinio> getTirocinio() {return tirocinio;}

    /**
     * Sets tirocinio.
     *
     * @param tirocinio the tirocinio
     */
    public void setTirocinio(List<Tirocinio> tirocinio) {this.tirocinio = tirocinio;}

    /**
     * Add tirocinio.
     *
     * @param nuovoTirocinio the nuovo tirocinio
     */
    public void addTirocinio(Tirocinio nuovoTirocinio) {
        if (nuovoTirocinio != null) {
            this.tirocinio.add(nuovoTirocinio);
        }
    }
}