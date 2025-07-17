package com.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printMenu();
        int userInput = scanner.nextInt();

        while (userInput != 0) {

            // TODO

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

        System.out.println("Меню приложения: ");

        for (int i = 0; i < menuItems.length; i++) {
            System.out.println(i + menuItems[i]);
        }
    }
}
