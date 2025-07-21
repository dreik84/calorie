package com.example;

import java.util.Arrays;
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
        this.purpose = purpose;
    }

    public void addStepsToMonth(int month, int day, int steps) {
        MonthData monthData = monthToData.get(month);
        monthData.addSteps(day, steps);
    }

    public void showStepsByMonth(int month) {
        int[] days = monthToData.get(month).days;
        StringJoiner sj = new StringJoiner(", ");

        for (int i = 0; i < days.length; i++) {
            sj.add(String.format("%d день: %d", i, days[i]));
        }

        System.out.println(sj);
    }

    public void showTotalStepsByMonth(int month) {
        MonthData monthData = monthToData.get(month);
        System.out.println("Общее количество шагов за месяц равно " + monthData.getTotalSteps());
    }

    static class MonthData {

        int[] days = new int[30];

        public void addSteps(int day, int steps) {
            days[day] = Math.max(steps, 0);
        }

        public int getSteps(int day) {
            return days[day];
        }

        public int getTotalSteps() {
            int totalSteps = 0;

            for (int day : days) {
                totalSteps += day;
            }

            return totalSteps;
//            return Arrays.stream(days).sum();
        }
    }
}
