package com.company;

import java.io.*;
import java.util.Scanner;

public class Main {

    private static final String filepath = "ListOfObjects.txt";


    public static void main(String[] args) {

        String choice = null;
        MyLinkedList<String> myLinkedList = null;
        Scanner in = new Scanner(System.in);

        System.out.println("<<<--- Welcome!--- >>>\n");

        do {
            System.out.print("MENU:" +
                    "\na. Create list." +
                    "\nb. Add element." +
                    "\nc. Delete element." +
                    "\nd. Check element." +
                    "\ne. Print list." +
                    "\nf. Write to file." +
                    "\ng. Read from file." +
                    "\nh. Exit." +
                    "\nDo choice: ");
            choice = in.nextLine();

            switch (choice) {
                case "a":
                    myLinkedList = new MyLinkedList<>();
                    System.out.println("List created.");
                    break;
                case "b":
                    System.out.print("Enter string which you want to add: ");
                    myLinkedList.add(in.nextLine());
                    System.out.println("String added.");
                    break;
                case "c":
                    System.out.print("Enter string which you want to delete: ");
                    if (myLinkedList.remove(in.nextLine())) {
                        System.out.println("Element deleted.");
                    } else {
                        System.out.println("List haven't got element.");
                    }
                    break;
                case "d":
                    System.out.print("Enter string witch you want to check: ");
                    if (myLinkedList.isContain(in.nextLine())) {
                        System.out.println("List is contain this element.");
                    } else {
                        System.out.println("List is NOT contain this element.");
                    }
                    break;
                case "e":
                    System.out.println(myLinkedList.toString());
                    break;
                case "f":
                    WriteObjectToFile(filepath, myLinkedList);
                    break;
                case "g":
                    myLinkedList = (MyLinkedList<String>) ReadObjectFromFile(filepath);
                    break;
                case "h":
                    System.out.println("Good buy.");
                    break;
            }

        } while (!choice.equals("h"));


    }

    public static void WriteObjectToFile(String filepath, Object serObj) {

        try {

            FileOutputStream fileOut = new FileOutputStream(filepath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(serObj);
            objectOut.close();
            System.out.println("The Object  was successfully written to a file");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static Object ReadObjectFromFile(String filepath) {

        try {

            FileInputStream fileIn = new FileInputStream(filepath);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            Object obj = objectIn.readObject();

            System.out.println("The Object has been read from the file");
            objectIn.close();
            return obj;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
