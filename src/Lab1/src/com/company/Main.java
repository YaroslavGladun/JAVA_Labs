package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean flag = false;

        for (String arg : args) {
            if (arg == "-h")
                System.out.println("This is first OOP JAVA lab.\n" +
                        "by Yaroslav Gladun.");
            if (arg == "-d") {
                flag = true;
            }
        }

        Scanner in = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = in.nextLine();

        for (int i = 0; i < str.length(); i++) {
            if (flag) System.out.printf("%d - ", i + 1);
            System.out.printf("%c  ", str.charAt(i));
        }

        System.out.println();

        for (int i = 0; i < str.length(); i++) {
            if (flag) System.out.printf("%d - ", i + 1);
            if (str.toLowerCase().charAt(i) > 'z' || str.toLowerCase().charAt(i) < 'a') {
                System.out.print("   ");
                continue;
            }
            System.out.printf("%d  ", (int) (str.toLowerCase().charAt(i) - 'a' + 1));
        }
    }
}
