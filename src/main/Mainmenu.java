package main;
import javafx.animation.Animation;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;

public class Mainmenu extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Button btn1 = new Button("Konto hinzufügen");
        btn1.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                // TODO Auto-generated method stub
                System.out.println("Wählen Sie bitte die Rolle der Konto");
            }
        });
        ;
        StackPane root = new StackPane();
        root.getChildren().add(btn1);
        Scene scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        stage.setTitle("TauTour");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
