package com.company;

public class Debug {
    public static boolean debug;

    static {
        debug = false;
    }

    public static void printHelp()
    {
        System.out.println("Developer: Yaroslav Gladun." +
                "\nProduct: 1.0.0.0" +
                "\nDate of building: 07.03.2017 18:39");
    }
}
