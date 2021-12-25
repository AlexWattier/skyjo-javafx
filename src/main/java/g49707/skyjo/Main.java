package g49707.skyjo;

import g49707.skyjo.controller.Controller;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {


        Stage stagePreview = new Stage();
        stagePreview.setTitle("Choix difficulter");
        VBox vBox =new VBox();
        HBox hBox = new HBox();
        Label text = new Label("Choix de la partie");
        Button buttonOne = new Button("client");
        buttonOne.setOnAction(actionEvent -> {new Controller(stage,1); stagePreview.close(); });
        Button buttonTwo = new Button("serveur");
        buttonTwo.setOnAction(actionEvent -> {new Controller(stage,2); stagePreview.close(); });
        hBox.getChildren().add(buttonOne);
        hBox.getChildren().add(buttonTwo);
        vBox.getChildren().add(text);
        vBox.setAlignment(Pos.CENTER);
        hBox.setAlignment(Pos.CENTER);
        vBox.getChildren().add(hBox);
        Scene scene1 = new Scene(vBox, 260, 80);
        stagePreview.setScene(scene1);
        stagePreview.show();




       //new Controller(stage,1);
    }
}