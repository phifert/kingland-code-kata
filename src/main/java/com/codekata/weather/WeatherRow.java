package com.codekata.weather;

import static java.lang.Math.abs;

public final class WeatherRow {

    private final int day;
    private final int tempDiff;

    public WeatherRow(int day, int maxTemp, int minTemp) {
        this.day = day;
        this.tempDiff = abs(maxTemp - minTemp);
    }

    public int getTempDiff() {
        return tempDiff;
    }

    @Override
    public String toString() {
        return "[ day: " + day + ", diff: " + tempDiff + " ]";
    }
}
