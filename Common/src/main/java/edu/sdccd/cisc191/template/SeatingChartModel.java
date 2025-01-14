package edu.sdccd.cisc191.template;

import java.util.ArrayList;
import java.util.Collections;

public class SeatingChartModel {
    private ArrayList<ArrayList<String>> Array;

    //class model constructor, defaults to a size of 4
    public SeatingChartModel() {
        this.Array = new ArrayList<ArrayList<String>>();
        ArrayList<String> row0 = new ArrayList<String>();
        ArrayList<String> row1 = new ArrayList<String>();
        row0.add("");
        row0.add("");
        row1.add("");
        row1.add("");
        this.Array.add(row0);
        this.Array.add(row1);
    }

    //TODO : getAtIndex, setAtIndex, findIndexOf, printAll, deleteAtIndex, expand, shrink, shuffle seating chart)
    public String getAtIndex(int xIndex, int yIndex) {
        return this.Array.get(xIndex).get(yIndex);
    }

    public String setAtIndex(int xIndex, int yIndex, String input) throws IndexOutOfBoundsException {
        this.Array.get(xIndex).set(yIndex, input);
        return input;
    }

    public String findIndexOf(String input) {
        int[] output = new int[2];
        output[0] = -1;
        output[1] = -1;
        for (int i = 0; i < this.Array.size(); i++) {
            if (this.Array.get(i).indexOf(input) != -1) {
                output[0] = i;
                output[1] = this.Array.get(i).indexOf(input);
                break;
            }
        }
        return Integer.valueOf(output[0]) + ", " + Integer.valueOf(output[1]);
    }

    public void deleteAtIndex(int xIndex, int yIndex) throws IndexOutOfBoundsException {
        this.Array.get(xIndex).set(yIndex, "");
    }

    public void expand() {
        ArrayList<String> newRow = new ArrayList<String>();
        for (int i = 0; i < this.getYDimension(); i++) {
            newRow.add("");
        }
        this.Array.add(newRow);
        for (ArrayList<String> row : this.Array) {
            row.add("");
        }
    }

    public void shrink() {
        this.Array.remove(this.Array.size() - 1);
        for (ArrayList<String> row : this.Array) {
            row.remove(row.size() - 1);
        }
    }

    public String toString() {
        return this.Array.toString();
    }

    public int getXDimension() {
        return this.Array.size();
    }

    public int getYDimension() {
        return this.Array.get(0).size();
    }

    public int getClassSize() {
        return this.Array.size();
    }

    public ArrayList<ArrayList<String>> shuffleSeatingChart() {
        Collections.shuffle(this.Array);
        return this.Array;
    }
}
