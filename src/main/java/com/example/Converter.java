package com.example;

public class Converter {

    public static int stepsToMeters(int steps) {
        return (int) Math.round(steps * 0.75);
    }

    public static int stepsToCalories(int steps) {
        return steps * 50 / 1000;
    }
}
