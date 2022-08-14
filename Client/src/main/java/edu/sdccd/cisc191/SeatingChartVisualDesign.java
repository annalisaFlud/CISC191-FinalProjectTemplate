
package edu.sdccd.cisc191;

import edu.sdccd.cisc191.template.SeatingChartModel;
import edu.sdccd.cisc191.template.StudentUploadRequest;
import edu.sdccd.cisc191.template.StudentResponse;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

//creates class for app
public class SeatingChartVisualDesign extends javafx.application.Application {
    //fields needed for stage, canvas, and to access methods from class model
    private GridPane grid;
    private StudentUploadRequest test;
    private SeatingChartModel seatingChartModel;
    private Client client;
    public static void main(String[] args) {
        // launches app
        javafx.application.Application.launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        this.grid = new GridPane();
        //creates new client
        this.client = new Client();
        //client connects to server
        client.startConnection("127.0.0.1", 4444);
        //defines spacing and gridlines
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        seatingChartModel = new SeatingChartModel();


        //sets scene for app and makes the background
        Scene scene = new Scene(grid, 1000, 1000);
        //TODO THIS ISNT WORKING
        Color color = Color.RED;
        scene.setFill(color);
        primaryStage.setScene(scene);

        //creates index and input boxes user can input values into to perform methods
        TextField textFieldIndexX= new TextField ();
        TextField textFieldIndexY= new TextField ();
        TextField textFieldInput = new TextField ();
        Label inputLabel = new Label();
        Label inputIndex = new Label();
        inputIndex.setText("Index: ");
        inputLabel.setText("Input: ");
        textFieldIndexX.setText("X index");
        inputIndex.setFont(Font.font("verdana", FontWeight.SEMI_BOLD, FontPosture.REGULAR, 16));
        textFieldIndexY.setText("Y index");
        inputLabel.setFont(Font.font("verdana", FontWeight.SEMI_BOLD, FontPosture.REGULAR, 16));
        textFieldInput.setText("input");
        Label title = new Label();
        title.setText("Class and Seating Chart Tool");
        title.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 25));
        title.setTextFill(Color.DARKBLUE);

        //Output label
        Label output = new Label();
        output.setText("Output");

        //button to find the student that is at a certain index in the list
        Button btn = new Button();
        btn.setText("Find student at __ position");
        btn.setTextFill(Color.DARKBLUE);

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String value;
                try {
                    value = seatingChartModel.getAtIndex(Integer.valueOf(textFieldIndexX.getText()), Integer.valueOf(textFieldIndexY.getText()));
                } catch (Exception e){
                    value = "index invalid";
                }
                output.setText(value);
            }
        });

        //button to add student given index and name
        Button btn1 = new Button();
        btn1.setText("Add student");
        btn1.setTextFill(Color.DARKBLUE);
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String value;
                try {
                    value = seatingChartModel.setAtIndex(Integer.valueOf(textFieldIndexX.getText()), Integer.valueOf(textFieldIndexY.getText()), textFieldInput.getText());
                } catch (Exception e){
                    value = "index or input invalid";
                }
                output.setText(value);
            }
        });

        //button to find index given name string
        Button btn2 = new Button();
        btn2.setText("Find position of given student");
        btn2.setTextFill(Color.DARKBLUE);
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String value;
                try {
                    value = String.valueOf(seatingChartModel.findIndexOf(textFieldInput.getText()));
                } catch (Exception e){
                    value = "input invalid";
                }
                output.setText("found at position: " + value);
            }
        });

        //button to show all of the students in the class
        Button btn3 = new Button();
        btn3.setText("Class roster");
        btn3.setTextFill(Color.DARKBLUE);
        btn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String value;
                try {
                    value = seatingChartModel.toString();
                } catch (Exception e){
                    value = "toString error";
                }
                output.setText(value);
            }
        });

        //removes student at any order in the list given the index
        Button btn4 = new Button();
        btn4.setText("remove student");
        btn4.setTextFill(Color.DARKBLUE);
        btn4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String value;
                try {
                    seatingChartModel.deleteAtIndex(Integer.valueOf(textFieldIndexX.getText()), Integer.valueOf(textFieldIndexY.getText()));
                } catch (Exception e){
                    value = "invalid input";
                }
                output.setText("student removed at: " + Integer.valueOf(textFieldIndexX.getText()) + "," + textFieldIndexY.getText());
            }
        });

        //expands class size by one
        Button btn5 = new Button();
        btn5.setText("expand class size");
        btn5.setTextFill(Color.DARKBLUE);
        btn5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String value;
                try {
                    seatingChartModel.expand();
                } catch (Exception e){
                    value = "index invalid";
                }
                output.setText("class size: " + String.valueOf(Integer.valueOf(seatingChartModel.getClassSize())));
            }
        });

        //decreases class size by one
        Button btn6 = new Button();
        btn6.setText("shrink class size");
        btn6.setTextFill(Color.DARKBLUE);
        btn6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String value;
                try {
                    seatingChartModel.shrink();
                } catch (Exception e){
                    value = "index invalid";
                }
                output.setText("class size: " + String.valueOf(Integer.valueOf(seatingChartModel.getClassSize())));
            }
        });

        //MAKE CLASS SEATING CHART
        Button btn7 = new Button();

        btn7.setText("Make Random Seating Chart");
        btn7.setTextFill(Color.DARKBLUE);
        btn7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                seatingChartModel.shuffleSeatingChart();
                output.setText(seatingChartModel.toString());
            }
        });

        //inputs for database : student name, grade level, home address, home phone number
        TextField studentNameTextField = new TextField ();
        studentNameTextField.setText("Student Name");
        TextField gradeLevelTextField = new TextField ();
        gradeLevelTextField.setText("Grade Level");
        TextField homeAddressTextField = new TextField ();
        homeAddressTextField.setText("Home Address");
        TextField phoneNumberTextField = new TextField ();
        phoneNumberTextField.setText("Home Phone Number");
        //searches through student database by student name and returns one student that matches
        Button btn8 = new Button();

        btn8.setText("Search Database by name");
        btn8.setTextFill(Color.DARKBLUE);
        btn8.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    String response = client.sendRequest(studentNameTextField.getText()).toString();
                    System.out.println(response);
                    output.setText(response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        //buttons and labels for database interaction
        Button btn9 = new Button();
        Label databaseLabel = new Label();
        databaseLabel.setText("Student Database Search");
        databaseLabel.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 25));
        databaseLabel.setTextFill(Color.DARKBLUE);
        btn9.setText("upload student info into database");
        btn9.setTextFill(Color.DARKBLUE);


        //when button 9 is pressed a new student is saved into repository for database based on values in input box
        btn9.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    String response = client.sendUploadRequest(new StudentUploadRequest(studentNameTextField.getText(),
                            Integer.valueOf(gradeLevelTextField.getText()),homeAddressTextField.getText(), phoneNumberTextField.getText())).toString();
                    System.out.println(response);
                    output.setText(response);
                } catch(Exception e) {
                    e.printStackTrace();
                }
                output.setText(studentNameTextField.getText());
            }
        });


        //adds labels as well as buttons to the display
        grid.add(title, 0,0);
        grid.add(inputIndex,0,2);
        grid.add(inputLabel,0,3);
        grid.add(textFieldIndexX,1,2);
        grid.add(textFieldIndexY,2,2);
        grid.add(textFieldInput,1,3);
        grid.add(databaseLabel, 0,10);
        grid.add(studentNameTextField, 0,13);
        grid.add(gradeLevelTextField, 1,13);
        grid.add(homeAddressTextField, 2,13);
        grid.add(phoneNumberTextField, 3,13);

        grid.add(btn,0,4);
        grid.add(btn1,0,5);
        grid.add(btn2,0,6);
        grid.add(btn3,1,4);
        grid.add(btn4,1,5);
        grid.add(btn5,1,6);
        grid.add(btn6,0,7);
        grid.add(btn7,1,7);
        grid.add(btn8,1,12);
        grid.add(btn9,0,12);
        grid.add(output,1,8);

        //shows all of the contents
        primaryStage.show();
    }
}
