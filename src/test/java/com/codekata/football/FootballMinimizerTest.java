package com.codekata.football;

import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;

public class FootballMinimizerTest {

    @Test
    void shouldReadLinesOfFiles() {
        FootballMinimizer footballMinimizer = new FootballMinimizer();
        List<String> footballLines = footballMinimizer.readAllLines("football.dat");

        assertThat(footballLines).hasSizeGreaterThan(1);
    }

    @Test
    void shouldConvertStringsToFootballRows() {
        FootballMinimizer footballMinimizer = new FootballMinimizer();
        String rowsData = "    1. Arsenal         38    26   9   3    79  -  36    87";
        List<FootballRow> footballRows = footballMinimizer.convertStringRowsToFootballRows(singletonList(rowsData));

        assertThat(footballRows).hasSize(1);
        assertThat(footballRows.get(0).toString()).isEqualTo("[ club name: Arsenal, goals difference: 43 ]");
    }

    @Test
    void shouldReturnEmptyListWhenColumnCountIsNotTen() {
        FootballMinimizer footballMinimizer = new FootballMinimizer();
        String rowsData = "   -------------------------------------------------------";
        List<FootballRow> footballRows = footballMinimizer.convertStringRowsToFootballRows(singletonList(rowsData));

        assertThat(footballRows).isEmpty();
    }
}
