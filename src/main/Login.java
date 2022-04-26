package main;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import javax.swing.*;

public class Login extends Application{
    @Override
    public void start(Stage stage) throws Exception {
        Label kontoID = new Label("Konto ID");
        Label kontoPasswort = new Label("Passwort");
        TextField tf1 = new TextField();
        PasswordField tf2 = new PasswordField();

        Button einloggen = new Button("Einloggen");
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(10);
        root.setPadding(new Insets(25,25,25,25));

        Scene scene = new Scene(root, 300, 275);

        root.addRow(0,kontoID,tf1);
        root.addRow(1,kontoPasswort,tf2);
        root.addRow(2,einloggen);

        stage.setScene(scene);
        stage.setTitle("TauTour");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
