package application;

import application.dialogs.AddStepDialog;
import application.dialogs.DetailsDialog;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class AppPanel {

    public Scene createScene(){
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(0,0,20,0));
        grid.setVgap(10);
        grid.setHgap(20);

        Button buttonOpen = new Button("Open file");
        GridPane.setConstraints(buttonOpen,1,3);

        Button buttonAddStep = new Button("Add step");
        Button buttonDetails = new Button("Check details");
        Button buttonRemoveStep = new Button("Remove step");

        HBox checkpointBox = new HBox(5);
        checkpointBox.getChildren().addAll(buttonAddStep,buttonDetails,buttonRemoveStep);
        GridPane.setConstraints(checkpointBox,3,3);

        Label labelFiles = new Label("List of your files");
        GridPane.setConstraints(labelFiles,1,1);

        Label labelCheckpoints = new Label("List of your checkpoints");
        GridPane.setConstraints(labelCheckpoints,3,1);

        ListView listViewFiles = new ListView();
        GridPane.setConstraints(listViewFiles,1,2);

        ListView listViewCheckpoints = new ListView();
        GridPane.setConstraints(listViewCheckpoints,3,2);

        MenuBar menuBar = new MenuBar();
        Menu menuFile = new Menu("File");
        Menu menuInfo = new Menu("Info");

        MenuItem open = new MenuItem("Open");
        menuFile.getItems().add(open);

        MenuItem about = new MenuItem("About");
        menuInfo.getItems().add(about);

        menuBar.getMenus().addAll(menuFile,menuInfo);
        GridPane.setConstraints(menuBar,0,0,5,1);

        buttonAddStep.setOnAction(event -> {
            AddStepDialog.showDialog();
        });

        buttonDetails.setOnAction(event -> {
            DetailsDialog.showDialog();
        });


        grid.getChildren().addAll(buttonOpen,listViewFiles,listViewCheckpoints,labelFiles,labelCheckpoints,
                checkpointBox, menuBar);
        Scene scene = new Scene(grid, 630, 550);
        return scene;
    }
}
