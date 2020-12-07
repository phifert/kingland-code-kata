package com.codekata.football;

import static java.lang.Math.abs;

public class FootballRow {

    private final String clubName;
    private final int differenceInGoalsForAndAgainst;

    public FootballRow(String clubName, int goalsFor, int goalsAgainst) {
        this.clubName = clubName;
        this.differenceInGoalsForAndAgainst = abs(goalsFor - goalsAgainst);
    }

    public int getDifferenceInGoalsForAndAgainst() {
        return differenceInGoalsForAndAgainst;
    }

    @Override
    public String toString() {
        return "[ club name: " + clubName + ", goals difference: " + differenceInGoalsForAndAgainst + " ]";
    }
}
