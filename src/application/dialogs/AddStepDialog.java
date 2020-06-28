package application.dialogs;

import application.AppPanel;
import application.Checkpoint;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class AddStepDialog {
    public static void showDialog(){
        Stage stage = new Stage();

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20,20,20,20));
        grid.setVgap(10);
        grid.setHgap(20);

        Label labelTitle = new Label("Title");
        GridPane.setConstraints(labelTitle,0,0);

        TextField textFieldTitle = new TextField();
        GridPane.setConstraints(textFieldTitle,1,0);

        Label labelDescription = new Label("Description");
        GridPane.setConstraints(labelDescription,0,1);

        TextField textFieldDescription = new TextField();
        GridPane.setConstraints(textFieldDescription,1,1);
        textFieldDescription.setMinHeight(60);

        Button buttonAdd = new Button("Add");
        HBox box = new HBox(5);
        box.getChildren().add(buttonAdd);
        GridPane.setConstraints(box,0,2,2,1);

        box.setAlignment(Pos.CENTER);

        buttonAdd.setOnAction(event -> {
            Checkpoint checkpoint = new Checkpoint(textFieldTitle.getText(),textFieldDescription.getText());
            //System.out.println(checkpoint.getTitle() + " " + checkpoint.getDescription());

            AppPanel.checkpointList.add(checkpoint);
            AppPanel.refreshListViewCheckpoints();
            AppPanel.saveCheckpointToPresentation();
            stage.close();
        });

        grid.getChildren().addAll(labelTitle,textFieldTitle,labelDescription,
                textFieldDescription,box);

        Scene scene = new Scene(grid,350,200);
        stage.setTitle("Add step");
        stage.setScene(scene);
        stage.showAndWait();
    }
}
