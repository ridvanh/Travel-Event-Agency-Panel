package main;

public class Administrator extends Person{

    public String passwort;

    public String getPasswort() {
        return passwort;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }

    public void addKonto(){}

    public void editKonto(){}

    public void deleteKonto(){}

    //nach diesem Schritt wurden folgende Methoden erstellt, um die permanent gespeicherte Daten einzusehen.

    public void getGVStatus(){}

    public void getMitarbeiter(){}

    public void getAdministratoren(){}

    public void getKunden(){}

    public void getReservierungen(){}

    public void getRechnungen(){}

    public void getFirmen(){}

    public void getVeranstaltungen(){}

}
