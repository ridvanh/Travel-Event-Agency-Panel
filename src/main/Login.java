package main;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Login extends Application{

    Scene loginScene, adminScene, mitarbeiterScene;
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

        //adminScene
        BorderPane bp = new BorderPane();
        adminScene = new Scene(bp, 800, 600);
        MenuBar menuBar = new MenuBar();

        Menu addMenu = new Menu("Neu");
        MenuItem administrator = new MenuItem("Administratorkonto erstellen");
        administrator.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                addScene.addAdmin(stage);
            }
        });
        MenuItem mitarbeiter = new MenuItem("Mitarbeiterkonto erstellen");
        mitarbeiter.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                addScene.addMitarbeiter(stage);
            }
        });
        addMenu.getItems().addAll(administrator, mitarbeiter);

        Menu editMenu = new Menu("Bearbeiten");
        MenuItem administrator1 = new MenuItem("Administratorkonto bearbeiten");
        administrator1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                addScene.editAdministrator(stage);
            }
        });
        MenuItem mitarbeiter1 = new MenuItem("Mitarbeiterkonto bearbeiten");
        mitarbeiter1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                addScene.editMitarbeiter(stage);
            }
        });
        editMenu.getItems().addAll(administrator1,mitarbeiter1);

        Menu deleteMenu = new Menu("Löschen");
        MenuItem administrator2 = new MenuItem("Administratorkonto löschen");
        administrator2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                addScene.deleteAdmin(stage);
            }
        });
        MenuItem mitarbeiter2 = new MenuItem("Mitarbeiterkonto löschen");
        mitarbeiter2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                addScene.deleteMitarbeiter(stage);
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
                newStage.show();
            }
        });
        data.getItems().addAll(adminKonten, mitKonten, kunden, rechnungen, reservierungen, firmen, veranstaltungen);

        Menu GVStatus = new Menu("GV-Status");
        MenuItem monat = new MenuItem("Monatlich");
        MenuItem jahr = new MenuItem("Jährlich");
        GVStatus.getItems().addAll(monat,jahr);

        Menu logout = new Menu("Ausloggen");
        MenuItem change = new MenuItem("Konto wechseln");
        change.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.setScene(loginScene);
            }
        });
        MenuItem exit = new MenuItem("Abschalten");
        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
        logout.getItems().addAll(change, exit);

        bp.setTop(menuBar);
        menuBar.getMenus().addAll(addMenu, editMenu, deleteMenu, GVStatus, data, logout);
        bp.setBackground(new Background(bg));

        //mitarbeiterScene
        BorderPane bp2 = new BorderPane();
        mitarbeiterScene = new Scene(bp2, 800, 600);

        MenuBar menuBarM = new MenuBar();

        Menu addMenuM = new Menu("Neu");
        MenuItem kundeM = new MenuItem("Kunde erstellen");
        kundeM.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                addScene.addKunde(stage);
            }
        });
        MenuItem rechnungM = new MenuItem("Rechnung erstellen");
        rechnungM.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                addScene.addRechnung(stage);
            }
        });
        MenuItem reservierungM = new MenuItem("Reservierung erstellen");
        reservierungM.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                addScene.addReservierung(stage);
            }
        });
        MenuItem firmaM = new MenuItem("Firma erstellen");
        firmaM.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                addScene.addFirma(stage);
            }
        });
        MenuItem veranstaltungM = new MenuItem("Veranstaltung erstellen");
        veranstaltungM.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                addScene.addVeranstaltung(stage);
            }
        });
        addMenuM.getItems().addAll(kundeM,rechnungM,reservierungM,firmaM,veranstaltungM);

        Menu editMenuM = new Menu("Bearbeiten");
        MenuItem kundeM1 = new MenuItem("Kunde bearbeiten");
        kundeM1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                addScene.editKunde(stage);
            }
        });
        MenuItem rechnungM1 = new MenuItem("Rechnung bearbeiten");
        rechnungM1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                addScene.editRechnung(stage);
            }
        });
        MenuItem reservierungM1 = new MenuItem("Reservierung bearbeiten");
        reservierungM1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                addScene.editReservierung(stage);
            }
        });
        MenuItem firmaM1 = new MenuItem("Firma bearbeiten");
        firmaM1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                addScene.editFirma(stage);
            }
        });
        MenuItem veranstaltungM1 = new MenuItem("Veranstaltung bearbeiten");
        veranstaltungM1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                addScene.editVeranstaltung(stage);
            }
        });
        editMenuM.getItems().addAll(kundeM1,rechnungM1,reservierungM1,firmaM1,veranstaltungM1);

        Menu deleteMenuM = new Menu("Löschen");
        MenuItem kundeM2 = new MenuItem("Kunde löschen");
        kundeM2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                addScene.deleteKunde(stage);
            }
        });
        MenuItem rechnungM2 = new MenuItem("Rechnung löschen");
        rechnungM2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                addScene.deleteRechnung(stage);
            }
        });
        MenuItem reservierungM2 = new MenuItem("Reservierung löschen");
        reservierungM2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                addScene.deleteReservierung(stage);
            }
        });
        MenuItem firmaM2 = new MenuItem("Firma löschen");
        firmaM2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                addScene.deleteFirma(stage);
            }
        });
        MenuItem veranstaltungM2 = new MenuItem("Veranstaltung löschen");
        veranstaltungM2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                addScene.deleteVeranstaltung(stage);
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
                newStage.show();
            }
        });
        dataM.getItems().addAll(kundeM3,rechnungM3,reservierungM3,firmaM3,veranstaltungM3);

        bp2.setTop(menuBarM);
        menuBarM.getMenus().addAll(addMenuM, editMenuM, deleteMenuM, dataM, logout);
        bp2.setBackground(new Background(bg));




        einloggen.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(tf1.getLength() == 4){
                    stage.setScene(adminScene);
                    stage.setTitle("TauTour(Administrator)");
                }else if(tf1.getLength() == 3){
                    stage.setScene(mitarbeiterScene);
                    stage.setTitle("TauTour(Mitarbeiter)");
                }else {
                    System.out.println("Falsche Eingabe!");
                }
            }
        });
        stage.setScene(loginScene);
        stage.setTitle("TauTour");
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
