package main;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.StageStyle;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login extends Application{

    Scene loginScene, errorScene, logoutScene, adminScene, mitarbeiterScene;
    Verbindung DBVerbindung = new Verbindung();
    addDataScene addScene = new addDataScene();

    @Override
    public void start(Stage stage) throws Exception {
        //loginScene
        Label kontoID = new Label("Konto ID");
        Label kontoPasswort = new Label("Passwort");
        TextField tf1 = new TextField();
        PasswordField tf2 = new PasswordField();
        Button einloggen = new Button("Einloggen");

        GridPane gp = new GridPane();
        gp.setAlignment(Pos.CENTER);
        gp.setHgap(10);
        gp.setVgap(10);
        gp.setPadding(new Insets(25,25,25,25));

        gp.addRow(0,kontoID,tf1);
        gp.addRow(1,kontoPasswort,tf2);
        gp.addRow(2,einloggen);

        BackgroundImage bg = new BackgroundImage(new Image("C:/Users/PC/Desktop/bluebg.jpg",1970,
                605, false, true), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        gp.setBackground(new Background(bg));

        loginScene = new Scene(gp, 300, 275);

        //errorScene
        Label text = new Label("Falsche ID oder Passwort. Bitte überprüfen Sie Ihre Eingaben.");

        GridPane gpw = new GridPane();
        gpw.setAlignment(Pos.CENTER);
        gpw.setHgap(10);
        gpw.setVgap(10);
        gpw.setPadding(new Insets(25,25,25,25));

        gpw.addRow(0, text);

        errorScene = new Scene(gpw, 400, 75);

        //adminScene
        Image image = new Image("C:\\Users\\PC\\Desktop\\exit.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(30);
        imageView.setFitWidth(30);
        Button ausloggen = new Button("",imageView);
        ausloggen.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                addScene.logoutScene(stage, loginScene);
            }
        });


        HBox hbox = new HBox();
        hbox.setAlignment(Pos.BOTTOM_RIGHT);
        hbox.setPadding(new Insets(25));
        hbox.getChildren().addAll(ausloggen);

        BorderPane bp = new BorderPane();
        bp.setBottom(hbox);

        adminScene = new Scene(bp, 800, 600);
        MenuBar menuBar = new MenuBar();



        Menu addMenu = new Menu("Neu");
        MenuItem administrator = new MenuItem("Administratorkonto erstellen");
        administrator.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DBVerbindung.addAdmin(stage);
            }
        });
        MenuItem mitarbeiter = new MenuItem("Mitarbeiterkonto erstellen");
        mitarbeiter.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DBVerbindung.addMitarbeiter(stage);
            }
        });
        addMenu.getItems().addAll(administrator, mitarbeiter);

        Menu editMenu = new Menu("Bearbeiten");
        MenuItem administrator1 = new MenuItem("Administratorkonto bearbeiten");
        administrator1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DBVerbindung.editAdministrator(stage);
            }
        });
        MenuItem mitarbeiter1 = new MenuItem("Mitarbeiterkonto bearbeiten");
        mitarbeiter1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DBVerbindung.editMitarbeiter(stage);
            }
        });
        editMenu.getItems().addAll(administrator1,mitarbeiter1);

        Menu deleteMenu = new Menu("Löschen");
        MenuItem administrator2 = new MenuItem("Administratorkonto löschen");
        administrator2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DBVerbindung.deleteAdmin(stage);
            }
        });
        MenuItem mitarbeiter2 = new MenuItem("Mitarbeiterkonto löschen");
        mitarbeiter2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DBVerbindung.deleteMitarbeiter(stage);
            }
        });
        deleteMenu.getItems().addAll(administrator2, mitarbeiter2);

        Menu data = new Menu("Daten");
        MenuItem adminKonten = new MenuItem("Administratorkonten");
        adminKonten.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                BorderPane bp = new BorderPane();
                bp.setCenter(DBVerbindung.getAdministratoren());
                Scene tableScene = new Scene(bp, 800,600);

                Stage newStage = new Stage();

                newStage.setTitle("Administratoren");
                newStage.setScene(tableScene);
                newStage.setX(stage.getX() + 200);
                newStage.setY(stage.getY() + 100);
                newStage.setResizable(false);
                newStage.show();
            }
        });
        MenuItem mitKonten = new MenuItem("Mitarbeiterkonten");
        mitKonten.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                BorderPane bp = new BorderPane();
                bp.setCenter(DBVerbindung.getMitarbeitern());
                Scene tableScene = new Scene(bp, 800,600);

                Stage newStage = new Stage();

                newStage.setTitle("Mitarbeitern");
                newStage.setScene(tableScene);
                newStage.setX(stage.getX() + 200);
                newStage.setY(stage.getY() + 100);
                newStage.setResizable(false);
                newStage.show();
            }
        });
        MenuItem kunden = new MenuItem("Kunden");
        kunden.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                BorderPane bp = new BorderPane();
                bp.setCenter(DBVerbindung.getKunden());
                Scene tableScene = new Scene(bp, 800,600);

                Stage newStage = new Stage();

                newStage.setTitle("Kunden");
                newStage.setScene(tableScene);
                newStage.setX(stage.getX() + 200);
                newStage.setY(stage.getY() + 100);
                newStage.setResizable(false);
                newStage.show();
            }
        });
        MenuItem rechnungen = new MenuItem("Rechnungen");
        rechnungen.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                BorderPane bp = new BorderPane();
                bp.setCenter(DBVerbindung.getRechnungen());
                Scene tableScene = new Scene(bp, 800,600);

                Stage newStage = new Stage();

                newStage.setTitle("Rechnungen");
                newStage.setScene(tableScene);
                newStage.setX(stage.getX() + 200);
                newStage.setY(stage.getY() + 100);
                newStage.setResizable(false);
                newStage.show();
            }
        });
        MenuItem reservierungen = new MenuItem("Reservierungen");
        reservierungen.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                BorderPane bp = new BorderPane();
                bp.setCenter(DBVerbindung.getReservierungen());
                Scene tableScene = new Scene(bp, 800,600);

                Stage newStage = new Stage();

                newStage.setTitle("Reservierungen");
                newStage.setScene(tableScene);
                newStage.setX(stage.getX() + 200);
                newStage.setY(stage.getY() + 100);
                newStage.setResizable(false);
                newStage.show();
            }
        });
        MenuItem firmen = new MenuItem("Firmen");
        firmen.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                BorderPane bp = new BorderPane();
                bp.setCenter(DBVerbindung.getFirmen());
                Scene tableScene = new Scene(bp, 800,600);

                Stage newStage = new Stage();

                newStage.setTitle("Firmen");
                newStage.setScene(tableScene);
                newStage.setX(stage.getX() + 200);
                newStage.setY(stage.getY() + 100);
                newStage.setResizable(false);
                newStage.show();
            }
        });
        MenuItem veranstaltungen = new MenuItem("Veranstaltungen");
        veranstaltungen.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                BorderPane bp = new BorderPane();
                bp.setCenter(DBVerbindung.getVeranstaltungen());
                Scene tableScene = new Scene(bp, 800,600);

                Stage newStage = new Stage();

                newStage.setTitle("Veranstaltungen");
                newStage.setScene(tableScene);
                newStage.setX(stage.getX() + 200);
                newStage.setY(stage.getY() + 100);
                newStage.setResizable(false);
                newStage.show();
            }
        });
        data.getItems().addAll(adminKonten, mitKonten, kunden, rechnungen, reservierungen, firmen, veranstaltungen);

        Menu GVStatus = new Menu("GV-Status");
        MenuItem monat = new MenuItem("Monatlich");
        monat.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                BorderPane bp = new BorderPane();
                bp.setCenter(DBVerbindung.showMonthlyIncome());
                Scene tableScene = new Scene(bp, 800,600);

                Stage newStage = new Stage();

                newStage.setTitle("Gewinn(monatlich)");
                newStage.setScene(tableScene);
                newStage.setX(stage.getX() + 200);
                newStage.setY(stage.getY() + 100);
                newStage.setResizable(false);
                newStage.show();
            }
        });
        MenuItem jahr = new MenuItem("Jährlich");
        jahr.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                BorderPane bp = new BorderPane();
                bp.setCenter(DBVerbindung.showYearlyIncome());
                Scene tableScene = new Scene(bp, 800,600);

                Stage newStage = new Stage();

                newStage.setTitle("Gewinn(jährlich)");
                newStage.setScene(tableScene);
                newStage.setX(stage.getX() + 200);
                newStage.setY(stage.getY() + 100);
                newStage.setResizable(false);
                newStage.show();
            }
        });
        GVStatus.getItems().addAll(monat,jahr);

        bp.setTop(menuBar);
        menuBar.getMenus().addAll(addMenu, editMenu, deleteMenu, GVStatus, data);
        bp.setBackground(new Background(bg));

        //mitarbeiterScene
        Button ausloggen2 = new Button("",imageView);
        ausloggen2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                addScene.logoutScene(stage, loginScene);
            }
        });

        HBox hbox2 = new HBox();
        hbox2.setAlignment(Pos.BOTTOM_RIGHT);
        hbox2.setPadding(new Insets(25));
        hbox2.getChildren().addAll(ausloggen2);
        BorderPane bp2 = new BorderPane();
        bp2.setBottom(hbox2);
        mitarbeiterScene = new Scene(bp2, 800, 600);

        MenuBar menuBarM = new MenuBar();

        Menu addMenuM = new Menu("Neu");
        MenuItem kundeM = new MenuItem("Kunde erstellen");
        kundeM.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DBVerbindung.addKunde(stage);
            }
        });
        MenuItem rechnungM = new MenuItem("Rechnung erstellen");
        rechnungM.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DBVerbindung.addRechnung(stage);
            }
        });
        MenuItem reservierungM = new MenuItem("Reservierung erstellen");
        reservierungM.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DBVerbindung.addReservierung(stage);
            }
        });
        MenuItem firmaM = new MenuItem("Firma erstellen");
        firmaM.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DBVerbindung.addFirma(stage);
            }
        });
        MenuItem veranstaltungM = new MenuItem("Veranstaltung erstellen");
        veranstaltungM.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DBVerbindung.addVeranstaltung(stage);
            }
        });
        addMenuM.getItems().addAll(kundeM,rechnungM,reservierungM,firmaM,veranstaltungM);

        Menu editMenuM = new Menu("Bearbeiten");
        MenuItem kundeM1 = new MenuItem("Kunde bearbeiten");
        kundeM1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DBVerbindung.editKunde(stage);
            }
        });
        MenuItem rechnungM1 = new MenuItem("Rechnung bearbeiten");
        rechnungM1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DBVerbindung.editRechnung(stage);
            }
        });
        MenuItem reservierungM1 = new MenuItem("Reservierung bearbeiten");
        reservierungM1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DBVerbindung.editReservierung(stage);
            }
        });
        MenuItem firmaM1 = new MenuItem("Firma bearbeiten");
        firmaM1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DBVerbindung.editFirma(stage);
            }
        });
        MenuItem veranstaltungM1 = new MenuItem("Veranstaltung bearbeiten");
        veranstaltungM1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DBVerbindung.editVeranstaltung(stage);
            }
        });
        editMenuM.getItems().addAll(kundeM1,rechnungM1,reservierungM1,firmaM1,veranstaltungM1);

        Menu deleteMenuM = new Menu("Löschen");
        MenuItem kundeM2 = new MenuItem("Kunde löschen");
        kundeM2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DBVerbindung.deleteKunde(stage);
            }
        });
        MenuItem rechnungM2 = new MenuItem("Rechnung löschen");
        rechnungM2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DBVerbindung.deleteRechnung(stage);
            }
        });
        MenuItem reservierungM2 = new MenuItem("Reservierung löschen");
        reservierungM2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DBVerbindung.deleteReservierung(stage);
            }
        });
        MenuItem firmaM2 = new MenuItem("Firma löschen");
        firmaM2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DBVerbindung.deleteFirma(stage);
            }
        });
        MenuItem veranstaltungM2 = new MenuItem("Veranstaltung löschen");
        veranstaltungM2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DBVerbindung.deleteVeranstaltung(stage);
            }
        });
        deleteMenuM.getItems().addAll(kundeM2,rechnungM2,reservierungM2,firmaM2,veranstaltungM2);

        Menu dataM = new Menu("Daten");
        MenuItem kundeM3 = new MenuItem("Kunden");
        kundeM3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                BorderPane bp = new BorderPane();
                bp.setCenter(DBVerbindung.getKunden());
                Scene tableScene = new Scene(bp, 800,600);

                Stage newStage = new Stage();

                newStage.setTitle("Kunden");
                newStage.setScene(tableScene);
                newStage.setX(stage.getX() + 200);
                newStage.setY(stage.getY() + 100);
                newStage.setResizable(false);
                newStage.show();
            }
        });
        MenuItem rechnungM3 = new MenuItem("Rechnungen");
        rechnungM3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                BorderPane bp = new BorderPane();
                bp.setCenter(DBVerbindung.getRechnungen());
                Scene tableScene = new Scene(bp, 800,600);

                Stage newStage = new Stage();

                newStage.setTitle("Rechnungen");
                newStage.setScene(tableScene);
                newStage.setX(stage.getX() + 200);
                newStage.setY(stage.getY() + 100);
                newStage.setResizable(false);
                newStage.show();
            }
        });
        MenuItem reservierungM3 = new MenuItem("Reservierungen");
        reservierungM3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                BorderPane bp = new BorderPane();
                bp.setCenter(DBVerbindung.getReservierungen());
                Scene tableScene = new Scene(bp, 800,600);

                Stage newStage = new Stage();

                newStage.setTitle("Reservierungen");
                newStage.setScene(tableScene);
                newStage.setX(stage.getX() + 200);
                newStage.setY(stage.getY() + 100);
                newStage.setResizable(false);
                newStage.show();
            }
        });
        MenuItem firmaM3 = new MenuItem("Firmen");
        firmaM3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                BorderPane bp = new BorderPane();
                bp.setCenter(DBVerbindung.getFirmen());
                Scene tableScene = new Scene(bp, 800,600);

                Stage newStage = new Stage();

                newStage.setTitle("Firmen");
                newStage.setScene(tableScene);
                newStage.setX(stage.getX() + 200);
                newStage.setY(stage.getY() + 100);
                newStage.setResizable(false);
                newStage.show();
            }
        });
        MenuItem veranstaltungM3 = new MenuItem("Veranstaltungen");
        veranstaltungM3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                BorderPane bp = new BorderPane();
                bp.setCenter(DBVerbindung.getVeranstaltungen());
                Scene tableScene = new Scene(bp, 800,600);

                Stage newStage = new Stage();

                newStage.setTitle("Veranstaltungen");
                newStage.setScene(tableScene);
                newStage.setX(stage.getX() + 200);
                newStage.setY(stage.getY() + 100);
                newStage.setResizable(false);
                newStage.show();
            }
        });
        dataM.getItems().addAll(kundeM3,rechnungM3,reservierungM3,firmaM3,veranstaltungM3);

        bp2.setTop(menuBarM);
        menuBarM.getMenus().addAll(addMenuM, editMenuM, deleteMenuM, GVStatus, dataM);
        bp2.setBackground(new Background(bg));

        einloggen.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                int id = Integer.parseInt(tf1.getText());
                if(DBVerbindung.loginCheck(id, tf2.getText())){
                    if(String.valueOf(id).length() == 4){
                        stage.setScene(adminScene);
                        stage.setTitle("TauTour (Administrator)");
                    }else{
                        stage.setScene(mitarbeiterScene);
                        stage.setTitle("TauTour (Mitarbeiter)");
                    }
                } else {
                    addScene.falseInputError();
                }
            }
        });

        stage.setScene(loginScene);
        stage.setTitle("TauTour");
        stage.setResizable(false);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
