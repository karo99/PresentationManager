package application;

import application.dialogs.AddStepDialog;
import application.dialogs.DetailsDialog;
import application.dialogs.InfoDialog;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;

public class AppPanel {
    public static ArrayList<Checkpoint> checkpointList = new ArrayList<Checkpoint>();
    private static ListView<String> listViewFiles;
    private static ListView<String>  listViewTitles;
    public static ArrayList<Presentation> presentationList = new ArrayList<Presentation>();

    public static void refreshListViewCheckpoints(){
        listViewTitles.getItems().clear();
        for(Checkpoint tempCheckpoint : checkpointList){
            listViewTitles.getItems().add(tempCheckpoint.getTitle());
        }
    }

    public static void saveCheckpointToPresentation() {
        presentationList.get(listViewFiles.getSelectionModel().getSelectedIndex()).updateCheckpointList(checkpointList);
    }

    public Scene createScene(Stage stage) {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(0, 0, 20, 0));
        grid.setVgap(10);
        grid.setHgap(20);

        Button buttonOpen = new Button("Open file");
        GridPane.setConstraints(buttonOpen, 1, 3);

        Button buttonAddStep = new Button("Add step");
        Button buttonDetails = new Button("Check details");
        Button buttonRemoveStep = new Button("Remove step");

        HBox checkpointBox = new HBox(5);
        checkpointBox.getChildren().addAll(buttonAddStep, buttonDetails, buttonRemoveStep);
        GridPane.setConstraints(checkpointBox, 3, 3);

        Label labelFiles = new Label("List of your files");
        GridPane.setConstraints(labelFiles, 1, 1);

        Label labelCheckpoints = new Label("List of your checkpoints");
        GridPane.setConstraints(labelCheckpoints, 3, 1);

        listViewFiles = new ListView<String>();
        GridPane.setConstraints(listViewFiles, 1, 2);

        listViewTitles = new ListView<String>();
        GridPane.setConstraints(listViewTitles, 3, 2);

        MenuBar menuBar = new MenuBar();
        Menu menuFile = new Menu("File");
        Menu menuInfo = new Menu("Info");

        MenuItem open = new MenuItem("Open");
        menuFile.getItems().add(open);

        MenuItem about = new MenuItem("About");
        menuInfo.getItems().add(about);

        menuBar.getMenus().addAll(menuFile, menuInfo);
        GridPane.setConstraints(menuBar, 0, 0, 5, 1);

        buttonAddStep.setOnAction(event -> {
            AddStepDialog.showDialog();
        });

        buttonDetails.setOnAction(event -> {
            DetailsDialog.showDialog(checkpointList.get(listViewTitles.getSelectionModel().getSelectedIndex()));
        });

        buttonOpen.setOnAction(event -> {
            openFiles(stage);
        });

        open.setOnAction(event1 -> {
            openFiles(stage);
        });

        about.setOnAction(event -> {
            InfoDialog.showDialog();
        });

        buttonRemoveStep.setOnAction(event -> {

            checkpointList.remove(listViewTitles.getSelectionModel().getSelectedIndex());
            refreshListViewCheckpoints();
        });

        listViewFiles.getSelectionModel().selectedItemProperty()
                .addListener(new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                        int number = listViewFiles.getSelectionModel().getSelectedIndex();
                        checkpointList = presentationList.get(number).getCheckpointList();
                        refreshListViewCheckpoints();
                    }

                });


        grid.getChildren().addAll(buttonOpen, listViewFiles, listViewTitles, labelFiles, labelCheckpoints,
                checkpointBox, menuBar);
        Scene scene = new Scene(grid, 630, 550);
        return scene;
    }

    public void openFiles(Stage stage) {
        DirectoryChooser chooser = new DirectoryChooser();
        chooser.setTitle("Choose your folder");
        File selectedDirectory = chooser.showDialog(stage);


        File[] files = selectedDirectory.listFiles();
        listViewFiles.getItems().clear();
        for (File file : files) {
            updateFileList(file);
        }
    }

    public void updateFileList(File file) {
        String directoryPath = file.getAbsolutePath();
//        System.out.println(directoryPath);
        String[] extension = directoryPath.split("\\.");
        if (extension[1].equals("pptx") || extension[1].equals("ppt")) {
            String[] name = directoryPath.split("\\\\");
            listViewFiles.getItems().add(name[name.length - 1]);
            Presentation presentation = new Presentation(name[name.length - 1]);
            presentationList.add(presentation);
        }
    }

}
