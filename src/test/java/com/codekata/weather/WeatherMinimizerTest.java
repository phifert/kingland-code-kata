package com.codekata.weather;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WeatherMinimizerTest {

    @Test
    void shouldReadLinesOfFileBeginningWithThirdRow() {
        WeatherMinimizer weatherMinimizer = new WeatherMinimizer();
        List<String> weatherLines = weatherMinimizer.readAllLines("weather.dat");

        assertThat(weatherLines).hasSize(30);
    }

    @Test
    void shouldConvertStringsToWeatherRows() {
        WeatherMinimizer weatherMinimizer = new WeatherMinimizer();
        String rowsData = "   1  88    59    74          53.8       0.00 F       280  9.6 270  17  1.6  93 23 1004.5";

        WeatherRow convertedRow = weatherMinimizer.convertStringRowToWeatherRow(rowsData);

        assertThat(convertedRow.toString()).isEqualTo("[ day: 1, diff: 29 ]");
    }
}
