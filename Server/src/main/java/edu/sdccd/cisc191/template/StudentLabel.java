package edu.sdccd.cisc191.template;

import javafx.geometry.Insets;
import javafx.scene.control.Label;


/**
 * Extends the basic JavaFX Label with game functionality
 */
public class StudentLabel extends Label {
    public static Insets LABEL_PADDING = new Insets(20);
    public static int DIMENSION = 6;
    private int row;
    private int col;

    public StudentLabel() {
        // sets padding for labels
        setPadding(LABEL_PADDING);
        this.row = row;
        this.col = col;
        //sets default preferred height and width and default text
        setPrefHeight(100);
        setPrefWidth(100);
        setText(" ");

    }


}