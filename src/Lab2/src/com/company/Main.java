package com.company;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Main {

    private static final String filepath = "StringList.txt";

    public static int getLetterNumber(char letter) {
        if (letter <= 'z' && letter >= 'a') {
            return letter - 'a' + 1;
        } else if (letter <= 'Z' && letter >= 'A') {
            return letter - 'A' + 1;
        } else {
            return (int) letter;
        }
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String choice;
        StringList stringList = new StringList();

        do {
            System.out.println("MENU:");
            System.out.println("a. Add to list.");
            System.out.println("b. Remove from list.");
            System.out.println("c. Print list.");
            System.out.println("d. Print number of strings.");
            System.out.println("e. Check contain element.");
            System.out.println("f. Clean list.");
            System.out.println("g. Write to file.");
            System.out.println("h. Read from file.");
            System.out.println("i. Sort.");
            System.out.println("j. Print number of letters.");

            System.out.println("k. Exit.");
            System.out.print("Do choice: ");

            choice = in.nextLine();

            switch (choice) {
                case "a":
                    System.out.println("\n======================================");
                    System.out.print("Enter string: ");
                    stringList.add(in.nextLine());
                    System.out.println("======================================\n");
                    break;
                case "b":
                    System.out.println("\n======================================");
                    System.out.print("Enter string: ");
                    if (stringList.remove(in.nextLine())) {
                        System.out.println("String removed.");
                    } else {
                        System.out.println("List hasn't string.");
                    }
                    System.out.println("======================================\n");
                    break;
                case "c":
                    System.out.println("\n======================================");
                    for (String str :
                            stringList) {
                        System.out.println("||   " + str);
                    }
                    System.out.println("======================================\n");
                    break;
                case "d":
                    System.out.println("\n======================================");
                    System.out.printf("List size = %d;\n", stringList.size());
                    System.out.println("======================================\n");
                    break;
                case "e":
                    System.out.println("\n======================================");
                    if (stringList.contains(in.nextLine())) {
                        System.out.println("List contains.");
                    } else {
                        System.out.println("List doesn't contain.");
                    }
                    System.out.println("======================================\n");
                    break;
                case "f":
                    System.out.println("\n======================================");
                    stringList.clear();
                    System.out.println("List cleared.");
                    System.out.println("======================================\n");
                    break;
                case "g":
                    System.out.println("\n======================================");
                    WriteObjectToFile(filepath, stringList);
                    System.out.println("List wrote.");
                    System.out.println("======================================\n");
                    break;
                case "h":
                    System.out.println("\n======================================");
                    stringList = (StringList) ReadObjectFromFile(filepath);
                    System.out.println("List read.");
                    System.out.println("======================================\n");
                case "i":
                    System.out.println("\n======================================");
                    stringList.sort();
                    System.out.println("List sorted.");
                    System.out.println("======================================\n");
                    break;
                case "j":
                    for (String str :
                            stringList) {
                        System.out.println("\n======================================");
                        for (int i = 0; i < str.length(); i++) {
                            System.out.printf("%c  ", str.charAt(i));
                        }
                        System.out.println();
                        for (int i = 0; i < str.length(); i++) {
                            System.out.printf("%d  ", getLetterNumber(str.charAt(i)));
                        }
                        System.out.println();
                        System.out.println("======================================\n");
                    }
                    break;
                default:
                    System.out.println("Menu hasn't variant.");
                    break;
            }


        } while (!choice.equals("k"));

    }

    public static void WriteObjectToFile(String filepath, Object serObj) {

        try {

            FileOutputStream fileOut = new FileOutputStream(filepath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(serObj);
            objectOut.close();
            System.out.println("The Object  was succesfully written to a file");

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

