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
        System.out.print("Menu: ");
    }
}
