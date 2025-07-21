package com.example;

public class Converter {

    public static int stepsToKilometers(int steps) {
        return (int) Math.round(steps * 0.75 / 1000);
    }

    public static int stepsToKiloCalories(int steps) {
        return steps * 50 / 1000;
    }
}
