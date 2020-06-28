package application.dialogs;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class InfoDialog {
    public static void showDialog(){
        Stage stage = new Stage();

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20,20,20,20));
        grid.setVgap(10);
        grid.setHgap(20);

        Label labelAbout = new Label("This is an application which enables you" +
                "to manage your work at presentation - add your milestones to know " +
                "where exactly you ended your work.");
        GridPane.setConstraints(labelAbout,0,0);
        labelAbout.setWrapText(true);
        labelAbout.setTextAlignment(TextAlignment.JUSTIFY);

        Button buttonClose = new Button("Close");
        GridPane.setConstraints(buttonClose,0,2);

        VBox vBoxInfo = new VBox(10);
        vBoxInfo.getChildren().addAll(labelAbout,buttonClose);
        vBoxInfo.setAlignment(Pos.CENTER);
        vBoxInfo.setMinWidth(220);
        vBoxInfo.setMaxWidth(230);

        buttonClose.setOnAction(event -> {
            stage.close();
        });

        grid.getChildren().addAll(vBoxInfo);

        Scene scene = new Scene(grid);
        stage.setTitle("About");
        stage.setScene(scene);
        stage.showAndWait();
    }
}
