package model;

import java.util.ArrayList;
import java.util.List;


public class Azienda {
    protected String nomeAzienda;
    protected String partitaIva;
    protected String nominativoReferente;
    private List<Tirocinio> tirocinio = new ArrayList<>();

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

