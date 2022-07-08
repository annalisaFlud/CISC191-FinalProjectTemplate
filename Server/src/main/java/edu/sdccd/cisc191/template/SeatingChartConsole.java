package edu.sdccd.cisc191.template;

import java.util.Arrays;
import java.util.Scanner;

public class SeatingChartConsole {
    //create main method
    public static void main(String[] args){
        SeatingChartModel seatingChartModel = new SeatingChartModel();
        //request user input from console class
        Scanner inputScanner = new Scanner(System.in);

        //as long as the user does not quit, print and if else statements execute
        boolean quit = false;
        while (!quit) {
            System.out.println("What command would you like to call on the array list commands:");
            System.out.println("current class size: " + seatingChartModel.getClassSize());
            System.out.println("Commands are: getAtIndex, setAtIndex, findIndexOf, printAll, deleteAtIndex, expand, shrink, quit");

            //TODO : getAtIndex, setAtIndex, findIndexOf, printAll, deleteAtIndex, expand, shrink)
            String command = inputScanner.next();  // Read user input
            //if else statements based on input and execute appropriate method
            if (command.equals("getAtIndex")){
                System.out.println("What index would you like to get?");
                int indexX = inputScanner.nextInt();
                int indexY = inputScanner.nextInt();
                try {
                    String atIndex = seatingChartModel.getAtIndex(indexX, indexY);
                    System.out.println(atIndex);
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("index out of bounds");
                }
            } else if (command.equals("setAtIndex")){
                System.out.println("What index would you like to set?");
                int indexX = inputScanner.nextInt();
                int indexY = inputScanner.nextInt();
                System.out.println("What string Value would you like to set it to?");
                String input = inputScanner.next();
                try {
                    String setAtIndex = seatingChartModel.setAtIndex(indexX, indexY, input);
                    System.out.println("value set to " + setAtIndex);
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("index out of bounds");
                }
            }
            else if (command.equals("findIndexOf")){
                System.out.println("What student would you like to find the index of?");
                String student = inputScanner.next();
                int[] index = seatingChartModel.findIndexOf(student);
                System.out.println("index of " + student + " is " + index);
            }
            else if (command.equals("printAll")){
                System.out.println(seatingChartModel.toString());
            }
            else if (command.equals("deleteAtIndex")){
                System.out.println("What index would you like to delete?");
                int indexX = inputScanner.nextInt();
                int indexY = inputScanner.nextInt();
                try {
                    seatingChartModel.deleteAtIndex(indexX, indexY);
                    System.out.println("value deleted at " + indexX + "," +indexY);
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("index out of bounds");
                }
            }
            else if (command.equals("expand")){
                seatingChartModel.expand();
            }
            else if (command.equals("shrink")){
                seatingChartModel.shrink();
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


