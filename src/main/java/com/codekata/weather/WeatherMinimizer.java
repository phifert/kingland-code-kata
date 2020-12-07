package com.codekata.weather;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;
import static java.nio.charset.StandardCharsets.UTF_8;
import static java.util.Objects.requireNonNull;

public class WeatherMinimizer {

    public List<String> readAllLines(String fileName) {
        List<String> result = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        requireNonNull(getClass().getClassLoader().getResourceAsStream(fileName)), UTF_8))
        ) {
            br.lines().skip(2).limit(30).forEach(result::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public WeatherRow convertStringRowToWeatherRow(String dataRow) {
        String[] rowProperties = dataRow.trim().split("\\s+");
        return new WeatherRow(
                parseInt(rowProperties[0].replaceAll("[^\\d]+", "")),
                parseInt(rowProperties[1].replaceAll("[^\\d]+", "")),
                parseInt(rowProperties[2].replaceAll("[^\\d]+", ""))
        );
    }
}
