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
        this.purpose = purpose;
    }

    public void showStepsByMonth(int month) {
        int[] days = monthToData.get(month).days;
        StringJoiner sj = new StringJoiner(", ");

        for (int i = 0; i < days.length; i++) {
            sj.add(String.format("%d день: %d", i, days[i]));
        }

        System.out.println(sj);
    }

    static class MonthData {

        int[] days = new int[30];

        public void addSteps(int day, int steps) {
            days[day] = steps;
        }

        public int getSteps(int day) {
            return days[day];
        }
    }
}
