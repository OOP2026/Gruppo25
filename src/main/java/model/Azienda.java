package model;

import java.util.ArrayList;
import java.util.List;


public class Azienda {
    private String nomeAzienda;
    private String partitaIva;
    private String nominativoReferente;
    private List<Tirocinio> tirocinio = new ArrayList<>();

    // Costruttore dell'Oggetto Azienda
    public Azienda(String nomeAzienda,String nominativoReferente, String partitaIva) {
        this.nomeAzienda = nomeAzienda;
        this.nominativoReferente = nominativoReferente;
        this.partitaIva = partitaIva;
    }

    // Implementazione dei vari metodi get e set di tutti gli attributi della classe
    public String getNomeAzienda() {return nomeAzienda;}

    public void setNomeAzienda(String nomeAzienda) {this.nomeAzienda = nomeAzienda;}

    public String getNominativoReferente() {
        return nominativoReferente;
    }

    public void setNominativoReferente(String nominativoReferente) {this.nominativoReferente = nominativoReferente;}

    public String getPartitaIva() {return partitaIva;}

    public void setPartitaIva(String partitaIva) {this.partitaIva = partitaIva;}

    public List<Tirocinio> getTirocinio() {return tirocinio;}

    public void setTirocinio(List<Tirocinio> tirocinio) {this.tirocinio = tirocinio;}

    public void addTirocinio(Tirocinio nuovoTirocinio) {
        if (nuovoTirocinio != null) {
            this.tirocinio.add(nuovoTirocinio);
        }
    }
}

