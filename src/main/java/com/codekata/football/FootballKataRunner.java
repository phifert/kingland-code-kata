package com.codekata.football;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class FootballKataRunner {

    public static void main(String... args) {
        FootballMinimizer footballMinimizer = new FootballMinimizer();
        List<String> footballData = footballMinimizer.readAllLines("football.dat");
        List<FootballRow> footballRows = footballMinimizer.convertStringRowsToFootballRows(footballData);
        Optional<FootballRow> footballRowWithSmallestDifference = footballRows.stream()
                .min(Comparator.comparingInt(FootballRow::getDifferenceInGoalsForAndAgainst));

        System.out.println(footballRowWithSmallestDifference.isPresent() ? footballRowWithSmallestDifference.get() : "didn't work");
    }
}
