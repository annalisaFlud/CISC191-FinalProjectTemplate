
package edu.sdccd.cisc191.template;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

//creates class for app
public class VisualDesign extends javafx.application.Application {
    //fields needed for stage, canvas, and to access methods from class model
    private Stage primaryStage;
    private Canvas grid;
    private ClassModel classModel;

    public static void main(String[] args) {
        // launches app
        javafx.application.Application.launch(args);
    }

    @Override
    //start method defines spacing and gridlines
    public void start(Stage primaryStage) throws Exception {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        classModel = new ClassModel();

        Scene scene = new Scene(grid, 300, 275);
        primaryStage.setScene(scene);

        //creates index and input boxes user can input values into to perform methods
        TextField textFieldIndex = new TextField ();
        TextField textFieldInput = new TextField ();
        Label inputLabel = new Label();
        Label inputIndex = new Label();
        inputIndex.setText("Index: ");
        inputLabel.setText("Input: ");
        textFieldIndex.setText("index");
        textFieldInput.setText("input");


        Label output = new Label();
        output.setText("Output");

        //button to find the student that is at a certain index in the list
        Button btn = new Button();
        btn.setText("Find student at __ position");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String value;
                try {
                    value = classModel.getAtIndex(Integer.valueOf(textFieldIndex.getText()));
                } catch (Exception e){
                    value = "index invalid";
                }
                output.setText(value);
            }
        });

        //button to add student given index and name
        Button btn1 = new Button();
        btn1.setText("Add student");
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String value;
                try {
                    value = classModel.setAtIndex(Integer.valueOf(textFieldIndex.getText()), textFieldInput.getText());
                } catch (Exception e){
                    value = "index or input invalid";
                }
                output.setText(value);
            }
        });

        //button to find index given name string
        Button btn2 = new Button();
        btn2.setText("Find position of given student");
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String value;
                try {
                    value = String.valueOf(classModel.findIndexOf(textFieldInput.getText()));
                } catch (Exception e){
                    value = "input invalid";
                }
                output.setText("found at position: " + value);
            }
        });

        //button to show all of the students in the class
        Button btn3 = new Button();
        btn3.setText("Class roster");
        btn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String value;
                try {
                    value = classModel.toString();
                } catch (Exception e){
                    value = "toString error";
                }
                output.setText(value);
            }
        });

        //removes student at any order in the list given the index
        Button btn5 = new Button();
        btn5.setText("remove student");
        btn5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String value;
                try {
                    value = classModel.deleteAtIndex(Integer.valueOf(textFieldIndex.getText()));
                } catch (Exception e){
                    value = "index or invalid";
                }
                output.setText("student removed at: " + Integer.valueOf(textFieldIndex.getText()));
            }
        });

        //expands class size by one
        Button btn4 = new Button();
        btn4.setText("expand class size");
        btn4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String value;
                try {
                    value = Integer.toString(classModel.expand());
                } catch (Exception e){
                    value = "index invalid";
                }
                output.setText("class size: " + String.valueOf(Integer.valueOf(classModel.getClassSize())));
            }
        });

        //decreases class size by one
        Button btn6 = new Button();
        btn6.setText("shrink class size");
        btn6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String value;
                try {
                    value = Integer.toString(classModel.shrink());
                } catch (Exception e){
                    value = "index invalid";
                }
                output.setText("class size: " + String.valueOf(Integer.valueOf(classModel.getClassSize())));
            }
        });

        //adds labels as well as buttons to the display
        grid.add(inputIndex,0,0);
        grid.add(inputLabel,0,1);
        grid.add(textFieldIndex,1,0);
        grid.add(textFieldInput,1,1);
        grid.add(btn,0,2);
        grid.add(btn1,0,3);
        grid.add(btn2,0,4);
        grid.add(btn3,1,2);
        grid.add(btn4,1,3);
        grid.add(btn5,1,4);
        grid.add(btn6,0,5);
        grid.add(output,1,5);

        //shows all of the contents
        primaryStage.show();
    }
}
