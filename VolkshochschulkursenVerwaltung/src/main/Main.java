package main;

import gui.KursControl;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        new KursControl(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
