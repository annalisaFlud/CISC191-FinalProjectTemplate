package edu.sdccd.cisc191.template;

import java.util.Arrays;
import java.util.Scanner;

public class Console {

    //create main method
    public static void main(String[] args){
        ClassModel classModel = new ClassModel();
        //request user input from console class
        Scanner inputScanner = new Scanner(System.in);
        boolean quit = false;
        while (!quit) {
            System.out.println("What command would you like to call on the array list commands:");
            System.out.println("current class size: " + classModel.getClassSize());
            System.out.println("Commands are: getAtIndex, setAtIndex, findIndexOf, printAll, deleteAtIndex, expand, shrink, quit");

            //TODO : getAtIndex, setAtIndex, findIndexOf, printAll, deleteAtIndex, expand, shrink)
            String command = inputScanner.next();  // Read user input
            //if else statements based on input and execute appropriate method
            if (command.equals("getAtIndex")){
                System.out.println("What index would you like to get?");
                int index = inputScanner.nextInt();
                try {
                    String atIndex = classModel.getAtIndex(index);
                    System.out.println(atIndex);
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("index out of bounds");
                }
            } else if (command.equals("setAtIndex")){
                System.out.println("What index would you like to set?");
                int index = inputScanner.nextInt();
                System.out.println("What string Value would you like to set it to?");
                String input = inputScanner.next();
                try {
                    String setAtIndex = classModel.setAtIndex(index,input);
                    System.out.println("value set to " + setAtIndex);
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("index out of bounds");
                }
            }
            else if (command.equals("findIndexOf")){
                System.out.println("What student would you like to find the index of?");
                String student = inputScanner.next();
                int index = classModel.findIndexOf(student);
                System.out.println("index of " + student + " is " + index);
            }
            else if (command.equals("printAll")){
                System.out.println(classModel.toString());
            }
            else if (command.equals("deleteAtIndex")){
                System.out.println("What index would you like to delete?");
                int index = inputScanner.nextInt();
                try {
                    classModel.deleteAtIndex(index);
                    System.out.println("value deleted at " + index);
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("index out of bounds");
                }
            }
            else if (command.equals("expand")){
                classModel.expand();
            }
            else if (command.equals("shrink")){
                classModel.shrink();
            }
            else if (command.equals("quit")){
                quit = true;
            }
            else {
                System.out.println("Not a valid input, please choose from the list of commands");
            }

        }
        System.out.println("program quit");
    }


}
