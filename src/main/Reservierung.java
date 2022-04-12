package main;

public class Reservierung {
    public int resNr;
    public String datum;
    public int personenAnzahl;
    public String preis;

    public int getResNr() {
        return resNr;
    }

    public void setResNr(int resNr) {
        this.resNr = resNr;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public int getPersonenAnzahl() {
        return personenAnzahl;
    }

    public void setPersonenAnzahl(int personenAnzahl) {
        this.personenAnzahl = personenAnzahl;
    }

    public String getPreis() {
        return preis;
    }

    public void setPreis(String preis) {
        this.preis = preis;
    }
}
