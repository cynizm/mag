package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
//        try {
//            BorderPane root = new BorderPane();
//            Scene scene = new Scene(root, 400, 400);
//            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//            primaryStage.setScene(scene);
//            primaryStage.show();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        Parent root = FXMLLoader.load(getClass().getResource("View/MainView.fxml"));
        primaryStage.setTitle("Data to DNA Converter");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
