package com.codekata.football;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;
import static java.nio.charset.StandardCharsets.UTF_8;
import static java.util.Objects.requireNonNull;

public class FootballMinimizer {
    public List<String> readAllLines(String fileName) {
        List<String> result = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        requireNonNull(getClass().getClassLoader().getResourceAsStream(fileName)), UTF_8))
        ) {
            br.lines().skip(1).forEach(result::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<FootballRow> convertStringRowsToFootballRows(List<String> rowsData) {
        List<FootballRow> footballRows = new ArrayList<>();
        rowsData.forEach(row -> {
            String[] columns = row.trim().split("\\s+");
            if (columns.length == 10) {
                footballRows.add(new FootballRow(
                        columns[1],
                        parseInt(columns[6]),
                        parseInt(columns[8]))
                );
            }
        });
        return footballRows;
    }
}
