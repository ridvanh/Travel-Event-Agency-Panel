package main;
import javafx.beans.InvalidationListener;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.sql.*;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Verbindung {

    public addDataScene addDataScene = new addDataScene();

    BackgroundImage bground = new BackgroundImage(new Image("C:/Users/PC/Desktop/graybg.jpg",1970,
            605, false, true), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

    public static Connection connect() {
        Connection conn = null;
        try {
            String url = "jdbc:sqlite:C:/Users/PC/Desktop/SQLite/TauTourDB.db";
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
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
        newStage.setResizable(false);
        newStage.show();

        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Connection conn = connect();
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
                    conn.close();
                } catch (SQLException e) {
                    addDataScene.falseInputError();
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
        newStage.setResizable(false);
        newStage.show();

        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Connection conn = connect();
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
                    conn.close();
                } catch (SQLException e) {
                    addDataScene.falseInputError();
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
        newStage.setResizable(false);
        newStage.show();

        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Connection conn = connect();
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
                    conn.close();
                } catch (SQLException e) {
                    addDataScene.falseInputError();
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
        newStage.setResizable(false);
        newStage.show();

        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Connection conn = connect();
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
                    conn.close();
                } catch (SQLException e) {
                    addDataScene.falseInputError();
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
        newStage.setResizable(false);
        newStage.show();

        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Connection conn = connect();
                PreparedStatement ps = null;
                String query = "SELECT MAX(resNr) FROM reservierung";

                int id;
                try {
                    ps = conn.prepareStatement(query);
                    ResultSet rs = ps.executeQuery();
                    id = rs.getInt(1);
                    id++;
                    String query2 = "INSERT INTO reservierung (resNr, datum, personenAnzahl, preis, waehrung, veranstaltung_id)" +
                            "VALUES ("+ id +",'"+ tf1.getText() +"','"+ tf2.getText() +"','"+ Integer.parseInt(tf3.getText())+"','"+ tf4.getText()+"','"+ tf5.getText() +"')";
                    ps = conn.prepareStatement(query2);
                    ps.executeUpdate();
                    conn.close();
                } catch (SQLException e) {
                    addDataScene.falseInputError();
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
        newStage.setResizable(false);
        newStage.show();

        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Connection conn = connect();
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
                    conn.close();
                } catch (SQLException e) {
                    addDataScene.falseInputError();
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
        newStage.setResizable(false);
        newStage.show();

        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Connection conn = connect();
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
                    conn.close();
                } catch (SQLException e) {
                    addDataScene.falseInputError();
                    e.printStackTrace();
                }
                newStage.close();
            }
        });
    }

    public void editAdministrator(Stage stage){
        Label idNr = new Label("ID-Nummer");
        Button edit = new Button("Bearbeiten");

        TextField tf1 = new TextField();

        GridPane gp = new GridPane();
        gp.setBackground(new Background(bground));
        gp.setAlignment(Pos.CENTER);
        gp.setHgap(10);
        gp.setVgap(10);
        gp.setPadding(new Insets(25,25,25,25));

        gp.addRow(0,idNr,tf1);
        gp.addRow(1,edit);

        Scene addScene = new Scene(gp, 600,400);

        Stage newStage = new Stage();
        newStage.setTitle("Administratorkonto bearbeiten");
        newStage.setScene(addScene);
        newStage.initModality(Modality.WINDOW_MODAL);
        newStage.initOwner(stage);
        newStage.setX(stage.getX() + 100);
        newStage.setY(stage.getY() + 100);
        newStage.setResizable(false);
        newStage.show();

        edit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                newStage.close();
                Connection conn = connect();
                PreparedStatement ps = null;

                try {

                    String query = "SELECT * FROM administrator WHERE id = " + tf1.getText();
                    ps = conn.prepareStatement(query);
                    ResultSet rs = ps.executeQuery();

                    Label vName = new Label("Vorname");
                    Label nName = new Label("Nachname");
                    Label pwort = new Label("Passwort");
                    Label geschlecht = new Label("Geschlecht");
                    Label geburtsdatum = new Label("Geburtsdatum");
                    Label email = new Label("E-mail");
                    Label adresse = new Label("Adresse");
                    Button submit = new Button("Fertig");

                    int id = rs.getInt(1);
                    TextField tf2 = new TextField(rs.getString(2));
                    TextField tf3 = new TextField(rs.getString(3));
                    TextField tf4 = new TextField(rs.getString(4));
                    TextField tf5 = new TextField(rs.getString(5));
                    TextField tf6 = new TextField(rs.getString(6));
                    TextField tf7 = new TextField(rs.getString(7));
                    TextField tf8 = new TextField(rs.getString(8));

                    GridPane gp2 = new GridPane();
                    gp2.setBackground(new Background(bground));
                    gp2.setAlignment(Pos.CENTER);
                    gp2.setHgap(10);
                    gp2.setVgap(10);
                    gp2.setPadding(new Insets(25,25,25,25));

                    gp2.addRow(0,vName,tf2);
                    gp2.addRow(1,nName,tf3);
                    gp2.addRow(2,pwort,tf4);
                    gp2.addRow(3,geschlecht,tf5);
                    gp2.addRow(4,geburtsdatum,tf6);
                    gp2.addRow(5,email,tf7);
                    gp2.addRow(6,adresse,tf8);
                    gp2.addRow(7,submit);

                    Scene addScene2 = new Scene(gp2,600,400);

                    Stage newStage2 = new Stage();
                    newStage2.setTitle("Administratorkonto bearbeiten");
                    newStage2.setScene(addScene2);
                    newStage2.initModality(Modality.WINDOW_MODAL);
                    newStage2.initOwner(stage);
                    newStage2.setX(stage.getX() + 100);
                    newStage2.setY(stage.getY() + 100);
                    newStage2.show();

                    submit.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            try {
                                PreparedStatement ps2 = null;
                                String query2 = "UPDATE administrator SET vorname = '"+ tf2.getText() + "', nachname = '" + tf3.getText() + "', passwort = '" + tf4.getText() + "', geschlecht = '" + tf5.getText() +
                                        "', geburtsdatum = '" + tf6.getText() + "', email = '" + tf7.getText() + "', adresse = '" + tf8.getText() + "' WHERE id = " + id;
                                ps2 = conn.prepareStatement(query2);
                                ps2.executeUpdate();
                                conn.close();
                            } catch (SQLException e){
                                addDataScene.falseInputError();
                                e.printStackTrace();
                            }
                            newStage2.close();
                        }
                    });


                } catch (SQLException e) {
                    addDataScene.falseInputError();
                    e.printStackTrace();
                }
            }
        });
    }

    public void editMitarbeiter(Stage stage){
        Label idNr = new Label("ID-Nummer");
        Button edit = new Button("Bearbeiten");

        TextField tf1 = new TextField();

        GridPane gp = new GridPane();
        gp.setBackground(new Background(bground));
        gp.setAlignment(Pos.CENTER);
        gp.setHgap(10);
        gp.setVgap(10);
        gp.setPadding(new Insets(25,25,25,25));

        gp.addRow(0,idNr,tf1);
        gp.addRow(1,edit);

        Scene addScene = new Scene(gp, 600,400);

        Stage newStage = new Stage();
        newStage.setTitle("Mitarbeiterkonto bearbeiten");
        newStage.setScene(addScene);
        newStage.initModality(Modality.WINDOW_MODAL);
        newStage.initOwner(stage);
        newStage.setX(stage.getX() + 100);
        newStage.setY(stage.getY() + 100);
        newStage.setResizable(false);
        newStage.show();

        edit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                newStage.close();
                Connection conn = connect();
                PreparedStatement ps = null;

                try {

                    String query = "SELECT * FROM mitarbeiter WHERE id = " + tf1.getText();
                    ps = conn.prepareStatement(query);
                    ResultSet rs = ps.executeQuery();

                    Label vName = new Label("Vorname");
                    Label nName = new Label("Nachname");
                    Label pwort = new Label("Passwort");
                    Label geschlecht = new Label("Geschlecht");
                    Label geburtsdatum = new Label("Geburtsdatum");
                    Label email = new Label("E-mail");
                    Label adresse = new Label("Adresse");
                    Button submit = new Button("Fertig");

                    int id = rs.getInt(1);
                    TextField tf2 = new TextField(rs.getString(2));
                    TextField tf3 = new TextField(rs.getString(3));
                    TextField tf4 = new TextField(rs.getString(4));
                    TextField tf5 = new TextField(rs.getString(5));
                    TextField tf6 = new TextField(rs.getString(6));
                    TextField tf7 = new TextField(rs.getString(7));
                    TextField tf8 = new TextField(rs.getString(8));

                    GridPane gp2 = new GridPane();
                    gp2.setBackground(new Background(bground));
                    gp2.setAlignment(Pos.CENTER);
                    gp2.setHgap(10);
                    gp2.setVgap(10);
                    gp2.setPadding(new Insets(25,25,25,25));

                    gp2.addRow(0,vName,tf2);
                    gp2.addRow(1,nName,tf3);
                    gp2.addRow(2,pwort,tf4);
                    gp2.addRow(3,geschlecht,tf5);
                    gp2.addRow(4,geburtsdatum,tf6);
                    gp2.addRow(5,email,tf7);
                    gp2.addRow(6,adresse,tf8);
                    gp2.addRow(7,submit);

                    Scene addScene2 = new Scene(gp2,600,400);

                    Stage newStage2 = new Stage();
                    newStage2.setTitle("Mitarbeiterkonto bearbeiten");
                    newStage2.setScene(addScene2);
                    newStage2.initModality(Modality.WINDOW_MODAL);
                    newStage2.initOwner(stage);
                    newStage2.setX(stage.getX() + 100);
                    newStage2.setY(stage.getY() + 100);
                    newStage2.show();

                    submit.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            try {
                                PreparedStatement ps2 = null;
                                String query2 = "UPDATE mitarbeiter SET vorname = '"+ tf2.getText() + "', nachname = '" + tf3.getText() + "', passwort = '" + tf4.getText() + "', geschlecht = '" + tf5.getText() +
                                        "', geburtsdatum = '" + tf6.getText() + "', email = '" + tf7.getText() + "', adresse = '" + tf8.getText() + "' WHERE id = " + id;
                                ps2 = conn.prepareStatement(query2);
                                ps2.executeUpdate();
                                conn.close();
                            } catch (SQLException e){
                                addDataScene.falseInputError();
                                e.printStackTrace();
                            }
                            newStage2.close();
                        }
                    });


                } catch (SQLException e) {
                    addDataScene.falseInputError();
                    e.printStackTrace();
                }
            }
        });
    }

    public void editKunde(Stage stage){
        Label idNr = new Label("ID-Nummer");
        Button edit = new Button("Bearbeiten");

        TextField tf1 = new TextField();

        GridPane gp = new GridPane();
        gp.setBackground(new Background(bground));
        gp.setAlignment(Pos.CENTER);
        gp.setHgap(10);
        gp.setVgap(10);
        gp.setPadding(new Insets(25,25,25,25));

        gp.addRow(0,idNr,tf1);
        gp.addRow(1,edit);

        Scene addScene = new Scene(gp, 600,400);

        Stage newStage = new Stage();
        newStage.setTitle("Kunde bearbeiten");
        newStage.setScene(addScene);
        newStage.initModality(Modality.WINDOW_MODAL);
        newStage.initOwner(stage);
        newStage.setX(stage.getX() + 100);
        newStage.setY(stage.getY() + 100);
        newStage.setResizable(false);
        newStage.show();

        edit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                newStage.close();
                Connection conn = connect();
                PreparedStatement ps = null;

                try {

                    String query = "SELECT * FROM kunde WHERE id = " + tf1.getText();
                    ps = conn.prepareStatement(query);
                    ResultSet rs = ps.executeQuery();

                    Label vName = new Label("Vorname");
                    Label nName = new Label("Nachname");
                    Label geschlecht = new Label("Geschlecht");
                    Label geburtsdatum = new Label("Geburtsdatum");
                    Label email = new Label("E-mail");
                    Label adresse = new Label("Adresse");
                    Button submit = new Button("Fertig");

                    int id = rs.getInt(1);
                    TextField tf2 = new TextField(rs.getString(2));
                    TextField tf3 = new TextField(rs.getString(3));
                    TextField tf4 = new TextField(rs.getString(4));
                    TextField tf5 = new TextField(rs.getString(5));
                    TextField tf6 = new TextField(rs.getString(6));
                    TextField tf7 = new TextField(rs.getString(7));

                    GridPane gp2 = new GridPane();
                    gp2.setBackground(new Background(bground));
                    gp2.setAlignment(Pos.CENTER);
                    gp2.setHgap(10);
                    gp2.setVgap(10);
                    gp2.setPadding(new Insets(25,25,25,25));

                    gp2.addRow(0,vName,tf2);
                    gp2.addRow(1,nName,tf3);
                    gp2.addRow(2,geschlecht,tf4);
                    gp2.addRow(3,geburtsdatum,tf5);
                    gp2.addRow(4,email,tf6);
                    gp2.addRow(5,adresse,tf7);
                    gp2.addRow(6,submit);

                    Scene addScene2 = new Scene(gp2,600,400);

                    Stage newStage2 = new Stage();
                    newStage2.setTitle("Kunde bearbeiten");
                    newStage2.setScene(addScene2);
                    newStage2.initModality(Modality.WINDOW_MODAL);
                    newStage2.initOwner(stage);
                    newStage2.setX(stage.getX() + 100);
                    newStage2.setY(stage.getY() + 100);
                    newStage2.show();

                    submit.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            try {
                                PreparedStatement ps2 = null;
                                String query2 = "UPDATE kunde SET vorname = '"+ tf2.getText() + "', nachname = '" + tf3.getText() + "', geschlecht = '" + tf4.getText() +
                                        "', geburtsdatum = '" + tf5.getText() + "', email = '" + tf6.getText() + "', adresse = '" + tf7.getText() + "' WHERE id = " + id;
                                ps2 = conn.prepareStatement(query2);
                                ps2.executeUpdate();
                                conn.close();
                            } catch (SQLException e){
                                addDataScene.falseInputError();
                                e.printStackTrace();
                            }
                            newStage2.close();
                        }
                    });


                } catch (SQLException e) {
                    addDataScene.falseInputError();
                    e.printStackTrace();
                }
            }
        });
    }

    public void editRechnung(Stage stage){
        Label idNr = new Label("Rechnungsnummer");
        Button edit = new Button("Bearbeiten");

        TextField tf1 = new TextField();

        GridPane gp = new GridPane();
        gp.setBackground(new Background(bground));
        gp.setAlignment(Pos.CENTER);
        gp.setHgap(10);
        gp.setVgap(10);
        gp.setPadding(new Insets(25,25,25,25));

        gp.addRow(0,idNr,tf1);
        gp.addRow(1,edit);

        Scene addScene = new Scene(gp, 600,400);

        Stage newStage = new Stage();
        newStage.setTitle("Rechnung bearbeiten");
        newStage.setScene(addScene);
        newStage.initModality(Modality.WINDOW_MODAL);
        newStage.initOwner(stage);
        newStage.setX(stage.getX() + 100);
        newStage.setY(stage.getY() + 100);
        newStage.setResizable(false);
        newStage.show();

        edit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                newStage.close();
                Connection conn = connect();
                PreparedStatement ps = null;

                try {

                    String query = "SELECT * FROM rechnung WHERE rechnungsNr = " + tf1.getText();
                    ps = conn.prepareStatement(query);
                    ResultSet rs = ps.executeQuery();

                    Label datum = new Label("Datum");
                    Label kid = new Label("Kunde-ID");
                    Label rid = new Label("Reservierung-ID");
                    Button submit = new Button("Fertig");

                    int id = rs.getInt(1);
                    TextField tf2 = new TextField(rs.getString(2));
                    TextField tf3 = new TextField(rs.getString(3));
                    TextField tf4 = new TextField(rs.getString(4));

                    GridPane gp2 = new GridPane();
                    gp2.setBackground(new Background(bground));
                    gp2.setAlignment(Pos.CENTER);
                    gp2.setHgap(10);
                    gp2.setVgap(10);
                    gp2.setPadding(new Insets(25,25,25,25));

                    gp2.addRow(0,datum,tf2);
                    gp2.addRow(1,kid,tf3);
                    gp2.addRow(2,rid,tf4);
                    gp2.addRow(3,submit);

                    Scene addScene2 = new Scene(gp2,600,400);

                    Stage newStage2 = new Stage();
                    newStage2.setTitle("Rechnung bearbeiten");
                    newStage2.setScene(addScene2);
                    newStage2.initModality(Modality.WINDOW_MODAL);
                    newStage2.initOwner(stage);
                    newStage2.setX(stage.getX() + 100);
                    newStage2.setY(stage.getY() + 100);
                    newStage2.show();

                    submit.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            try {
                                PreparedStatement ps2 = null;
                                String query2 = "UPDATE rechnung SET datum = '"+ tf2.getText() + "', kunde_id = '" + tf3.getText() + "', reservierung_id = '" + tf4.getText() +
                                        "' WHERE rechnungsNr = " + id;
                                ps2 = conn.prepareStatement(query2);
                                ps2.executeUpdate();
                                conn.close();
                            } catch (SQLException e){
                                addDataScene.falseInputError();
                                e.printStackTrace();
                            }
                            newStage2.close();
                        }
                    });


                } catch (SQLException e) {
                    addDataScene.falseInputError();
                    e.printStackTrace();
                }
            }
        });
    }

    public void editReservierung(Stage stage){
        Label idNr = new Label("Reservierungsnummer");
        Button edit = new Button("Bearbeiten");

        TextField tf1 = new TextField();

        GridPane gp = new GridPane();
        gp.setBackground(new Background(bground));
        gp.setAlignment(Pos.CENTER);
        gp.setHgap(10);
        gp.setVgap(10);
        gp.setPadding(new Insets(25,25,25,25));

        gp.addRow(0,idNr,tf1);
        gp.addRow(1,edit);

        Scene addScene = new Scene(gp, 600,400);

        Stage newStage = new Stage();
        newStage.setTitle("Reservierung bearbeiten");
        newStage.setScene(addScene);
        newStage.initModality(Modality.WINDOW_MODAL);
        newStage.initOwner(stage);
        newStage.setX(stage.getX() + 100);
        newStage.setY(stage.getY() + 100);
        newStage.setResizable(false);
        newStage.show();

        edit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                newStage.close();
                Connection conn = connect();
                PreparedStatement ps = null;

                try {

                    String query = "SELECT * FROM reservierung WHERE resNr = " + tf1.getText();
                    ps = conn.prepareStatement(query);
                    ResultSet rs = ps.executeQuery();

                    Label datum = new Label("Datum");
                    Label pAnzahl = new Label("Personenanzahl");
                    Label preis = new Label("Preis");
                    Label whr = new Label("Waehrung");
                    Label vid = new Label("Veranstaltung-ID");
                    Button submit = new Button("Fertig");

                    int id = rs.getInt(1);
                    TextField tf2 = new TextField(rs.getString(2));
                    TextField tf3 = new TextField(rs.getString(3));
                    TextField tf4 = new TextField(rs.getString(4));
                    TextField tf5 = new TextField(rs.getString(5));
                    TextField tf6 = new TextField(rs.getString(6));

                    GridPane gp2 = new GridPane();
                    gp2.setBackground(new Background(bground));
                    gp2.setAlignment(Pos.CENTER);
                    gp2.setHgap(10);
                    gp2.setVgap(10);
                    gp2.setPadding(new Insets(25,25,25,25));

                    gp2.addRow(0,datum,tf2);
                    gp2.addRow(1,pAnzahl,tf3);
                    gp2.addRow(2,preis,tf4);
                    gp2.addRow(3,whr,tf5);
                    gp2.addRow(4,vid,tf6);
                    gp2.addRow(5,submit);

                    Scene addScene2 = new Scene(gp2,600,400);

                    Stage newStage2 = new Stage();
                    newStage2.setTitle("Reservierung bearbeiten");
                    newStage2.setScene(addScene2);
                    newStage2.initModality(Modality.WINDOW_MODAL);
                    newStage2.initOwner(stage);
                    newStage2.setX(stage.getX() + 100);
                    newStage2.setY(stage.getY() + 100);
                    newStage2.show();

                    submit.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            try {
                                PreparedStatement ps2 = null;
                                String query2 = "UPDATE reservierung SET datum = '"+ tf2.getText() + "', personenAnzahl = '" + tf3.getText() + "', preis = '" + tf4.getText() +
                                        "', waehrung = '" + tf5.getText() + "', veranstaltung_id = '" + tf6.getText() + "' WHERE resNr = " + id;
                                ps2 = conn.prepareStatement(query2);
                                ps2.executeUpdate();
                                conn.close();
                            } catch (SQLException e){
                                addDataScene.falseInputError();
                                e.printStackTrace();
                            }
                            newStage2.close();
                        }
                    });


                } catch (SQLException e) {
                    addDataScene.falseInputError();
                    e.printStackTrace();
                }
            }
        });
    }

    public void editFirma(Stage stage){
        Label idNr = new Label("Firma-ID");
        Button edit = new Button("Bearbeiten");

        TextField tf1 = new TextField();

        GridPane gp = new GridPane();
        gp.setBackground(new Background(bground));
        gp.setAlignment(Pos.CENTER);
        gp.setHgap(10);
        gp.setVgap(10);
        gp.setPadding(new Insets(25,25,25,25));

        gp.addRow(0,idNr,tf1);
        gp.addRow(1,edit);

        Scene addScene = new Scene(gp, 600,400);

        Stage newStage = new Stage();
        newStage.setTitle("Firma bearbeiten");
        newStage.setScene(addScene);
        newStage.initModality(Modality.WINDOW_MODAL);
        newStage.initOwner(stage);
        newStage.setX(stage.getX() + 100);
        newStage.setY(stage.getY() + 100);
        newStage.setResizable(false);
        newStage.show();

        edit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                newStage.close();
                Connection conn = connect();
                PreparedStatement ps = null;

                try {

                    String query = "SELECT * FROM firma WHERE firmaID = " + tf1.getText();
                    ps = conn.prepareStatement(query);
                    ResultSet rs = ps.executeQuery();


                    Label fName = new Label("Name");
                    Label telNr = new Label("Telefonnummer");
                    Label steuerNr = new Label("Steuernummer");
                    Label adresse = new Label("Adresse");
                    Button submit = new Button("Fertig");

                    int id = rs.getInt(1);
                    TextField tf2 = new TextField(rs.getString(2));
                    TextField tf3 = new TextField(rs.getString(3));
                    TextField tf4 = new TextField(rs.getString(4));
                    TextField tf5 = new TextField(rs.getString(5));

                    GridPane gp2 = new GridPane();
                    gp2.setBackground(new Background(bground));
                    gp2.setAlignment(Pos.CENTER);
                    gp2.setHgap(10);
                    gp2.setVgap(10);
                    gp2.setPadding(new Insets(25,25,25,25));

                    gp2.addRow(0,fName,tf2);
                    gp2.addRow(1,telNr,tf3);
                    gp2.addRow(2,steuerNr,tf4);
                    gp2.addRow(3,adresse,tf5);
                    gp2.addRow(4,submit);

                    Scene addScene2 = new Scene(gp2,600,400);

                    Stage newStage2 = new Stage();
                    newStage2.setTitle("Firma bearbeiten");
                    newStage2.setScene(addScene2);
                    newStage2.initModality(Modality.WINDOW_MODAL);
                    newStage2.initOwner(stage);
                    newStage2.setX(stage.getX() + 100);
                    newStage2.setY(stage.getY() + 100);
                    newStage2.show();

                    submit.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            try {
                                PreparedStatement ps2 = null;
                                String query2 = "UPDATE firma SET firmaName = '"+ tf2.getText() + "', telNr = '" + tf3.getText() + "', steuerNr = '" + tf4.getText() +
                                        "', adresse = '" + tf5.getText() + "' WHERE firmaID = " + id;
                                ps2 = conn.prepareStatement(query2);
                                ps2.executeUpdate();
                                conn.close();
                            } catch (SQLException e){
                                addDataScene.falseInputError();
                                e.printStackTrace();
                            }
                            newStage2.close();
                        }
                    });


                } catch (SQLException e) {
                    addDataScene.falseInputError();
                    e.printStackTrace();
                }
            }
        });
    }

    public void editVeranstaltung(Stage stage){
        Label idNr = new Label("Veranstaltung-ID");
        Button edit = new Button("Bearbeiten");

        TextField tf1 = new TextField();

        GridPane gp = new GridPane();
        gp.setBackground(new Background(bground));
        gp.setAlignment(Pos.CENTER);
        gp.setHgap(10);
        gp.setVgap(10);
        gp.setPadding(new Insets(25,25,25,25));

        gp.addRow(0,idNr,tf1);
        gp.addRow(1,edit);

        Scene addScene = new Scene(gp, 600,400);

        Stage newStage = new Stage();
        newStage.setTitle("Veranstaltung bearbeiten");
        newStage.setScene(addScene);
        newStage.initModality(Modality.WINDOW_MODAL);
        newStage.initOwner(stage);
        newStage.setX(stage.getX() + 100);
        newStage.setY(stage.getY() + 100);
        newStage.setResizable(false);
        newStage.show();

        edit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                newStage.close();
                Connection conn = connect();
                PreparedStatement ps = null;

                try {

                    String query = "SELECT * FROM veranstaltung WHERE verId = " + tf1.getText();
                    ps = conn.prepareStatement(query);
                    ResultSet rs = ps.executeQuery();

                    Label name = new Label("Name");
                    Label datum = new Label("Datum");
                    Label preis = new Label("Preis");
                    Label whr = new Label("Waehrung");
                    Label fid = new Label("Firma-ID");
                    Button submit = new Button("Fertig");

                    int id = rs.getInt(1);
                    TextField tf2 = new TextField(rs.getString(2));
                    TextField tf3 = new TextField(rs.getString(3));
                    TextField tf4 = new TextField(rs.getString(4));
                    TextField tf5 = new TextField(rs.getString(5));
                    TextField tf6 = new TextField(rs.getString(6));

                    GridPane gp2 = new GridPane();
                    gp2.setBackground(new Background(bground));
                    gp2.setAlignment(Pos.CENTER);
                    gp2.setHgap(10);
                    gp2.setVgap(10);
                    gp2.setPadding(new Insets(25,25,25,25));

                    gp2.addRow(0,name,tf2);
                    gp2.addRow(1,datum,tf3);
                    gp2.addRow(2,preis,tf4);
                    gp2.addRow(3,whr,tf5);
                    gp2.addRow(4,fid,tf6);
                    gp2.addRow(5,submit);

                    Scene addScene2 = new Scene(gp2,600,400);

                    Stage newStage2 = new Stage();
                    newStage2.setTitle("Veranstaltung bearbeiten");
                    newStage2.setScene(addScene2);
                    newStage2.initModality(Modality.WINDOW_MODAL);
                    newStage2.initOwner(stage);
                    newStage2.setX(stage.getX() + 100);
                    newStage2.setY(stage.getY() + 100);
                    newStage2.show();

                    submit.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            try {
                                PreparedStatement ps2 = null;
                                String query2 = "UPDATE veranstaltung SET name = '"+ tf2.getText() + "', datum = '" + tf3.getText() + "', preis = '" + tf4.getText() +
                                        "', waehrung = '" + tf5.getText() + "', firma_id = '" + tf6.getText() + "' WHERE verId = " + id;
                                ps2 = conn.prepareStatement(query2);
                                ps2.executeUpdate();
                                conn.close();
                            } catch (SQLException e){
                                addDataScene.falseInputError();
                                e.printStackTrace();
                            }
                            newStage2.close();
                        }
                    });


                } catch (SQLException e) {
                    addDataScene.falseInputError();
                    e.printStackTrace();
                }
            }
        });
    }

    public void deleteAdmin(Stage stage){
        Label idNr = new Label("ID-Nummer");
        Button submit = new Button("Löschen");

        TextField tf1 = new TextField();

        GridPane gp = new GridPane();
        gp.setBackground(new Background(bground));
        gp.setAlignment(Pos.CENTER);
        gp.setHgap(10);
        gp.setVgap(10);
        gp.setPadding(new Insets(25,25,25,25));

        gp.addRow(0,idNr,tf1);
        gp.addRow(1,submit);

        Scene addScene = new Scene(gp, 600,400);

        Stage newStage = new Stage();
        newStage.setTitle("Administratorkonto löschen");
        newStage.setScene(addScene);
        newStage.initModality(Modality.WINDOW_MODAL);
        newStage.initOwner(stage);
        newStage.setX(stage.getX() + 100);
        newStage.setY(stage.getY() + 100);
        newStage.setResizable(false);
        newStage.show();

        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Connection conn = connect();
                PreparedStatement ps = null;

                try {
                    String query2 = "DELETE FROM administrator WHERE id = " + tf1.getText();
                    ps = conn.prepareStatement(query2);
                    ps.executeUpdate();
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                newStage.close();
            }
        });
    }

    public void deleteMitarbeiter(Stage stage){
        Label idNr = new Label("ID-Nummer");
        Button submit = new Button("Löschen");

        TextField tf1 = new TextField();

        GridPane gp = new GridPane();
        gp.setBackground(new Background(bground));
        gp.setAlignment(Pos.CENTER);
        gp.setHgap(10);
        gp.setVgap(10);
        gp.setPadding(new Insets(25,25,25,25));

        gp.addRow(0,idNr,tf1);
        gp.addRow(1,submit);

        Scene addScene = new Scene(gp, 600,400);

        Stage newStage = new Stage();
        newStage.setTitle("Mitarbeiterkonto löschen");
        newStage.setScene(addScene);
        newStage.initModality(Modality.WINDOW_MODAL);
        newStage.initOwner(stage);
        newStage.setX(stage.getX() + 100);
        newStage.setY(stage.getY() + 100);
        newStage.setResizable(false);
        newStage.show();

        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Connection conn = connect();
                PreparedStatement ps = null;

                try {
                    String query2 = "DELETE FROM mitarbeiter WHERE id = " + tf1.getText();
                    ps = conn.prepareStatement(query2);
                    ps.executeUpdate();
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                newStage.close();
            }
        });
    }

    public void deleteKunde(Stage stage){
        Label idNr = new Label("ID-Nummer");
        Button submit = new Button("Löschen");

        TextField tf1 = new TextField();

        GridPane gp = new GridPane();
        gp.setBackground(new Background(bground));
        gp.setAlignment(Pos.CENTER);
        gp.setHgap(10);
        gp.setVgap(10);
        gp.setPadding(new Insets(25,25,25,25));

        gp.addRow(0,idNr,tf1);
        gp.addRow(1,submit);

        Scene addScene = new Scene(gp, 600,400);

        Stage newStage = new Stage();
        newStage.setTitle("Kunde löschen");
        newStage.setScene(addScene);
        newStage.initModality(Modality.WINDOW_MODAL);
        newStage.initOwner(stage);
        newStage.setX(stage.getX() + 100);
        newStage.setY(stage.getY() + 100);
        newStage.setResizable(false);
        newStage.show();

        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Connection conn = connect();
                PreparedStatement ps = null;

                try {
                    String query2 = "DELETE FROM kunde WHERE id = " + tf1.getText();
                    ps = conn.prepareStatement(query2);
                    ps.executeUpdate();
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                newStage.close();
            }
        });
    }

    public void deleteRechnung(Stage stage){
        Label idNr = new Label("Rechnungsnummer");
        Button submit = new Button("Löschen");

        TextField tf1 = new TextField();

        GridPane gp = new GridPane();
        gp.setBackground(new Background(bground));
        gp.setAlignment(Pos.CENTER);
        gp.setHgap(10);
        gp.setVgap(10);
        gp.setPadding(new Insets(25,25,25,25));

        gp.addRow(0,idNr,tf1);
        gp.addRow(1,submit);

        Scene addScene = new Scene(gp, 600,400);

        Stage newStage = new Stage();
        newStage.setTitle("Rechnung löschen");
        newStage.setScene(addScene);
        newStage.initModality(Modality.WINDOW_MODAL);
        newStage.initOwner(stage);
        newStage.setX(stage.getX() + 100);
        newStage.setY(stage.getY() + 100);
        newStage.setResizable(false);
        newStage.show();

        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Connection conn = connect();
                PreparedStatement ps = null;

                try {
                    String query2 = "DELETE FROM rechnung WHERE rechnungsNr = " + tf1.getText();
                    ps = conn.prepareStatement(query2);
                    ps.executeUpdate();
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                newStage.close();
            }
        });
    }

    public void deleteReservierung(Stage stage){
        Label idNr = new Label("Reservierungsnummer");
        Button submit = new Button("Löschen");

        TextField tf1 = new TextField();

        GridPane gp = new GridPane();
        gp.setBackground(new Background(bground));
        gp.setAlignment(Pos.CENTER);
        gp.setHgap(10);
        gp.setVgap(10);
        gp.setPadding(new Insets(25,25,25,25));

        gp.addRow(0,idNr,tf1);
        gp.addRow(1,submit);

        Scene addScene = new Scene(gp, 600,400);

        Stage newStage = new Stage();
        newStage.setTitle("Reservierung löschen");
        newStage.setScene(addScene);
        newStage.initModality(Modality.WINDOW_MODAL);
        newStage.initOwner(stage);
        newStage.setX(stage.getX() + 100);
        newStage.setY(stage.getY() + 100);
        newStage.setResizable(false);
        newStage.show();

        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Connection conn = connect();
                PreparedStatement ps = null;

                try {
                    String query2 = "DELETE FROM reservierung WHERE resNr = " + tf1.getText();
                    ps = conn.prepareStatement(query2);
                    ps.executeUpdate();
                    conn.close();
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
        newStage.setTitle("Firma löschen");
        newStage.setScene(addScene);
        newStage.initModality(Modality.WINDOW_MODAL);
        newStage.initOwner(stage);
        newStage.setX(stage.getX() + 100);
        newStage.setY(stage.getY() + 100);
        newStage.setResizable(false);
        newStage.show();

        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Connection conn = connect();
                PreparedStatement ps = null;

                try {
                    String query2 = "DELETE FROM firma WHERE steuerNr = " + tf1.getText();
                    ps = conn.prepareStatement(query2);
                    ps.executeUpdate();
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                newStage.close();
            }
        });
    }

    public void deleteVeranstaltung(Stage stage){
        Label idNr = new Label("Veranstaltungsnummer");
        Button submit = new Button("Löschen");

        TextField tf1 = new TextField();

        GridPane gp = new GridPane();
        gp.setBackground(new Background(bground));
        gp.setAlignment(Pos.CENTER);
        gp.setHgap(10);
        gp.setVgap(10);
        gp.setPadding(new Insets(25,25,25,25));

        gp.addRow(0,idNr,tf1);
        gp.addRow(1,submit);

        Scene addScene = new Scene(gp, 600,400);

        Stage newStage = new Stage();
        newStage.setTitle("Veranstaltung löschen");
        newStage.setScene(addScene);
        newStage.initModality(Modality.WINDOW_MODAL);
        newStage.initOwner(stage);
        newStage.setX(stage.getX() + 100);
        newStage.setY(stage.getY() + 100);
        newStage.setResizable(false);
        newStage.show();

        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Connection conn = connect();
                PreparedStatement ps = null;

                try {
                    String query2 = "DELETE FROM veranstaltung WHERE verId = " + tf1.getText();
                    ps = conn.prepareStatement(query2);
                    ps.executeUpdate();
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                newStage.close();
            }
        });
    }

    public TableView getAdministratoren(){
        TableView tableView = new TableView<>();
        ObservableList<ObservableList> data = FXCollections.observableArrayList();
        Connection conn = connect();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("select * from administrator");
            ResultSet rs = ps.executeQuery();
            for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
                final int j = i;
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                        return new SimpleStringProperty(param.getValue().get(j).toString());
                    }
                });

                tableView.getColumns().addAll(col);
            }
            while(rs.next()){
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
                    row.add(rs.getString(i));
                }
                data.add(row);

            }

            tableView.setItems(data);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tableView;
    }

    public TableView getMitarbeitern(){
        TableView tableView = new TableView<>();
        ObservableList<ObservableList> data = FXCollections.observableArrayList();
        Connection conn = connect();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("select * from mitarbeiter");
            ResultSet rs = ps.executeQuery();
            for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
                final int j = i;
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                        return new SimpleStringProperty(param.getValue().get(j).toString());
                    }
                });

                tableView.getColumns().addAll(col);
            }
            while(rs.next()){
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
                    row.add(rs.getString(i));
                }
                data.add(row);

            }

            tableView.setItems(data);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tableView;
    }

    public TableView getKunden(){
        TableView tableView = new TableView<>();
        ObservableList<ObservableList> data = FXCollections.observableArrayList();
        Connection conn = connect();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("select * from kunde");
            ResultSet rs = ps.executeQuery();
            for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
                final int j = i;
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                        return new SimpleStringProperty(param.getValue().get(j).toString());
                    }
                });

                tableView.getColumns().addAll(col);
            }
            while(rs.next()){
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
                    row.add(rs.getString(i));
                }
                data.add(row);

            }

            tableView.setItems(data);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tableView;
    }

    public TableView getFirmen(){
        TableView tableView = new TableView<>();
        ObservableList<ObservableList> data = FXCollections.observableArrayList();
        Connection conn = connect();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("select * from firma");
            ResultSet rs = ps.executeQuery();
            for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
                final int j = i;
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                        return new SimpleStringProperty(param.getValue().get(j).toString());
                    }
                });

                tableView.getColumns().addAll(col);
            }
            while(rs.next()){
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
                    row.add(rs.getString(i));
                }
                data.add(row);

            }

            tableView.setItems(data);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tableView;
    }

    public TableView getVeranstaltungen(){
        TableView tableView = new TableView<>();
        ObservableList<ObservableList> data = FXCollections.observableArrayList();
        Connection conn = connect();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("select * from veranstaltung");
            ResultSet rs = ps.executeQuery();
            for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
                final int j = i;
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                        return new SimpleStringProperty(param.getValue().get(j).toString());
                    }
                });

                tableView.getColumns().addAll(col);
            }
            while(rs.next()){
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
                    row.add(rs.getString(i));
                }
                data.add(row);

            }

            tableView.setItems(data);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tableView;
    }

    public TableView getRechnungen(){
        TableView tableView = new TableView<>();
        ObservableList<ObservableList> data = FXCollections.observableArrayList();
        Connection conn = connect();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("select * from rechnung");
            ResultSet rs = ps.executeQuery();
            for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
                final int j = i;
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                        return new SimpleStringProperty(param.getValue().get(j).toString());
                    }
                });

                tableView.getColumns().addAll(col);
            }
            while(rs.next()){
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
                    row.add(rs.getString(i));
                }
                data.add(row);

            }

            tableView.setItems(data);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tableView;
    }

    public TableView getReservierungen(){
        TableView tableView = new TableView<>();
        ObservableList<ObservableList> data = FXCollections.observableArrayList();
        Connection conn = connect();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("select * from reservierung");
            ResultSet rs = ps.executeQuery();
            for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
                final int j = i;
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                        return new SimpleStringProperty(param.getValue().get(j).toString());
                    }
                });

                tableView.getColumns().addAll(col);
            }
            while(rs.next()){
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
                    row.add(rs.getString(i));
                }
                data.add(row);

            }

            tableView.setItems(data);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tableView;
    }

    public TableView showMonthlyIncome(){
        TableView tableView = new TableView<>();
        ObservableList<ObservableList> data = FXCollections.observableArrayList();
        Connection conn = connect();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT strftime('%m', datum) Monat, SUM(preis) AS Verdienst FROM reservierung GROUP BY monat");
            ResultSet rs = ps.executeQuery();
            for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
                final int j = i;
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>, ObservableValue<String>>(){
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                        return new SimpleStringProperty(param.getValue().get(j).toString());
                    }
                });

                tableView.getColumns().addAll(col);
            }
            while(rs.next()){
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
                    row.add(rs.getString(i));
                }
                data.add(row);

            }

            tableView.setItems(data);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tableView;
    }

    public TableView showYearlyIncome(){
        TableView tableView = new TableView<>();
        tableView.setBackground(new Background(bground));
        ObservableList<ObservableList> data = FXCollections.observableArrayList();
        Connection conn = connect();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT strftime('%Y', datum) Jahr, SUM(preis) AS Verdienst FROM reservierung GROUP BY Jahr");
            ResultSet rs = ps.executeQuery();
            for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
                final int j = i;
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>, ObservableValue<String>>(){
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                        return new SimpleStringProperty(param.getValue().get(j).toString());
                    }
                });

                tableView.getColumns().addAll(col);
            }
            while(rs.next()){
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
                    row.add(rs.getString(i));
                }
                data.add(row);

            }

            tableView.setItems(data);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tableView;
    }

    public boolean loginCheck(int id, String pass){
        Connection conn = connect();
        PreparedStatement ps = null;
        ResultSet rs;
        ResultSet rs2;
        try {
            if(String.valueOf(id).length() == 4){
                ps = conn.prepareStatement("SELECT * FROM administrator WHERE id = " + id);
                rs = ps.executeQuery();
                if(rs.getString(4).equals(pass)){
                    conn.close();
                    return true;
                } else {
                    conn.close();
                    return false;
                }
            } else if(String.valueOf(id).length() == 3){
                ps = conn.prepareStatement("SELECT * FROM mitarbeiter WHERE id = " + id);
                rs2 = ps.executeQuery();
                if(rs2.getString(4).equals(pass)){
                    conn.close();
                    return true;
                } else {
                    conn.close();
                    return false;
                }
            }
            return false;
        } catch (SQLException e){
            e.printStackTrace();
        }

        return false;
    }

}