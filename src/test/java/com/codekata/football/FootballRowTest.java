package com.codekata.football;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class FootballRowTest {

    @ParameterizedTest
    @MethodSource
    void shouldTakeGoalsForAndAgainstAndInitializeDiffInConstructor(String name, int goalsFor, int goalsAgainst) {
        assertThat(new FootballRow(name, goalsFor, goalsAgainst).toString())
                .isEqualTo(String.format("[ club name: %s, goals difference: %s ]", name, Math.abs(goalsFor - goalsAgainst)));
    }

    static Stream<Arguments> shouldTakeGoalsForAndAgainstAndInitializeDiffInConstructor() {
        return Stream.of(
                Arguments.of("fakeName1", 10, 20),
                Arguments.of("fakeName2", 20, 10),
                Arguments.of("fakeName3", 20, 20)
        );
    }

}