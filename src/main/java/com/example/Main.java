package com.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printMenu();
        int userInput = scanner.nextInt();
        StepTracker stepTracker = new StepTracker();

        while (userInput != 0) {

            switch (userInput) {
                case 1:
                    System.out.print("Введите количество шагов: ");
                    int steps = scanner.nextInt();
                    break;
                case 2:
                    System.out.print("Введите номер месяца: ");
                    System.out.println("Статистика за выбранный месяц " + scanner.nextInt());
                    break;
                case 3:
                    System.out.print("Введите новую цель по шагам: ");
                    stepTracker.setPurpose(scanner.nextInt());
                    break;
                default:
                    System.out.println("Такой команды нет");
            }

            printMenu();
            userInput = scanner.nextInt();
        }
    }

    private static void printMenu() {
        String[] menuItems = {
                "Выйти из приложения",
                "Кол-во шагов за день",
                "Статистика за месяц",
                "Изменить цель по кол-ву шагов в день"
        };

        for (int i = 0; i < menuItems.length; i++) {
            System.out.printf("%d. %s\n", i, menuItems[i]);
        }

        System.out.print("Введите пункт меню: ");
    }
}
