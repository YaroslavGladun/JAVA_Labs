package com.company;

import java.util.Scanner;

public class Main {

    public static void printStrBuffer(StringBuffer stringBuffer)
    {
        System.out.println("______________");
        System.out.println(stringBuffer);
        System.out.println("______________");
    }

    public static int getLetterNumber(char letter) {
        if (letter <= 'z' && letter >= 'a') {
            return letter - 'a' + 1;
        } else if (letter <= 'Z' && letter >= 'A') {
            return letter - 'A' + 1;
        } else {
            return (int) letter;
        }
    }

    public static String findElementNumber(String sentence) {
        String resultSentence = "";

        for (int i = 0; i < sentence.length(); i++) {
            resultSentence += sentence.charAt(i) + "  ";
        }

        resultSentence += '\n';

        for (int i = 0; i < sentence.length(); i++) {
            resultSentence += getLetterNumber(sentence.charAt(i)) + "  ";
        }

        return resultSentence;
    }

    public static void main(String[] args) {

        for (String str : args) {
            if (str == "-h" || str == "-help") {
                Debug.printHelp();
                return;
            }
            if (str == "-d" || str == "-debug") {
                Debug.debug = true;
            }
        }

        Scanner in = new Scanner(System.in);

        String sentence = null;
        String resultSentence = null;
        String choice;

        do {
            System.out.println("MENU:");
            System.out.println("a. Set data.");
            System.out.println("b. Show data.");
            System.out.println("c. Do count.");
            System.out.println("d. Show result.");
            System.out.println("e. Exit.");
            System.out.print("Do choice: ");

            choice = in.nextLine();

            switch (choice) {
                case "a":
                    sentence = in.nextLine();
                    break;
                case "b":
                    if (sentence != null) {
                        System.out.println(sentence);
                    } else {
                        System.out.println("Data isn't inputted.");
                    }
                    break;
                case "c":
                    if (sentence != null) {
                        resultSentence = findElementNumber(sentence);
                    } else {
                        System.out.println("Data isn't inputted.");
                    }
                    break;
                case "d":
                    if (resultSentence != null) {
                        System.out.println(resultSentence);
                    } else {
                        System.out.println("Count didn't did.");
                    }
                    break;
                case "e":
                    break;
                default:
                    System.out.println("Haven't variant.");
                    break;
            }


        } while (!choice.equals("e"));


    }
}
