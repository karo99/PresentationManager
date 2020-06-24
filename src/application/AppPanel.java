package application;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;

public class AppPanel {

    public Scene createScene(){
        GridPane grid = new GridPane();
        Scene scene = new Scene(grid, 800, 600);
        return scene;
    }
}
