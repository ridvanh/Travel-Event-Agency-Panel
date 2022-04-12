package main;

public class Firma {
    public int firmaID;
    public String firmaName;
    public String telNr;
    public String steuerNr;
    public String adresse;
    public Veranstaltung[] veranstaltungen;
    public Reservierung[] reservierungen;
    public Rechnung[] rechnungen;

    public int getFirmaID() {
        return firmaID;
    }

    public void setFirmaID(int firmaID) {
        this.firmaID = firmaID;
    }

    public String getFirmaName() {
        return firmaName;
    }

    public void setFirmaName(String firmaName) {
        this.firmaName = firmaName;
    }

    public String getTelNr() {
        return telNr;
    }

    public void setTelNr(String telNr) {
        this.telNr = telNr;
    }

    public String getSteuerNr() {
        return steuerNr;
    }

    public void setSteuerNr(String steuerNr) {
        this.steuerNr = steuerNr;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void getVeranstaltung(){}

    public void neueVeranstaltung(){}

    public void setVeranstaltung(){}

    public void getAlleVeranstaltungen(){}

    public void getRechnung(){}

    public void neueRechnung(){}

    public void setRechnung(){}

    public void getAlleRechnungen(){}

    public void getReservierung(){}

    public void neueReservierung(){}

    public void setReservierung(){}

    public void getAlleReservierungen(){}
}
