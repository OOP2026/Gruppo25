package model;

import java.util.ArrayList;

public class Azienda {
    protected String nomeAzienda;
    protected String partitaIva;
    protected String nominativoReferente;
    private ArrayList<Tirocinio> tirocinio = new ArrayList<>();

    // costruttore dell'oggetto Azienda
    public Azienda(String nomeAzienda,String nominativoReferente, String partitaIva) {
        this.nomeAzienda = nomeAzienda;
        this.nominativoReferente = nominativoReferente;
        this.partitaIva = partitaIva;

    }

    public String getNominativoReferente() {
        return nominativoReferente;
    }

    public void addTirocinio(Tirocinio nuovoTirocinio) {
        if (nuovoTirocinio != null) {
            this.tirocinio.add(nuovoTirocinio);
        }
    }
}

