package edu.sdccd.cisc191.template;

import java.util.ArrayList;

//creates class called array model and declares an array as a field
public class ClassModel {
    private ArrayList<String> Array;

    //class model constructor, defaults to a size of 4
    public ClassModel() {
        this.Array = new ArrayList<String>();
        this.Array.add("");
        this.Array.add("");
        this.Array.add("");
        this.Array.add("");
    }

    //TODO : getAtIndex, setAtIndex, findIndexOf, printAll, deleteAtIndex, expand, shrink)
    public String getAtIndex(int index){
        return this.Array.get(index);
    }
    public String setAtIndex(int index, String input) throws IndexOutOfBoundsException{
        this.Array.set(index,input);
        return input;
    }
    public int findIndexOf(String input){
        return this.Array.indexOf(input);
    }
    @Override
    public String toString() {
        return this.Array.toString();
    }

    public String deleteAtIndex(int index) throws IndexOutOfBoundsException {
        this.Array.set(index,"");
        return null;
    }
    public int expand() {
        this.Array.add(null);
        return this.Array.size();
    }
    public int shrink() {
        if (this.Array.size() > 0) {
            this.Array.remove(this.Array.size() - 1);
            return this.Array.size();
        } else {
            return 0;
        }
    }

    public int getClassSize() {
        return Array.size();
    }

}