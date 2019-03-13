package com.company;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    private static final String filepath = "ListOfObjects.txt";

    private static void printTradingPoint(TradingPoint tradingPoint) {
        ArrayList<String> phoneNumbers = tradingPoint.getPhoneNumbers();
        ArrayList<String> workTime = tradingPoint.getWorkTime();

        System.out.println("||\tНазва: " + tradingPoint.getName());
        System.out.println("||\tАдреса: " + tradingPoint.getAddress());
        System.out.println("||\tНомера телефонів: ");
        if (phoneNumbers.size() == 0) {
            System.out.println("||\t||\tНемає номерів.");
        } else {
            for (int i = 0; i < phoneNumbers.size(); i++) {
                System.out.printf("||\t||\t%d. %s\n", i + 1, phoneNumbers.get(i));
            }
        }
        System.out.println("||\tСпеціалізація: " + tradingPoint.getSpecialization());
        System.out.println("||\tЧас роботи: ");
        for (int i = 0; i < workTime.size(); i++) {
            System.out.printf("||\t||\t%d. %s\n", i + 1, workTime.get(i));
        }
    }

    private static void changeValueInTradePoint(TradingPoint tradingPoint) {
        Scanner in = new Scanner(System.in);
        String choice;

        do {

            System.out.println("Оберіть що ви хочите зробити:");
            System.out.println("||\t1. Змінити назву.");
            System.out.println("||\t2. Змінити адресу.");
            System.out.println("||\t3. Додати номер телефону.");
            System.out.println("||\t4. Видалити номер телефону.");
            System.out.println("||\t5. Змінити спеціалізацію.");
            System.out.println("||\t6. Змінити графік роботи.");
            System.out.println("||\t7. Вийти з меню зміни.");

            choice = in.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("||\tВведіть нову назву: ");
                    tradingPoint.setName(in.nextLine());
                    System.out.println("||\tНазва змінена.");
                    break;

                case "2":
                    System.out.print("||\tВведіть нову Адрусу: ");
                    tradingPoint.setAddress(in.nextLine());
                    System.out.println("||\tАдреса змінена.");
                    break;

                case "3":
                    System.out.print("||\tВведіть номер телефону який ви хочете додати: ");
                    tradingPoint.addPhoneNumber(in.nextLine());
                    System.out.println("||\tТелефон додано.");
                    break;

                case "4":
                    System.out.print("||\tВведіть номер телефону який ви хочете видалити: ");
                    tradingPoint.removePhoneNumber(in.nextLine());
                    System.out.println("||\tТепер список номерів має наступний вигляд: ");
                    ArrayList<String> phoneNumbers = tradingPoint.getPhoneNumbers();
                    for (int i = 0; i < phoneNumbers.size(); i++) {
                        System.out.printf("||\t||\t%d. %s\n", i + 1, phoneNumbers.get(i));
                    }
                    break;

                case "5":
                    System.out.print("||\tВведыть нову спеціалізацію: ");
                    tradingPoint.setSpecialization(in.nextLine());
                    System.out.println("||\tСпеціалізація змінена.");
                    break;

                case "6":
                    break;

                default:
                    System.out.println("||\tНеіснуючий пункт меню зміни.");
                    break;

            }

        } while (choice.equals("7"));


    }

    public static void main(String[] args) {
        Locale.setDefault(new Locale("uk", "UA"));

        Scanner in = new Scanner(System.in);
        String choice;

        ArrayList<TradingPoint> tradingPoints = new ArrayList<>();

        tradingPoints.add(new TradingPoint("Hello"));
        tradingPoints.add(new TradingPoint("World"));


        do {
            System.out.println("MENU:");
            System.out.println("a. Показати список об'єктів.");
            System.out.println("b. Подивитися конкретний об'єкт.");
            System.out.println("c. Видалити об'єкт.");
            System.out.println("d. Додати об'єкт.");
            System.out.println("e. Змінити в об'єкті значення.");
            System.out.println("f. Зберегти список обєктів.");
            System.out.println("g. Імпортувати список об'єктів.");
            System.out.println("h. Вихід.");
            System.out.print("Зробіть вибір: ");

            choice = in.nextLine();

            switch (choice) {
                case "a":
                    System.out.println("\n++++++++++");
                    if (tradingPoints.size() == 0) {
                        System.out.println("Список пустий.");
                    } else {
                        for (int i = 0; i < tradingPoints.size(); i++) {
                            System.out.printf("||\t%d. %s;\n", i + 1, tradingPoints.get(i).getName());
                        }
                    }
                    System.out.println("++++++++++\n");
                    break;

                case "b":
                    System.out.println("\n++++++++++");
                    System.out.print("Номер об'єкту: ");
                    int numberOfObject = in.nextInt();
                    in.nextLine();
                    printTradingPoint(tradingPoints.get(numberOfObject - 1));
                    System.out.println("++++++++++\n");
                    break;

                case "c":
                    System.out.println("\n++++++++++");
                    System.out.print("Номер об'єкту: ");
                    int numberOfRemoveObject = in.nextInt();
                    in.nextLine();
                    System.out.printf("Об'єкт %s видалено.\n", tradingPoints.get(numberOfRemoveObject - 1).getName());
                    tradingPoints.remove(numberOfRemoveObject - 1);
                    System.out.println("++++++++++\n");
                    break;

                case "d":
                    System.out.println("\n++++++++++");
                    System.out.print("Назва нового об'єкту: ");
                    String nameOfNewObject = in.nextLine();
                    tradingPoints.add(new TradingPoint(nameOfNewObject));
                    System.out.println("Об'єкт додано в список");
                    System.out.println("++++++++++\n");
                    break;

                case "e":
                    System.out.println("\n++++++++++");
                    System.out.print("Номер об'єкту: ");
                    changeValueInTradePoint(tradingPoints.get(in.nextInt() - 1));
                    in.nextLine();
                    System.out.println("++++++++++\n");
                    break;

                case "f":
                    System.out.println("\n++++++++++");
                    WriteObjectToFile(filepath, tradingPoints);
                    System.out.println("++++++++++\n");
                    break;

                case "g":
                    System.out.println("\n++++++++++");
                    tradingPoints = (ArrayList<TradingPoint>) ReadObjectFromFile(filepath);
                    System.out.println("++++++++++\n");
                    break;

                case "h":
                    System.out.println("\n++++++++++");
                    System.out.println("Завершення роботи.");
                    System.out.println("++++++++++\n");
                    break;

                default:
                    System.out.println("\n++++++++++");
                    System.out.println("Неіснуючий пункт меню.");
                    System.out.println("++++++++++\n");
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
