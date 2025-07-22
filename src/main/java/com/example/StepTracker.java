package com.example;

import java.util.HashMap;
import java.util.StringJoiner;

public class StepTracker {

    private int purpose = 10000;
    HashMap<Integer, MonthData> monthToData = new HashMap<>();

    public StepTracker() {
        for (int i = 0; i < 12; i++) {
            monthToData.put(i, new MonthData());
        }
    }

    public int getPurpose() {
        return purpose;
    }

    public void setPurpose(int purpose) {
        this.purpose = Math.max(purpose, 0);
    }

    public void addSteps(int month, int day, int steps) {
        MonthData monthData = monthToData.get(month);
        monthData.addSteps(day, steps);
    }

    public void showMonthlyStatistics(int month) {
        MonthData monthData = monthToData.get(month);

        System.out.println("Кол-во пройденных шагов: " + monthData.getAllSteps());
        System.out.println("Общее количество шагов за месяц равно " + monthData.getTotalSteps());
        System.out.println("Максимальное кол-во шагов за месяц " + monthData.getMaxSteps());
        System.out.println("Среднее количество шагов " + monthData.getAverageSteps());
        System.out.println("Пройденная дистанция (в км) " + monthData.getDistance());
        System.out.println("Кол-во сожжённых калорий: " + monthData.getCalories());
        System.out.println("Лучшая серия: " + monthData.getBestSeries(purpose));
    }

    private static class MonthData {

        private final int[] days;

        MonthData() {
            days = new int[30];
        }

        public void addSteps(int day, int steps) {
            days[day] = Math.max(steps, 0);
        }

        public int getSteps(int day) {
            return days[day];
        }

        public String getAllSteps() {
            StringJoiner sj = new StringJoiner(", ");

            for (int i = 0; i < days.length; i++) {
                sj.add(String.format("%d день: %d", i, days[i]));
            }

            return sj.toString();
        }

        public int getTotalSteps() {
            int totalSteps = 0;

            for (int day : days) {
                totalSteps += day;
            }

            return totalSteps;
//            return Arrays.stream(days).sum();
        }

        public int getMaxSteps() {
            int maxSteps = 0;

            for (int day : days) {
                maxSteps = Math.max(maxSteps, day);
            }

            return maxSteps;
//            return Arrays.stream(days).max().getAsInt();
        }

        public int getAverageSteps() {
            return getTotalSteps() / days.length;
//            return (int) Arrays.stream(days).average().getAsDouble();
        }

        public int getDistance() {
            return Converter.stepsToKilometers(getTotalSteps());
        }

        public int getCalories() {
            return Converter.stepsToKiloCalories(getTotalSteps());
        }

        public int getBestSeries(int purpose) {
            int maxSeries = 0;
            int tmp = 0;

            for (int day : days) {
                if (day > purpose) {
                    tmp++;
                    maxSeries = Math.max(maxSeries, tmp);
                } else {
                    tmp = 0;
                }
            }

            return maxSeries;
        }
    }
}
