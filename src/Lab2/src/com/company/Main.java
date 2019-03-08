package com.company;

import java.util.Scanner;

public class Main {

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
            System.out.println("g. Exit.");
            System.out.print("Do choice: ");

            choice = in.nextLine();

            switch (choice) {
                case "a":
                    System.out.print("Enter string: ");
                    stringList.add(in.nextLine());
                    break;
                case "b":
                    System.out.print("Enter string: ");
                    if (stringList.remove(in.nextLine())) {
                        System.out.println("String removed.");
                    } else {
                        System.out.println("List hasn't string.");
                    }
                    break;
                case "c":
                    System.out.println();
                    for (String str :
                            stringList) {
                        System.out.println(str);
                    }
                    System.out.println();
                    break;
                case "d":
                    System.out.println(stringList.size());
                    break;
                case "e":
                    if (stringList.contains(in.nextLine())) {
                        System.out.println("List contains.");
                    } else {
                        System.out.println("List doesn't contain.");
                    }
                    break;
                case "f":
                    stringList.clear();
                    break;
                case "g":
                    break;
                default:
                    System.out.println("Menu hasn't variant.");
                    break;
            }


        } while (!choice.equals("g"));

    }
}

