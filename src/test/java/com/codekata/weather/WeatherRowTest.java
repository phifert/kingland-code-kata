package com.codekata.weather;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class WeatherRowTest {

    @ParameterizedTest
    @MethodSource
    void shouldTakeDayMinAndMaxAndInitializeDiffInConstructor(int day, int minTemperature, int maxTemperature, String expectedToString) {
        assertThat(new WeatherRow(day, minTemperature, maxTemperature).toString()).isEqualTo(expectedToString);
    }

    static Stream<Arguments> shouldTakeDayMinAndMaxAndInitializeDiffInConstructor() {
        return Stream.of(
                Arguments.of(1, 50, 20, String.format("[ day: %s, diff: %s ]", 1, (50 - 20))),
                Arguments.of(2, 88, 61, String.format("[ day: %s, diff: %s ]", 2, (88 - 61))),
                Arguments.of(3, 0, 0, String.format("[ day: %s, diff: %s ]", 3, (0))),
                Arguments.of(4, 99, 99, String.format("[ day: %s, diff: %s ]", 4, (0)))
        );
    }

}