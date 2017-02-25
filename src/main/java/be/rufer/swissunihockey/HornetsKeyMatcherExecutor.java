/*
 * Copyright (C) 2016 Marc Rufer (m.rufer@gmx.ch)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package be.rufer.swissunihockey;

import be.rufer.swissunihockey.matcher.KeyMatcher;
import be.rufer.swissunihockey.matcher.ResultPrinter;
import be.rufer.swissunihockey.matcher.domain.MatchingResult;
import be.rufer.swissunihockey.matcher.domain.League;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HornetsKeyMatcherExecutor {

    private static final String U21C = "U21C";
    private static final String League1GF = "1. Liga GF";
    private static final int NBR_OF_TEAMS_IN_U21C = 8;
    private static final int NBR_OF_TEAMS_IN_LEAGUE_1_GF = 12;

    public static void main(String[] args) {
        calculateAndPrintHornetsMatches();
    }

    private static void calculateAndPrintHornetsMatches() {
        League league1GF = createLeague1GF();
        League leagueU21C = createLeagueU21C();

        KeyMatcher keyMatcher = new KeyMatcher();
        MatchingResult matchingResult = keyMatcher.findMatchesForTwoLeagues(league1GF, leagueU21C);
        ResultPrinter.print(league1GF, leagueU21C, matchingResult);
    }

    private static League createLeagueU21C() {
        // U21C
        Map<LocalDate, List<Integer>> u21C = new HashMap<>();
        // Date, Keys that play at home at this date
        u21C.put(LocalDate.of(2017, 9, 16), Arrays.asList(1, 2, 3, 4));
        u21C.put(LocalDate.of(2017, 10, 1), Arrays.asList(8, 6, 5, 7));
        u21C.put(LocalDate.of(2017, 10, 7), Arrays.asList(2, 3, 1, 4));
        u21C.put(LocalDate.of(2017, 10, 21), Arrays.asList(6, 4, 5, 1));
        u21C.put(LocalDate.of(2017, 11, 4), Arrays.asList(5, 7, 3, 8));
        u21C.put(LocalDate.of(2017, 11, 11), Arrays.asList(6, 4, 2, 7));
        u21C.put(LocalDate.of(2017, 11, 25), Arrays.asList(1, 3, 8, 5));
        u21C.put(LocalDate.of(2017, 12, 2), Arrays.asList(5, 6, 7, 8));
        u21C.put(LocalDate.of(2017, 12, 16), Arrays.asList(3, 1, 2, 4));
        u21C.put(LocalDate.of(2017, 1, 13), Arrays.asList(7, 5, 8, 6));
        u21C.put(LocalDate.of(2018, 1, 20), Arrays.asList(3, 2, 8, 7));
        u21C.put(LocalDate.of(2018, 2, 3), Arrays.asList(4, 6, 1, 2));
        u21C.put(LocalDate.of(2018, 2, 17), Arrays.asList(8, 1, 3, 5));
        u21C.put(LocalDate.of(2018, 3, 3), Arrays.asList(2, 4, 7, 6));

        return new League(U21C, NBR_OF_TEAMS_IN_U21C, u21C);
    }

    private static League createLeague1GF() {
        // Herren 1. Liga GF
        Map<LocalDate, List<Integer>> league1GF = new HashMap<>();
        // Date, Keys that play at home at this date
        league1GF.put(LocalDate.of(2017, 9, 16), Arrays.asList(1, 3, 5, 7, 9, 11));
        league1GF.put(LocalDate.of(2017, 9, 23), Arrays.asList(10, 8, 6, 4, 12, 2));
        league1GF.put(LocalDate.of(2017, 9, 30), Arrays.asList(1, 3, 5, 7, 12, 11));
        league1GF.put(LocalDate.of(2017, 10, 1), Arrays.asList(10, 8, 6, 4, 9, 2));
        league1GF.put(LocalDate.of(2017, 10, 7), Arrays.asList(1, 3, 5, 4, 12, 11));
        league1GF.put(LocalDate.of(2017, 10, 14), Arrays.asList(10, 8, 1, 7, 9, 2));
        league1GF.put(LocalDate.of(2017, 10, 15), Arrays.asList(5, 3, 6, 4, 12, 11));
        league1GF.put(LocalDate.of(2017, 10, 21), Arrays.asList(10, 8, 5, 7, 9, 2));
        league1GF.put(LocalDate.of(2017, 11, 11), Arrays.asList(1, 10, 6, 4, 12, 11));
        league1GF.put(LocalDate.of(2017, 11, 12), Arrays.asList(1, 3, 5, 7, 9, 2));
        league1GF.put(LocalDate.of(2017, 11, 18), Arrays.asList(10, 8, 6, 4, 12, 11));
        league1GF.put(LocalDate.of(2017, 11, 25), Arrays.asList(2, 4, 6, 8, 10, 12));
        league1GF.put(LocalDate.of(2017, 12, 2), Arrays.asList(7, 5, 3, 11, 1, 9));
        league1GF.put(LocalDate.of(2017, 12, 9), Arrays.asList(9, 8, 10, 2, 4, 6));
        league1GF.put(LocalDate.of(2017, 12, 16), Arrays.asList(3, 11, 12, 1, 7, 5));
        league1GF.put(LocalDate.of(2017, 12, 17), Arrays.asList(7, 2, 9, 6, 8, 10));
        league1GF.put(LocalDate.of(2018, 1, 6), Arrays.asList(12, 4, 6, 5, 3, 11));
        league1GF.put(LocalDate.of(2018, 1, 13), Arrays.asList(1, 7, 8, 10, 2, 9));
        league1GF.put(LocalDate.of(2018, 1, 20), Arrays.asList(6, 1, 3, 11, 12, 4));
        league1GF.put(LocalDate.of(2018, 1, 21), Arrays.asList(3, 8, 2, 9, 7, 5));
        league1GF.put(LocalDate.of(2018, 2, 10), Arrays.asList(10, 11, 12, 4, 6 ,8));
        league1GF.put(LocalDate.of(2018, 2, 11), Arrays.asList(2, 9, 7, 5, 3, 1));

        return new League(League1GF, NBR_OF_TEAMS_IN_LEAGUE_1_GF, league1GF);
    }
}
