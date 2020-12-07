package com.codekata.weather;

import java.util.Comparator;
import java.util.Optional;

public class WeatherKataRunner {

    public static void main(String... args) {
        WeatherMinimizer weatherMinimizer = new WeatherMinimizer();
        Optional<WeatherRow> weatherRow = weatherMinimizer.readAllLines("weather.dat").stream()
                .map(weatherMinimizer::convertStringRowToWeatherRow)
                .min(Comparator.comparingInt(WeatherRow::getTempDiff));

        System.out.println(weatherRow.isPresent() ? weatherRow.get() : "didn't work");
    }
}
