package application.dialogs;

import application.Checkpoint;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class DetailsDialog {
    public static void showDialog(Checkpoint checkpoint){
        Stage stage = new Stage();

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20,20,20,20));
        grid.setVgap(10);
        grid.setHgap(20);

        Label labelTitle = new Label(checkpoint.getTitle());
        GridPane.setConstraints(labelTitle,0,0);

        Label labelDescription = new Label(checkpoint.getDescription());
        GridPane.setConstraints(labelDescription,0,1);

        Button buttonClose = new Button("Close");
        GridPane.setConstraints(buttonClose,0,2);

        buttonClose.setOnAction(event -> {

            stage.close();
        });

        grid.getChildren().addAll(labelTitle,labelDescription,buttonClose);



        Scene scene = new Scene(grid,200,200);
        stage.setScene(scene);
        stage.showAndWait();
    }
}
