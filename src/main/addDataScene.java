package main;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.util.Callback;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class addDataScene extends Application{

    @Override
    public void start(Stage stage) throws Exception {}

    public static void main(String[] args) {
        launch(args);
    }

    public void logoutScene(Stage stage, Scene loginScene){
        Scene logoutScene;

        Button change = new Button("Konto wechseln");
        Button logout = new Button("Abmelden");


        GridPane gpLogout = new GridPane();
        gpLogout.setAlignment(Pos.CENTER);
        gpLogout.setVgap(10);
        gpLogout.setHgap(10);
        gpLogout.setPadding(new Insets(25,25,25,25));
        gpLogout.addRow(0, change);
        gpLogout.addRow(1, logout);

        change.setAlignment(Pos.CENTER);
        logout.setAlignment(Pos.CENTER);

        BackgroundImage bgImage = new BackgroundImage(new Image("C:/Users/PC/Desktop/graybg.jpg",1970,
                605, false, true), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        gpLogout.setBackground(new Background(bgImage));

        logoutScene = new Scene(gpLogout, 350,150);

        Stage logoutStage = new Stage();
        logoutStage.setTitle("Abmeldung");
        logoutStage.setScene(logoutScene);
        logoutStage.initModality(Modality.WINDOW_MODAL);
        logoutStage.initOwner(stage);
        logoutStage.setX(stage.getX() - 50);
        logoutStage.setY(stage.getY() + 125);
        logoutStage.setResizable(false);
        logoutStage.show();

        change.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                logoutStage.close();
                stage.setScene(loginScene);
            }
        });

        logout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
    }

    public void falseInputError(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Falsche Eingabe");
        alert.setContentText("Bitte kontrollieren Sie Ihre Eingabe");

        alert.showAndWait();
    }
}
