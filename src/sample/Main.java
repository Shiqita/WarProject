package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{


        Parent content = FXMLLoader.load(getClass().getResource("WarScene.fxml"));
        Scene scene = new Scene(content, 1082, 720);

        primaryStage.setTitle("Модель гражданской войны");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
