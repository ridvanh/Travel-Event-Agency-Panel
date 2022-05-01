package main;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class addDataScene extends Application{

    Verbindung DBVerbindung = new Verbindung();
    BackgroundImage bground = new BackgroundImage(new Image("C:/Users/PC/Desktop/graybg.jpg",1970,
            605, false, true), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

    @Override
    public void start(Stage stage) throws Exception {}

    public static void main(String[] args) {
        launch(args);
    }

    public void addAdmin(Stage stage){
        Label vName = new Label("Vorname");
        Label nName = new Label("Nachname");
        Label passwort = new Label("Passwort");
        Label geschlecht = new Label("Geschlecht");
        Label geburtsdatum = new Label("Geburtsdatum");
        Label email = new Label("E-mail");
        Label adresse = new Label("Adresse");
        Button submit = new Button("Hinzufügen");

        TextField tf1 = new TextField();
        TextField tf2 = new TextField();
        TextField tf3 = new TextField();
        TextField tf4 = new TextField();
        TextField tf5 = new TextField();
        TextField tf6 = new TextField();
        TextField tf7 = new TextField();

        GridPane gp = new GridPane();
        gp.setBackground(new Background(bground));
        gp.setAlignment(Pos.CENTER);
        gp.setHgap(10);
        gp.setVgap(10);
        gp.setPadding(new Insets(25,25,25,25));

        gp.addRow(0, vName, tf1);
        gp.addRow(1, nName, tf2);
        gp.addRow(2, passwort, tf3);
        gp.addRow(3, geschlecht, tf4);
        gp.addRow(4, geburtsdatum, tf5);
        gp.addRow(5, email, tf6);
        gp.addRow(6, adresse, tf7);
        gp.addRow(7, submit);

        Scene addScene = new Scene(gp, 600,400);

        Stage newStage = new Stage();
        newStage.setTitle("Konto hinzufügen");
        newStage.setScene(addScene);
        newStage.initModality(Modality.WINDOW_MODAL);
        newStage.initOwner(stage);
        newStage.setX(stage.getX() + 100);
        newStage.setY(stage.getY() + 100);
        newStage.show();

        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Connection conn = DBVerbindung.connect();
                PreparedStatement ps = null;
                String query = "SELECT MAX(id) FROM administrator";

                int id;
                try {
                    ps = conn.prepareStatement(query);
                    ResultSet rs = ps.executeQuery();
                    id = rs.getInt(1);
                    id++;
                    String query2 = "INSERT INTO administrator (id, vorname, nachname, passwort, geschlecht, geburtsdatum, email, adresse)" +
                            "VALUES ("+ id +",'"+ tf1.getText() +"','"+ tf2.getText() +"','"+ tf3.getText() +"','"+ tf4.getText() +"','"+ tf5.getText() +"','"+ tf6.getText() +"','"+ tf7.getText() +"')";
                    ps = conn.prepareStatement(query2);
                    ps.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                newStage.close();
            }
        });

    }

    public void addMitarbeiter(Stage stage){
        Label vName = new Label("Vorname");
        Label nName = new Label("Nachname");
        Label passwort = new Label("Passwort");
        Label geschlecht = new Label("Geschlecht");
        Label geburtsdatum = new Label("Geburtsdatum");
        Label email = new Label("E-mail");
        Label adresse = new Label("Adresse");
        Button submit = new Button("Hinzufügen");

        TextField tf1 = new TextField();
        TextField tf2 = new TextField();
        TextField tf3 = new TextField();
        TextField tf4 = new TextField();
        TextField tf5 = new TextField();
        TextField tf6 = new TextField();
        TextField tf7 = new TextField();

        GridPane gp = new GridPane();
        gp.setBackground(new Background(bground));
        gp.setAlignment(Pos.CENTER);
        gp.setHgap(10);
        gp.setVgap(10);
        gp.setPadding(new Insets(25,25,25,25));

        gp.addRow(0, vName, tf1);
        gp.addRow(1, nName, tf2);
        gp.addRow(2, passwort, tf3);
        gp.addRow(3, geschlecht, tf4);
        gp.addRow(4, geburtsdatum, tf5);
        gp.addRow(5, email, tf6);
        gp.addRow(6, adresse, tf7);
        gp.addRow(7, submit);

        Scene addScene = new Scene(gp, 600,400);

        Stage newStage = new Stage();
        newStage.setTitle("Konto hinzufügen");
        newStage.setScene(addScene);
        newStage.initModality(Modality.WINDOW_MODAL);
        newStage.initOwner(stage);
        newStage.setX(stage.getX() + 100);
        newStage.setY(stage.getY() + 100);
        newStage.show();

        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Connection conn = DBVerbindung.connect();
                PreparedStatement ps = null;
                String query = "SELECT MAX(id) FROM mitarbeiter";

                int id;
                try {
                    ps = conn.prepareStatement(query);
                    ResultSet rs = ps.executeQuery();
                    id = rs.getInt(1);
                    id++;
                    String query2 = "INSERT INTO mitarbeiter (id, vorname, nachname, passwort, geschlecht, geburtsdatum, email, adresse)" +
                            "VALUES ("+ id +",'"+ tf1.getText() +"','"+ tf2.getText() +"','"+ tf3.getText() +"','"+ tf4.getText() +"','"+ tf5.getText() +"','"+ tf6.getText() +"','"+ tf7.getText() +"')";
                    ps = conn.prepareStatement(query2);
                    ps.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                newStage.close();
            }
        });
    }

    public void addKunde(Stage stage){
        Label vName = new Label("Vorname");
        Label nName = new Label("Nachname");
        Label geschlecht = new Label("Geschlecht");
        Label geburtsdatum = new Label("Geburtsdatum");
        Label email = new Label("E-mail");
        Label adresse = new Label("Adresse");
        Button submit = new Button("Hinzufügen");

        TextField tf1 = new TextField();
        TextField tf2 = new TextField();
        TextField tf3 = new TextField();
        TextField tf4 = new TextField();
        TextField tf5 = new TextField();
        TextField tf6 = new TextField();

        GridPane gp = new GridPane();
        gp.setBackground(new Background(bground));
        gp.setAlignment(Pos.CENTER);
        gp.setHgap(10);
        gp.setVgap(10);
        gp.setPadding(new Insets(25,25,25,25));

        gp.addRow(0, vName, tf1);
        gp.addRow(1, nName, tf2);
        gp.addRow(2, geschlecht, tf3);
        gp.addRow(3, geburtsdatum, tf4);
        gp.addRow(4, email, tf5);
        gp.addRow(5, adresse, tf6);
        gp.addRow(6, submit);

        Scene addScene = new Scene(gp, 600,400);

        Stage newStage = new Stage();
        newStage.setTitle("Kunde hinzufügen");
        newStage.setScene(addScene);
        newStage.initModality(Modality.WINDOW_MODAL);
        newStage.initOwner(stage);
        newStage.setX(stage.getX() + 100);
        newStage.setY(stage.getY() + 100);
        newStage.show();

        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Connection conn = DBVerbindung.connect();
                PreparedStatement ps = null;
                String query = "SELECT MAX(id) FROM kunde";

                int id;
                try {
                    ps = conn.prepareStatement(query);
                    ResultSet rs = ps.executeQuery();
                    id = rs.getInt(1);
                    id++;
                    String query2 = "INSERT INTO kunde (id, vorname, nachname, geschlecht, geburtsdatum, email, adresse)" +
                            "VALUES ("+ id +",'"+ tf1.getText() +"','"+ tf2.getText() +"','"+ tf3.getText() +"','"+ tf4.getText() +"','"+ tf5.getText() +"','"+ tf6.getText() +"')";
                    ps = conn.prepareStatement(query2);
                    ps.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                newStage.close();
            }
        });
    }

    public void addRechnung(Stage stage){
        Label datum = new Label("Datum");
        Label kunde = new Label("Kunde-ID");
        Label resNr = new Label("Reservierung-ID");
        Button submit = new Button("Hinzufügen");

        TextField tf1 = new TextField();
        TextField tf2 = new TextField();
        TextField tf3 = new TextField();

        GridPane gp = new GridPane();
        gp.setBackground(new Background(bground));
        gp.setAlignment(Pos.CENTER);
        gp.setHgap(10);
        gp.setVgap(10);
        gp.setPadding(new Insets(25,25,25,25));

        gp.addRow(0,datum,tf1);
        gp.addRow(1,kunde,tf2);
        gp.addRow(2,resNr,tf3);
        gp.addRow(3,submit);

        Scene addScene = new Scene(gp, 600,400);

        Stage newStage = new Stage();
        newStage.setTitle("Rechnung hinzufügen");
        newStage.setScene(addScene);
        newStage.initModality(Modality.WINDOW_MODAL);
        newStage.initOwner(stage);
        newStage.setX(stage.getX() + 100);
        newStage.setY(stage.getY() + 100);
        newStage.show();

        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Connection conn = DBVerbindung.connect();
                PreparedStatement ps = null;
                String query = "SELECT MAX(rechnungsNr) FROM rechnung";

                int id;
                try {
                    ps = conn.prepareStatement(query);
                    ResultSet rs = ps.executeQuery();
                    id = rs.getInt(1);
                    id++;
                    String query2 = "INSERT INTO rechnung (rechnungsNr, datum, kunde_id, reservierung_id)" +
                            "VALUES ("+ id +",'"+ tf1.getText() +"','"+ tf2.getText() +"','"+ tf3.getText()+"')";
                    ps = conn.prepareStatement(query2);
                    ps.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                newStage.close();
            }
        });
    }

    public void addReservierung(Stage stage){
        Label datum = new Label("Datum");
        Label person = new Label("Personenanzahl");
        Label preis = new Label("Preis");
        Label waehrung = new Label("Waehrung");
        Label verId = new Label("Veranstaltung-ID");
        Button submit = new Button("Hinzufügen");

        TextField tf1 = new TextField();
        TextField tf2 = new TextField();
        TextField tf3 = new TextField();
        TextField tf4 = new TextField();
        TextField tf5 = new TextField();

        GridPane gp = new GridPane();
        gp.setBackground(new Background(bground));
        gp.setAlignment(Pos.CENTER);
        gp.setHgap(10);
        gp.setVgap(10);
        gp.setPadding(new Insets(25,25,25,25));

        gp.addRow(0,datum,tf1);
        gp.addRow(1,person,tf2);
        gp.addRow(2,preis,tf3);
        gp.addRow(3,waehrung,tf4);
        gp.addRow(4,verId,tf5);
        gp.addRow(5,submit);

        Scene addScene = new Scene(gp, 600,400);

        Stage newStage = new Stage();
        newStage.setTitle("Reservierung hinzufügen");
        newStage.setScene(addScene);
        newStage.initModality(Modality.WINDOW_MODAL);
        newStage.initOwner(stage);
        newStage.setX(stage.getX() + 100);
        newStage.setY(stage.getY() + 100);
        newStage.show();

        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Connection conn = DBVerbindung.connect();
                PreparedStatement ps = null;
                String query = "SELECT MAX(resNr) FROM reservierung";

                int id;
                try {
                    ps = conn.prepareStatement(query);
                    ResultSet rs = ps.executeQuery();
                    id = rs.getInt(1);
                    id++;
                    String query2 = "INSERT INTO reservierung (resNr, datum, personenAnzahl, preis, waehrung, veranstaltung_id)" +
                            "VALUES ("+ id +",'"+ tf1.getText() +"','"+ tf2.getText() +"','"+ Integer.getInteger(tf3.getText())+"','"+ tf4.getText()+"','"+ tf5.getText() +"')";
                    ps = conn.prepareStatement(query2);
                    ps.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                newStage.close();
            }
        });
    }

    public void addVeranstaltung(Stage stage){
        Label name = new Label("Name");
        Label datum = new Label("Datum");
        Label preis = new Label("Preis");
        Label waehrung = new Label("Waehrung");
        Label firma = new Label("Firma-ID");
        Button submit = new Button("Hinzufügen");

        TextField tf1 = new TextField();
        TextField tf2 = new TextField();
        TextField tf3 = new TextField();
        TextField tf4 = new TextField();
        TextField tf5 = new TextField();

        GridPane gp = new GridPane();
        gp.setBackground(new Background(bground));
        gp.setAlignment(Pos.CENTER);
        gp.setHgap(10);
        gp.setVgap(10);
        gp.setPadding(new Insets(25,25,25,25));

        gp.addRow(0,name,tf1);
        gp.addRow(1,datum,tf2);
        gp.addRow(2,preis,tf3);
        gp.addRow(3,waehrung,tf4);
        gp.addRow(4,firma,tf5);
        gp.addRow(5,submit);

        Scene addScene = new Scene(gp, 600,400);

        Stage newStage = new Stage();
        newStage.setTitle("Veranstaltung hinzufügen");
        newStage.setScene(addScene);
        newStage.initModality(Modality.WINDOW_MODAL);
        newStage.initOwner(stage);
        newStage.setX(stage.getX() + 100);
        newStage.setY(stage.getY() + 100);
        newStage.show();

        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Connection conn = DBVerbindung.connect();
                PreparedStatement ps = null;
                String query = "SELECT MAX(verId) FROM veranstaltung";

                int id;
                try {
                    ps = conn.prepareStatement(query);
                    ResultSet rs = ps.executeQuery();
                    id = rs.getInt(1);
                    id++;
                    String query2 = "INSERT INTO veranstaltung (verId, name, datum, preis, waehrung, firma_id)" +
                            "VALUES ("+ id +",'"+ tf1.getText() +"','"+ tf2.getText() +"','"+ Integer.getInteger(tf3.getText())+"','"+ tf4.getText()+"','"+ tf5.getText() +"')";
                    ps = conn.prepareStatement(query2);
                    ps.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                newStage.close();
            }
        });
    }

    public void addFirma(Stage stage){
        Label name = new Label("Name");
        Label telNr = new Label("Telefonnummer");
        Label steuerNr = new Label("Steuernummer");
        Label adresse = new Label("Adresse");
        Button submit = new Button("Hinzufügen");

        TextField tf1 = new TextField();
        TextField tf2 = new TextField();
        TextField tf3 = new TextField();
        TextField tf4 = new TextField();

        GridPane gp = new GridPane();
        gp.setBackground(new Background(bground));
        gp.setAlignment(Pos.CENTER);
        gp.setHgap(10);
        gp.setVgap(10);
        gp.setPadding(new Insets(25,25,25,25));

        gp.addRow(0,name,tf1);
        gp.addRow(1,telNr,tf2);
        gp.addRow(2,steuerNr,tf3);
        gp.addRow(3,adresse,tf4);
        gp.addRow(4,submit);

        Scene addScene = new Scene(gp, 600,400);

        Stage newStage = new Stage();
        newStage.setTitle("Firma hinzufügen");
        newStage.setScene(addScene);
        newStage.initModality(Modality.WINDOW_MODAL);
        newStage.initOwner(stage);
        newStage.setX(stage.getX() + 100);
        newStage.setY(stage.getY() + 100);
        newStage.show();

        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Connection conn = DBVerbindung.connect();
                PreparedStatement ps = null;
                String query = "SELECT MAX(firmaID) FROM firma";

                int id;
                try {
                    ps = conn.prepareStatement(query);
                    ResultSet rs = ps.executeQuery();
                    id = rs.getInt(1);
                    id++;
                    String query2 = "INSERT INTO firma (firmaID, firmaName, telNr, steuerNr, adresse)" +
                            "VALUES ("+ id +",'"+ tf1.getText() +"','"+ tf2.getText() +"','"+ tf3.getText()+ "','" + tf4.getText() +"')";
                    ps = conn.prepareStatement(query2);
                    ps.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                newStage.close();
            }
        });
    }

    public void deleteFirma(Stage stage){
        Label steuerNr = new Label("Steuernummer");
        Button submit = new Button("Löschen");

        TextField tf1 = new TextField();

        GridPane gp = new GridPane();
        gp.setBackground(new Background(bground));
        gp.setAlignment(Pos.CENTER);
        gp.setHgap(10);
        gp.setVgap(10);
        gp.setPadding(new Insets(25,25,25,25));

        gp.addRow(0,steuerNr,tf1);
        gp.addRow(1,submit);

        Scene addScene = new Scene(gp, 600,400);

        Stage newStage = new Stage();
        newStage.setTitle("Firma hinzufügen");
        newStage.setScene(addScene);
        newStage.initModality(Modality.WINDOW_MODAL);
        newStage.initOwner(stage);
        newStage.setX(stage.getX() + 100);
        newStage.setY(stage.getY() + 100);
        newStage.show();

        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Connection conn = DBVerbindung.connect();
                PreparedStatement ps = null;

                try {
                    String query2 = "DELETE FROM firma WHERE steuerNr = " + tf1.getText();
                    ps = conn.prepareStatement(query2);
                    ps.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                newStage.close();
            }
        });
    }

}