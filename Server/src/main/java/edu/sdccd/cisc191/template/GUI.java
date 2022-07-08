
package edu.sdccd.cisc191.template;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class GUI extends Application {
    private Stage primaryStage;
    private Canvas grid;
    private StudentLabel studentName;

    public static void main(String[] args) {
        // launches app
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //create array of class list of names
        ArrayList<ArrayList<String>> classRoster = new ArrayList<ArrayList<String>>(4);
        ArrayList<String> row0 = new ArrayList<String>();
        ArrayList<String> row1 = new ArrayList<String>();
        row0.add("Andy");
        row0.add("Isa");
        row1.add("Bella");
        row1.add("Essie");
        classRoster.add(row0);
        classRoster.add(row1);
        new SeatingChartModel();

        // initializes gameCanvas with group, labels, and messages
        grid = new Canvas();
        Group group = new Group();
        studentName = new StudentLabel();
        // displays game with HBox and VBox.
        StudentLabel studentLabel = new StudentLabel();
        //creates horizontal rows
        HBox header = new HBox();
        header.getChildren().add(studentName);
        //creates vertical columns
        VBox columnContainer = new VBox(15);
        columnContainer.getChildren().add(header);
        for (int row = 0; row < grid.getWidth(); row++) {
            // creates row container
            HBox rowContainer = new HBox(15);
            for (int col = 0; col < grid.getWidth(); col++) {
                int finalRow = row;
                int finalCol = col;
            }
            // adds row to column
            columnContainer.getChildren().add(rowContainer);
        }
        // creates scene(graph), stage, title, and shows application
        group.getChildren().add(columnContainer);
        Scene scene = new Scene(group);
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Classroom Attendance");
        primaryStage.setScene(scene);
        primaryStage.show();


//        mainWindow();
    }
//    public void mainWindow(){
//        FXMLLoader loader = new FXMLLoader(GUI.class.getResource("/MainWindowView.fxml"));
//    }
}
