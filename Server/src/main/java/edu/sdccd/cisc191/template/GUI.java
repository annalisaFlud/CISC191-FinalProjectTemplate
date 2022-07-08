
package edu.sdccd.cisc191.template;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import jdk.internal.util.xml.impl.Input;

import java.util.ArrayList;

public class GUI extends Application {
    private Stage primaryStage;
    private Canvas grid;
    private ClassModel classModel;

    public static void main(String[] args) {
        // launches app
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        classModel = new ClassModel();

        Scene scene = new Scene(grid, 300, 275);
        primaryStage.setScene(scene);

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

        Button btn = new Button();
        btn.setText("getIndexAt'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String value;
                try {
                    value = classModel.getAtIndex(Integer.valueOf(textFieldIndex.getText()));
                } catch (Exception e){
                    value = "index invalid";
                }
                output.setText("getIndexAt: "+ value);
            }
        });

        Button btn1 = new Button();
        btn1.setText("setAtIndex'");
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

        Button btn2 = new Button();
        btn2.setText("findIndexOf'");
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String value;
                try {
                    value = String.valueOf(classModel.findIndexOf(textFieldInput.getText()));
                } catch (Exception e){
                    value = "input invalid";
                }
                output.setText(value);
            }
        });

        Button btn3 = new Button();
        btn3.setText("toString");
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

        Button btn5 = new Button();
        btn5.setText("deleteAtIndex'");
        btn5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String value;
                try {
                    value = classModel.deleteAtIndex(Integer.valueOf(textFieldIndex.getText()));
                } catch (Exception e){
                    value = "index or invalid";
                }
                output.setText(value);
            }
        });

        Button btn4 = new Button();
        btn4.setText("expand'");
        btn4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String value;
                try {
                    value = Integer.toString(classModel.expand());
                } catch (Exception e){
                    value = "index invalid";
                }
                output.setText(value);
            }
        });

        Button btn6 = new Button();
        btn6.setText("shrink'");
        btn6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String value;
                try {
                    value = Integer.toString(classModel.shrink());
                } catch (Exception e){
                    value = "index invalid";
                }
                output.setText(value);
            }
        });

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


        primaryStage.show();
//        mainWindow();
    }
//    public void mainWindow(){
//        FXMLLoader loader = new FXMLLoader(GUI.class.getResource("/MainWindowView.fxml"));
//    }
}
