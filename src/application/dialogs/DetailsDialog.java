package application.dialogs;

import application.Checkpoint;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
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
        labelTitle.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
        labelTitle.setWrapText(true);

        Label labelDescription = new Label(checkpoint.getDescription());
        GridPane.setConstraints(labelDescription,0,1);
        labelDescription.setWrapText(true);
        labelDescription.setTextAlignment(TextAlignment.JUSTIFY);

        Button buttonClose = new Button("Close");
        GridPane.setConstraints(buttonClose,0,2);

        buttonClose.setOnAction(event -> {
            stage.close();
        });

        VBox vBoxDetails = new VBox(10);
        vBoxDetails.getChildren().addAll(labelTitle,labelDescription,buttonClose);
        vBoxDetails.setAlignment(Pos.CENTER);
        vBoxDetails.setMinWidth(260);
        vBoxDetails.setMaxWidth(270);

        grid.getChildren().addAll(vBoxDetails);

        Scene scene = new Scene(grid);
        stage.setTitle("Details");
        stage.setScene(scene);
        stage.showAndWait();
    }
}
