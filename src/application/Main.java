package application;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Presentation Manager");
        AppPanel panel = new AppPanel();
        primaryStage.setScene(panel.createScene());
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
